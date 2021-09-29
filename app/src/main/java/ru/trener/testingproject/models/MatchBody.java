package ru.trener.testingproject.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchBody {
    @SerializedName("proc")
    @Expose
    private String proc;
    @SerializedName("params")
    @Expose
    private Params params;

    public MatchBody(String proc, Params params) {
        this.proc = proc;
        this.params = params;
    }

    public String getProc() {
        return proc;
    }

    public void setProc(String proc) {
        this.proc = proc;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

}
