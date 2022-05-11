package Fundation.Wrapper;

/**
 * Created：Jeffrey
 * date   ：2020/6/24 15:40
 */
public class TestWrapper {
    public static void main(String[] args) {
        Integer a = 0;
        Integer b = 0;
        System.out.println(a == b);
        Integer a1 = 127;
        Integer b1 = 127;
        System.out.println(a1 == b1);

        Boolean flag = true;
        Character cha = '2';
        Integer i = 1;
        Integer j = new Integer(1);
        Integer k = Integer.valueOf(2);
        int l = k;
        Integer m = new Integer("2");
        Integer o = Integer.parseInt("3");
        String p = 1 + "";
        String q = Integer.toString(o);


    }
}
