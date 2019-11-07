package org.apache.dubbo.demo.consumer;

import com.alibaba.dubbo.rpc.service.EchoService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.dubbo.common.bytecode.ClassGenerator;
import org.apache.dubbo.demo.DemoService;

public class proxy00
        implements ClassGenerator.DC,
        EchoService,
        DemoService {
    public static Method[] methods;
    private InvocationHandler handler;

    public String sayHello(String string) {
        Object[] arrobject = new Object[]{string};
        Object object = null;
        try {
            object = this.handler.invoke(this, methods[0], arrobject);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return (String)object;
    }

    public Object $echo(Object object) {
        Object[] arrobject = new Object[]{object};
        Object object2 = null;
        try {
            object2 = this.handler.invoke(this, methods[1], arrobject);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object2;
    }

    public proxy00() {
    }

    public proxy00(InvocationHandler invocationHandler) {
        this.handler = invocationHandler;
    }
}

