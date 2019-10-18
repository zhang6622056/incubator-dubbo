package com.nero.dubbo.spi.user.impl;

import com.nero.dubbo.spi.user.UserInterface;

public class UserImpl implements UserInterface {


    @Override
    public String getUserName() {
        return "Nero";
    }
}
