package ru.trener.testingproject.di.modules;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoUrlsResponse {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("match_id")
    @Expose
    private int matchId;
    @SerializedName("period")
    @Expose
    private int period;
    @SerializedName("server_id")
    @Expose
    private int serverId;
    @SerializedName("quality")
    @Expose
    private String quality;
    @SerializedName("folder")
    @Expose
    private String folder;
    @SerializedName("video_type")
    @Expose
    private String videoType;
    @SerializedName("abc")
    @Expose
    private String abc;
    @SerializedName("start_ms")
    @Expose
    private int startMs;
    @SerializedName("checksum")
    @Expose
    private long checksum;
    @SerializedName("size")
    @Expose
    private int size;
    @SerializedName("abc_type")
    @Expose
    private String abcType;
    @SerializedName("duration")
    @Expose
    private int duration;
    @SerializedName("fps")
    @Expose
    private int fps;
    @SerializedName("url_root")
    @Expose
    private String urlRoot;
    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public int getStartMs() {
        return startMs;
    }

    public void setStartMs(int startMs) {
        this.startMs = startMs;
    }

    public long getChecksum() {
        return checksum;
    }

    public void setChecksum(long checksum) {
        this.checksum = checksum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getAbcType() {
        return abcType;
    }

    public void setAbcType(String abcType) {
        this.abcType = abcType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public String getUrlRoot() {
        return urlRoot;
    }

    public void setUrlRoot(String urlRoot) {
        this.urlRoot = urlRoot;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
