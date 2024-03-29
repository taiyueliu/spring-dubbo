package com.liutaiyue.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.liutaiyue.dubbo.api.UserApi;
import com.liutaiyue.dubbo.entity.User;
import com.liutaiyue.filter.FacadeAccessFilter;
import org.springframework.stereotype.Component;

/**
 * @Author lty
 * @Despriction dubbo 提供者 <p>提供者需要实现 公共api</p>
 * @Created in 2019/6/19 15:41
 * @version: 1.0
 * <p>copyright: Copyright (c) 2018</p>
 */

@Component
@Service(version = "1.0.0",timeout = 10000,interfaceClass = UserApi.class)//dubbo 提供者注解
public class UserServiceImpl implements UserApi{
    private static final long serialVersionUID = 5231134212346077681L;
    @Override
    public User getUser(Integer id) {
        return new User(){{setId(id);setName("adou");setPhone("17521240181");}};
    }
}
