package Fundation.SingleTon;

/**
 * Created：Jeffrey
 * date   ：2020/6/20 13:57
 */
public class SingleTon001 {
    private static SingleTon001 singleTon = new SingleTon001();//别的类无法调用
    private String name;
    static SingleTon001 getSingleTonTest() {
        return singleTon;
    }

    private SingleTon001() {//别的类无法调用
        System.out.println();
    }

//    public static void main(String[] args) {
//        System.out.println(SingleTon001.singleTon);
//        S
//    }

}
