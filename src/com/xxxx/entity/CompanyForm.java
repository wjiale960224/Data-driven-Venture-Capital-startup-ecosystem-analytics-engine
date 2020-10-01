package com.xxxx.entity;

public class CompanyForm {
    String c_name;
    String theme;
    String Year_Founded;
    String Runway_End_Date;
    String Raise_to_Date;
    String Employee_No;
    String Revenue;
    String Present_Valuation;
    String Valuation_Change_reason;
    String MSEQ_Investment_Cur_Val;
    String Own_Percent;

    public CompanyForm() {}

    public Company toCompany() {
        Company result = new Company();

        result.setCompany_name(this.c_name);

        if (this.theme.toLowerCase().contains("exponential"))
            result.setTheme(Theme.Exponential_Machines);
        if (this.theme.toLowerCase().contains("feeding"))
            result.setTheme(Theme.Feeding_10B_People);
        if (this.theme.toLowerCase().contains("humanity"))
            result.setTheme(Theme.Humanity_Scale_Healthcare);
        if (this.theme.toLowerCase().contains("society"))
            result.setTheme(Theme.New_Society);
        if (this.theme.toLowerCase().contains("space"))
            result.setTheme(Theme.Space_Transport);

        result.setYear_founded(Integer.parseInt(this.Year_Founded));

        result.setRunway_end_date(this.Runway_End_Date);

        return result;
    }
}
