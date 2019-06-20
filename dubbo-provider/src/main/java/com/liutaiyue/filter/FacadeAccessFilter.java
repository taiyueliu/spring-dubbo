package com.liutaiyue.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.validation.filter.ValidationFilter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author 刘太月
 * @Despriction
 * @Created in 2019/6/20 14:23
 * @version: 1.0
 * <p>copyright: Copyright (c) 2018</p>
 */
@Activate(group = { Constants.CONSUMER, Constants.PROVIDER })
public class FacadeAccessFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Properties prop = new Properties();
        InputStream in = ValidationFilter.class.getResourceAsStream("/ipwhitelist.properties");
        String clientIp = RpcContext.getContext().getRemoteHost();//客户端ip
        try {
            prop.load(in);
            String ipwhitelist = prop.getProperty("ipwhitelist");//ip白名单
            if (ipwhitelist.contains(clientIp)) {
                return invoker.invoke(invocation);
            } else {
                return new RpcResult(new Exception("ip地址："
                        + clientIp + "没有访问权限"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RpcException e) {
            throw e;
        } catch (Throwable t) {
            throw new RpcException(t.getMessage(), t);
        }
        return invoker.invoke(invocation);
    }
}