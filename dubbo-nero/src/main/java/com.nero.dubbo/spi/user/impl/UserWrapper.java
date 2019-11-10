package com.nero.dubbo.spi.user.impl;

import com.nero.dubbo.spi.user.UserInterface;
import org.apache.dubbo.common.URL;


/***
 *
 * dubbo aop实现类，通过构造器注入一个具体的实现
 * @author Nero
 * @date 2019-10-19
 * *@param: null
 * @return 
 */
public class UserWrapper implements UserInterface {


    private UserInterface userInterface;

    public UserWrapper(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public String getUserName(URL url) {
        System.out.println("this is the user wrapper.");
        return userInterface.getUserName(url);
    }
}
