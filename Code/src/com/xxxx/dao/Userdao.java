package com.xxxx.dao;

import com.xxxx.entity.User;

/**
 * 接口类
 */

public interface Userdao {
    public User queryUserByname(String user_name);
}
