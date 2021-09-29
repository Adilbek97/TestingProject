package ru.trener.testingproject.ui.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import ru.trener.testingproject.models.MatchBody;
import ru.trener.testingproject.models.Params;
import ru.trener.testingproject.ui.base.presenters.BasePresenter;

public class MainPresenter extends BasePresenter<MainView> {
    CompositeDisposable disposable = new CompositeDisposable();

    public void getPosts(String proc, int pSport, int pMatchId) {
        MatchBody matchBody = new MatchBody(proc,new Params(pSport,pMatchId));
                getApi().getMatchInfo(matchBody).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Map<String,Object>>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull Map<String,Object> o) {
                                SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                Date date = null;
                                try {
                                    String dateS = (String) o.get("date");
                                    date = parser.parse(dateS);
                                    Object tournament = o.get("tournament");
                                    Map<String, Object> tournamentMap = null,team1Map = null,team2Map = null;
                                    if (tournament instanceof Map) {
                                        tournamentMap = (Map<String, Object>) tournament;
                                    }
                                    Object team1 = o.get("team1");
                                    if (team1 instanceof Map) {
                                        team1Map = (Map<String, Object>) team1;
                                    }
                                    Object team2 = o.get("team2");
                                    if (team1 instanceof Map) {
                                        team2Map = (Map<String, Object>) team2;
                                    }
                                    getView().getMatchInfo(formatter.format(date),tournamentMap,team1Map,team2Map);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
    }

    public void getVideoUrls(int sportId, int matchId) {
        VideoUrlsBody videoUrlsBody = new VideoUrlsBody(matchId, sportId);
        getApi().getVideoUrls(videoUrlsBody).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<VideoUrlsResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<VideoUrlsResponse> o) {
                        getView().getVideoUrls(o);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
