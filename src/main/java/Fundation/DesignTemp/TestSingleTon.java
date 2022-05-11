package Fundation.DesignTemp;

/**
 * Created：Jeffrey
 * date   ：2021/7/24 20:03
 */
public class TestSingleTon {
    static volatile Inner inner = new Inner();

    {
        inner = new Inner();
    }

    public Inner getInner() {
        if (null == inner) {
            return new Inner();
        } else {
            return inner;
        }
    }


    static class Inner {
        //构造器私有化
        private Inner() {
        }
    }


}
