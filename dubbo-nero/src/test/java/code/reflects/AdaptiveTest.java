package code.reflects;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.Protocol;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class AdaptiveTest {


    @Test
    public void test(){
        Method[] methods = Protocol.class.getMethods();

        //- 根据接口名匹配代理实现类code
        String splitName = StringUtils.camelToSplitName(Protocol.class.getSimpleName(), ".");
        System.out.println(splitName);




        for (Method method : methods){
            Adaptive adaptiveAnnotation = method.getAnnotation(Adaptive.class);
            if (null != adaptiveAnnotation){

                String[] anotationValue = adaptiveAnnotation.value();
                for (String currentValue : anotationValue){
                    System.out.println(currentValue);
                }
            }
        }




    }


}
