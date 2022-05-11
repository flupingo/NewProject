package Fundation.DesignTemp;

/**
 * Created：Jeffrey
 * date   ：2020/6/23 21:08
 */
public class TemplateExtend extends TemplateMethod {
    void eat() {
        System.out.println("实现钩子方法");
    }

    public static void main(String[] args) {
        TemplateMethod templateMethod=new TemplateExtend();
        templateMethod.test();

        TemplateMethod templateMethod1=new TemplateMethod() {
            @Override
            void eat() {

            }
        };
        templateMethod1.test();

    }
}
