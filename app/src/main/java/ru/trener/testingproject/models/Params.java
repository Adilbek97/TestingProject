package ru.trener.testingproject.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Params {

    @SerializedName("_p_sport")
    @Expose
    private int pSport;
    @SerializedName("_p_match_id")
    @Expose
    private int pMatchId;

    public Params(int pSport, int pMatchId) {
        this.pSport = pSport;
        this.pMatchId = pMatchId;
    }

    public int getPSport() {
        return pSport;
    }

    public void setPSport(int pSport) {
        this.pSport = pSport;
    }

    public int getPMatchId() {
        return pMatchId;
    }

    public void setPMatchId(int pMatchId) {
        this.pMatchId = pMatchId;
    }

}
