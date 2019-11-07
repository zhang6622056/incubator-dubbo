package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;

public class RegistryFactory$Adaptive
        implements RegistryFactory {
    public Registry getRegistry(URL uRL) {
        String string;
        if (uRL == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL uRL2 = uRL;
        String string2 = string = uRL2.getProtocol() == null ? "dubbo" : uRL2.getProtocol();
        if (string == null) {
            throw new IllegalStateException(new StringBuffer().append("Failed to get extension (org.apache.dubbo.registry.RegistryFactory) name from url (").append(uRL2.toString()).append(") use keys([protocol])").toString());
        }
        RegistryFactory registryFactory = (RegistryFactory)ExtensionLoader.getExtensionLoader(RegistryFactory.class).getExtension(string);
        return registryFactory.getRegistry(uRL);
    }
}