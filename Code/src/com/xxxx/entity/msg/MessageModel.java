package com.xxxx.entity.msg;

/**
 * 实体类
 * 成功或者失败返回前端信息
 */

public class MessageModel {
    private Integer code = 1; //默认成功
    private String msg = "Success";
    private Object object;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
