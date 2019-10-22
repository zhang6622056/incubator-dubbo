package com.nero.dubbo.spi.user.impl;

import com.nero.dubbo.spi.user.UserInjectInterfaceService;
import com.nero.dubbo.spi.user.UserInterface;
import org.apache.dubbo.common.URL;

public class UserImpl implements UserInterface {


    //- 引用setter注入
    private UserInterface userInterface;

    public void setUserInterface(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public String getUserName(URL url) {
        String pass = userInterface.getUserName(url);
        return "Username : nero " + "pass : "+pass;
    }








}
