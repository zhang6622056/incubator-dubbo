package basic;

import java.math.BigDecimal;

public class TryCatchTest {

    public static void main(String[] args) {
        String a = "11111";
       try{
           a = get();
       }catch(Exception e){

       }
       System.out.println(a);
    }




    public static String get() {
        try {
            BigDecimal res = BigDecimal.valueOf(6).divide(BigDecimal.ZERO);
            return "123";
        } catch (Exception e) {
            System.out.println("ajldfjkaslfjk");
            return "catch";
        } finally {
            return "222222";
        }
    }


}
