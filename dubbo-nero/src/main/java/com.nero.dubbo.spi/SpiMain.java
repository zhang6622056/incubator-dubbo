package com.nero.dubbo.spi;

import com.nero.dubbo.spi.user.UserInterface;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class SpiMain {

    public static void main(String[] args) {
        ExtensionLoader extensionLoader = ExtensionLoader.getExtensionLoader(UserInterface.class);
        UserInterface userInterface = (UserInterface) extensionLoader.getExtension("user");
        System.out.println(userInterface.getUserName());
    }



}
