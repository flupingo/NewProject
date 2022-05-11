package Fundation.SingleTon;

/**
 * Created：Jeffrey
 * date   ：2020/6/21 22:33
 */
public class SingleTonInnerClass {
    static class InnerClass {
        static SingleTonInnerClass singleTonInnerClass = new SingleTonInnerClass();
    }

    private SingleTonInnerClass() {
    }

    SingleTonInnerClass getInstance() {
        return InnerClass.singleTonInnerClass;//内部类只会加载一次，别的类调该方法时候，单例对象直接取，不用重新加载类
    }
}
