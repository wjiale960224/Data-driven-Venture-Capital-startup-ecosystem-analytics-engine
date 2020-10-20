package com.xxxx.entity.overview;

public class TvpiData {
    String Date;
    Double Tvpi;

    public TvpiData(String date, Double tvpi) {
        Tvpi = tvpi;
        Date = date;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Double getTvpi() {
        return Tvpi;
    }

    public void setTvpi(Double tvpi) {
        Tvpi = tvpi;
    }

}
