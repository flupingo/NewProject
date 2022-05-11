package Fundation.SingleTon;

/**
 * Created：Jeffrey
 * date   ：2020/6/21 22:48
 */
public class SingleTon002 {
    private static SingleTon002 singleTon002;
    private SingleTon002(){}

    static SingleTon002 getInstance() {
        if (null == singleTon002) {
            return new SingleTon002();
        } else {
            return singleTon002;
        }
    }

}
