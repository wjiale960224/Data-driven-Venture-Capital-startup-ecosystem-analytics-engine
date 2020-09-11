package com.xxxx.entity;

/**
 * @author Fei
 * @date 2020/9/10 17:27
 */
public class Company {
    //TODO: Need to complete this class in order to consistent with company data structure in company_form.
    public String Company_Name;
    public String Stage;

    public Company() {
    }

    public Company(String company_Name, String stage) {
        Company_Name = company_Name;
        Stage = stage;
    }

    public String getCompany_Name() {
        return Company_Name;
    }

    public void setCompany_Name(String company_Name) {
        Company_Name = company_Name;
    }

    public String getStage() {
        return Stage;
    }

    public void setStage(String stage) {
        Stage = stage;
    }
}
