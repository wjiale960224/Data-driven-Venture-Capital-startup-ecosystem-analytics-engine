package com.xxxx.entity.overview;

public class SeriesData {
    Integer No_Series_A;
    Integer No_Series_B;
    Integer No_Series_C;
    Integer No_Series_Pre;
    Integer No_Series_Seed;
    Integer null_value;
    String update_date;

    public SeriesData(Integer no_Series_A, Integer no_Series_B, Integer no_Series_C, Integer no_Series_Pre, Integer no_Series_Seed, Integer null_value, String update_date) {
        No_Series_A = no_Series_A;
        No_Series_B = no_Series_B;
        No_Series_C = no_Series_C;
        No_Series_Pre = no_Series_Pre;
        No_Series_Seed = no_Series_Seed;
        this.null_value = null_value;
        this.update_date = update_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public Integer getNo_Series_A() {
        return No_Series_A;
    }

    public void setNo_Series_A(Integer no_Series_A) {
        No_Series_A = no_Series_A;
    }

    public Integer getNo_Series_B() {
        return No_Series_B;
    }

    public void setNo_Series_B(Integer no_Series_B) {
        No_Series_B = no_Series_B;
    }

    public Integer getNo_Series_C() {
        return No_Series_C;
    }

    public void setNo_Series_C(Integer no_Series_C) {
        No_Series_C = no_Series_C;
    }

    public Integer getNo_Series_Pre() {
        return No_Series_Pre;
    }

    public void setNo_Series_Pre(Integer no_Series_Pre) {
        No_Series_Pre = no_Series_Pre;
    }

    public Integer getNo_Series_Seed() {
        return No_Series_Seed;
    }

    public void setNo_Series_Seed(Integer no_Series_Seed) {
        No_Series_Seed = no_Series_Seed;
    }

    public Integer getNull_value() {
        return null_value;
    }

    public void setNull_value(Integer null_value) {
        this.null_value = null_value;
    }
}
