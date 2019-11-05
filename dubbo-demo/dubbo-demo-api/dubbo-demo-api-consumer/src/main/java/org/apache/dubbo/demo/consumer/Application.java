/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.demo.DemoService;

import java.io.IOException;
import java.lang.reflect.Proxy;

public class Application {
    /**
     * In order to make sure multicast registry works, need to specify '-Djava.net.preferIPv4Stack=true' before
     * launch the application
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");


        while(true){
            ReferenceConfig<DemoService> reference = new ReferenceConfig<>();
            //- 设置应用名
            reference.setApplication(new ApplicationConfig("dubbo-demo-api-consumer"));
            //- 设置注册中心地址
            reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
            //- 设置调用的接口
            reference.setInterface(DemoService.class);
            DemoService service = reference.get();

            System.out.println(service.getClass().getName());
            System.out.println("$Proxy0.class全名: "+ Proxy.getProxyClass(DemoService.class.getClassLoader(), DemoService.class));



            String message = service.sayHello("dubbo");
            System.out.println(message);
            Thread.sleep(30000);
        }


    }
}
