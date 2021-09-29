package ru.trener.testingproject.ui.video;

import android.net.Uri;
import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

import ru.trener.testingproject.App;
import ru.trener.testingproject.R;
import ru.trener.testingproject.ui.base.BaseActivity;

public class PlayVideoActivity extends BaseActivity implements PlayVideoView {

    @InjectPresenter
    PlayVideoPresenter playVideoPresenter;
    private SimpleExoPlayer exoplayer;
    private String videoUrl = "";
    private DefaultHttpDataSourceFactory dataSourceFactory;
    private com.google.android.exoplayer2.ui.SimpleExoPlayerView exoplayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        App.applicationComponent.inject(this);
        if (playVideoPresenter == null){
            playVideoPresenter = new PlayVideoPresenter();
        }

        videoUrl = getIntent().getExtras().getString("videoUrl");
        exoplayerView = findViewById(R.id.exoplayerView);

        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
        exoplayer = ExoPlayerFactory.newSimpleInstance(this,trackSelector);
        Uri videoUri = Uri.parse(videoUrl);
        dataSourceFactory =new DefaultHttpDataSourceFactory("exoplayer_video");
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        MediaSource mediaSource =new ExtractorMediaSource(videoUri, dataSourceFactory, extractorsFactory, null, null);

        exoplayerView.setPlayer(exoplayer);

        exoplayer.prepare(mediaSource);

        exoplayer.setPlayWhenReady(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        exoplayer.stop();
    }
}