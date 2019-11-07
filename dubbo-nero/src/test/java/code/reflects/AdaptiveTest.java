package code.reflects;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.Protocol;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

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







    @Test
    public void test01(){

        HashMap hashMap = new HashMap(5);
        hashMap.put("1",1);
        hashMap.put("2",2);
        hashMap.put("3",3);
        hashMap.put("4",4);
        hashMap.put("5",5);



        int n = 10000;


        n |= n >>> 1;
        System.out.println(n);


    }





}
