package com.xxxx.service;

import com.xxxx.dao.Userdao;
import com.xxxx.entity.User;
import com.xxxx.entity.msg.MessageModel;
import com.xxxx.util.GetSqlSession;
import com.xxxx.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public MessageModel userLogin(String uname, String upwd){
        MessageModel messageModel = new MessageModel();
        User u = new User();
        u.setUser_name(uname);
        u.setUser_pwd(upwd);
        messageModel.setObject(u);
        if (StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)){
            messageModel.setCode(0);
            messageModel.setMsg("User name and password cannot be empty");
            return messageModel;
        }
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        User user = userdao.queryUserByname(uname);

        if (user == null){
            messageModel.setCode(0);
            messageModel.setMsg("User name not exist");
            return messageModel;
        }
        if (!upwd.equals(user.getUser_pwd())){
            messageModel.setCode(0);
            messageModel.setMsg("User password not correct");
            return messageModel;
        }
        messageModel.setObject(user);
        return messageModel;

    }
}
