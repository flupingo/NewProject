package Fundation.DesignTemp;

/**
 * Created：Jeffrey
 * date   ：2020/6/23 21:06
 */
public abstract class TemplateMethod {
    void sing() {
        System.out.println("sing");
    }

    void laugh() {
        System.out.println("laugh");
    }

    abstract void eat();

    void test() {
        sing();
        laugh();
        eat();
    }
}
