package com.liutaiyue.dubbo.entity;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * @Author 刘太月
 * @Despriction 实体类需要序列化
 * @Created in 2019/6/19 15:21
 * @version: 1.0
 * <p>copyright: Copyright (c) 2018</p>
 */
public class User implements Serializable{
    private Integer id;

    private String name;

    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}
