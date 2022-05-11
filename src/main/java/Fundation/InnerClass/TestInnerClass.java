package Fundation.InnerClass;

/**
 * Created：Jeffrey
 * date   ：2021/6/9 17:46
 */
public class TestInnerClass {
    public static void main(String[] args) {
        String age = "小猪猪";

        String test001 = test(new Interface001() {
            @Override
            public String writeName() {
                final String NAME = get(age);  //age在匿名对象Interface001里，不是普通的传参
                return NAME;
            }
        });
        System.out.println(test001);

    }

    static String get(String age) {
        return age + "是小狗";
    }

    static String test(Interface001 interface001) {
        String som = interface001.writeName();

        return som;
    }
}
