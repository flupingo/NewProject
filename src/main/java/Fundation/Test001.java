package Fundation;

/**
 * Created：Jeffrey
 * date   ：2020/6/15 14:55
 */
public class Test001 {
    public static void main(String[] args) {
//        SingleTon001 singleTonTest = new SingleTon001();
        //1."=="和“equals"
        "1".equals("2");
        System.out.println("1" == "2");

        final int ABC = 3;
        //数值交换
        int a = 2;
        int b = 3;
        String d=a>b?(a+b+""):(a-b+"");

        int c;
        c = a;
        a = b;
        b = c;

        //短路保护
//        System.out.println(a & b);
//        System.out.println((a > b) || (a == b));

        System.out.println(d);

        a += 1;
        System.out.println(a);



    }
}
