package ru.trener.testingproject.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Map;

import ru.trener.testingproject.App;
import ru.trener.testingproject.R;
import ru.trener.testingproject.di.modules.VideoUrlsResponse;
import ru.trener.testingproject.ui.base.BaseActivity;
import ru.trener.testingproject.ui.video.PlayVideoActivity;

public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    TextView date, liga, team1,team2, score1,score2;
    RecyclerView recyclerView;
    VideosAdapter videosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.applicationComponent.inject(this);
        if (mainPresenter == null){
            mainPresenter = new MainPresenter();
        }
        mainPresenter.setView(this);
        mainPresenter.getPosts("get_match_info",1,1724836);
        mainPresenter.getVideoUrls(1,1724836);

        date = findViewById(R.id.tvDateVal);
        liga = findViewById(R.id.tvLigaVal);
        team1 = findViewById(R.id.tvTeam1);
        team2 = findViewById(R.id.tvTeam2);
        score1 = findViewById(R.id.tvScore1);
        score2 = findViewById(R.id.tvScore2);
        recyclerView = findViewById(R.id.rvVideo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        videosAdapter = new VideosAdapter();
        videosAdapter.setVideoUrlsListener(new VideosAdapter.VideoUrlsListener() {
            @Override
            public void itemClickListener(VideoUrlsResponse item) {
                Intent intent = new Intent(MainActivity.this,PlayVideoActivity.class);
                intent.putExtra("videoUrl",item.getUrl());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(videosAdapter);
    }

    @Override
    public void getMatchInfo(String date, Map<String, Object> tournament, Map<String, Object> team1, Map<String, Object> team2) {
        this.date.setText(date);
        if (tournament.containsKey("name_rus")){
            liga.setText((String)tournament.get("name_rus"));
        }
        if (team1.containsKey("name_rus")){
            this.team1.setText((String)team1.get("name_rus"));
        }
        if (team2.containsKey("name_rus")){
            this.team2.setText((String)team2.get("name_rus"));
        }
        if (team1.containsKey("score")){
            double t1 = (Double) team1.get("score");
            this.score1.setText(String.valueOf((int)t1));
        }
        if (team2.containsKey("score")){
            double t2 = (Double) team2.get("score");
            this.score2.setText(String.valueOf((int)t2));
        }
    }

    @Override
    public void getVideoUrls(List<VideoUrlsResponse> urls) {
        videosAdapter.setVideoUrlsResponseList(urls);
    }
}