package org.apache.dubbo.config.spring.context.annotation.provider;

import org.apache.dubbo.config.spring.api.HelloService;

public class NeroServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return null;
    }
}
