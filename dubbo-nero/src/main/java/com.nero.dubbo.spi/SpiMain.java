package com.nero.dubbo.spi;

import com.nero.dubbo.spi.user.UserInterface;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpiMain {



    /****
     *
     * 功能描述 
     * @author Nero
     * @date 2019-10-19
     * *@param: args
     * @return void
     */
    public static void main(String[] args) throws IOException {
        ExtensionLoader extensionLoader = ExtensionLoader.getExtensionLoader(UserInterface.class);
        UserInterface userInterface = (UserInterface) extensionLoader.getExtension("user");



        Map<String,String> parameters = new HashMap<>();
        parameters.put("inject","pass");

        URL url = new URL("","",1,parameters);
        System.out.println(userInterface.getUserName(url));



        System.in.read();


    }



}
