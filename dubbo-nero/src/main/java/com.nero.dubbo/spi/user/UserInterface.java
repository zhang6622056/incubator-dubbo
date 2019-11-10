package com.nero.dubbo.spi.user;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;





@SPI
public interface UserInterface {



    //- 生成代理类，  实现类采用inject变量值对应配置文件的key，并且注入到相关setter特征的类中
    @Adaptive("inject")
    public String getUserName(URL url);
}
