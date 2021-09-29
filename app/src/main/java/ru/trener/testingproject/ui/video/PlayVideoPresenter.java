package ru.trener.testingproject.ui.video;

import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.trener.testingproject.di.modules.VideoUrlsBody;
import ru.trener.testingproject.di.modules.VideoUrlsResponse;
import ru.trener.testingproject.ui.base.presenters.BasePresenter;

public class PlayVideoPresenter extends BasePresenter<PlayVideoView> {
    CompositeDisposable disposable = new CompositeDisposable();



    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
