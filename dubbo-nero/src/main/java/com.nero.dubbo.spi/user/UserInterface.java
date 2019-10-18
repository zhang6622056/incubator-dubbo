package com.nero.dubbo.spi.user;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface UserInterface {
    public String getUserName();
}
