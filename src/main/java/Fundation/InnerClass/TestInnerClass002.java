package Fundation.InnerClass;

/**
 * Created：Jeffrey
 * date   ：2021/6/13 15:34
 */
public class TestInnerClass002 {
    public static void main(String[] args) {
            String song="我是谁";
            Interface003 interface003=new Interface003() {
                @Override
                public String sing() {
                    String songs=song+"呢";
                    return songs;
                }
            };

            interface003.sing();

    }


}
