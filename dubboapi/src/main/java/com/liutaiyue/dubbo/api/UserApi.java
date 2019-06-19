package com.liutaiyue.dubbo.api;

import com.liutaiyue.dubbo.entity.User;

import java.io.Serializable;

/**
 * @Author lty
 * @Despriction dubbo api
 * @Created in 2019/6/19 15:26
 * @version: 1.0
 * <p>copyright: Copyright (c) 2018</p>
 */
public interface UserApi extends Serializable{
    User getUser(Integer id);
}
