package org.apache.dubbo.demo.consumer;

import java.lang.reflect.InvocationHandler;
import org.apache.dubbo.common.bytecode.ClassGenerator;
import org.apache.dubbo.common.bytecode.Proxy;





public class Proxy0
        extends Proxy
        implements ClassGenerator.DC {
    public Object newInstance(InvocationHandler invocationHandler) {
        return new proxy00(invocationHandler);
    }
}

