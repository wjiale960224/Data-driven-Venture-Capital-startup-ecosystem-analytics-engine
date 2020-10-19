package com.xxxx.entity.overview;

public class TvpiData {
    String Date;
    Double Tvpi;
    Integer mseq_invest_to_date;
    Double cumu_post_value;
    Double cumu_acquire_percent;

    public TvpiData(String date, Double tvpi, Integer mseq_invest_to_date, Double cumu_post_value, Double cumu_acquire_percent) {
        Tvpi = tvpi;
        Date = date;
        this.mseq_invest_to_date = mseq_invest_to_date;
        this.cumu_post_value = cumu_post_value;
        this.cumu_acquire_percent = cumu_acquire_percent;
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

    public Integer getMseq_invest_to_date() {
        return mseq_invest_to_date;
    }

    public void setMseq_invest_to_date(Integer mseq_invest_to_date) {
        this.mseq_invest_to_date = mseq_invest_to_date;
    }

    public Double getCumu_post_value() {
        return cumu_post_value;
    }

    public void setCumu_post_value(Double cumu_post_value) {
        this.cumu_post_value = cumu_post_value;
    }

    public Double getCumu_acquire_percent() {
        return cumu_acquire_percent;
    }

    public void setCumu_acquire_percent(Double cumu_acquire_percent) {
        this.cumu_acquire_percent = cumu_acquire_percent;
    }
}
