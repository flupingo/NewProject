package Fundation.SingleTon;

import java.util.Properties;

/**
 * Created：Jeffrey
 * date   ：2020/6/21 22:11
 */
public class SingleTonClient {
    public static void main(String[] args) {
//       System.out.println(SingleTon001.singleTon);
//        SingleTon001 singleTon001=new SingleTon001();
//        System.out.println(singleTon001.name);
        Properties properties = new Properties();
        SingleTon001.getSingleTonTest();

    }
}
