package com.xxxx.entity;

/**
 * @author Fei
 * @date 2020/9/11 11:12
 */

public class Deal {
    //TODO: Need to complete this class in order to consistent with deal data structure in deal_form.
    public String Company_Name;
    public int Deal_No;


    public Deal(String Company_Name, Integer Deal_No) {
        this.Company_Name = Company_Name;
        this.Deal_No = Deal_No;

    }

    public String getCompany_Name() {
        return Company_Name;
    }

    public void setCompany_Name(String company_Name) {
        this.Company_Name = company_Name;
    }

    public Integer getDeal_No() {
        return Deal_No;
    }

    public void setDeal_No(Integer deal_No) {
        this.Deal_No = deal_No;
    }
}
