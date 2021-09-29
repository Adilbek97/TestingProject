package ru.trener.testingproject.di.services;


import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.trener.testingproject.di.modules.VideoUrlsBody;
import ru.trener.testingproject.di.modules.VideoUrlsResponse;
import ru.trener.testingproject.models.MatchBody;

public interface Api {

    @POST("test/data")
    public Observable<Map<String,Object>> getMatchInfo(@Body MatchBody matchBody);

    @POST("test/video-urls")
    public Observable<List<VideoUrlsResponse>> getVideoUrls(@Body VideoUrlsBody videoUrlsBody);
}
