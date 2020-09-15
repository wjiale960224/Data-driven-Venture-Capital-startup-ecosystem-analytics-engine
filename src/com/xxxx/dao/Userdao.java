package com.xxxx.dao;

import com.xxxx.entity.Company;
import com.xxxx.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口类
 */

public interface Userdao {
    // call SQL query prepared in Userdao.xml

    public User queryUserByname(String user_name);

    public int add(@Param("user_name") String user_name, @Param("user_pwd") String user_pwd);

    public List<Double> queryPostValueByCompany(String company_name);
}
