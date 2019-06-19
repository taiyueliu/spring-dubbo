package com.liutaiyue.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liutaiyue.dubbo.api.UserApi;
import com.liutaiyue.dubbo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘太月
 * @Despriction
 * @Created in 2019/6/19 15:52
 * @version: 1.0
 * <p>copyright: Copyright (c) 2018</p>
 */
@RestController
public class userController {
    /**
     * dubbo 消费者注解 对应提供者的版本  dubbox消费者只需要消费公共api
     */
    @Reference(version = "1.0.0")
    private UserApi userApi;
    @GetMapping(value="/dubbo/user/{id}")
    @ResponseBody
    public User sayHello(@PathVariable("id") Integer id){
        return userApi.getUser(id);
    }

}
