package com.xxxx.entity.overview;

public class IndividualSeries {
    Integer deal_id;
    String series;
    String update_date;

    public IndividualSeries(Integer deal_id, String series, String update_date) {
        this.deal_id = deal_id;
        this.series = series;
        this.update_date = update_date;
    }

    public Integer getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(Integer deal_id) {
        this.deal_id = deal_id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }
}
