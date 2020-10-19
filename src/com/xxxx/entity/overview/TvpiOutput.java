package com.xxxx.entity.overview;

public class TvpiOutput {
    String date;
    Double tvpi;

    public TvpiOutput(String date, Double tvpi) {
        this.date = date;
        this.tvpi = tvpi;
    }

    public String getData() {
        return date;
    }

    public void setData(String date) {
        this.date = date;
    }

    public Double getTvpi() {
        return tvpi;
    }

    public void setTvpi(Double tvpi) {
        this.tvpi = tvpi;
    }
}
