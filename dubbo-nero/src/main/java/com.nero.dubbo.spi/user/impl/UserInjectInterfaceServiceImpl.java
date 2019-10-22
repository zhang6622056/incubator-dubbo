package com.nero.dubbo.spi.user.impl;

import com.nero.dubbo.spi.user.UserInterface;
import org.apache.dubbo.common.URL;



/***
 *
 * 用于被注入的实现类
 * @author Nero
 * @date 2019-10-22
 * *@param: null
 * @return 
 */
public class UserInjectInterfaceServiceImpl implements UserInterface {


    @Override
    public String getUserName(URL url) {
        return "qweasd";
    }
}
