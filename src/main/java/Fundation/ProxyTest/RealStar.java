package Fundation.ProxyTest;

/**
 * Created：Jeffrey
 * date   ：2020/6/20 21:53
 */
public class RealStar implements Star {
    public void sing(String song) {
        System.out.println("realSinger唱：" + song);
    }

    public void makeMoney() {
        System.out.println("realMakeMoney");
    }
}
