package Fundation.SingleTon;

/**
 * Created：Jeffrey
 * date   ：2021/8/11 20:46
 */
public class Test001 {
    private static volatile Test001 test001 = new Test001();  //饿汉式？？？指令重排问题呢？？

    public static Test001 getTest001() {
        if (test001 == null) {
            return new Test001();
        } else {
            return test001;
        }
    }


    private Test001() {

    }
}
