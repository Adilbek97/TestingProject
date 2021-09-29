package ru.trener.testingproject.ui.main;

import java.util.List;
import java.util.Map;

import ru.trener.testingproject.di.modules.VideoUrlsResponse;
import ru.trener.testingproject.ui.base.views.BaseView;

public interface MainView extends BaseView {

    public void getMatchInfo(String date, Map<String, Object> tournament, Map<String,Object> team1, Map<String,Object> team2);

    void getVideoUrls(List<VideoUrlsResponse> urls);
}
