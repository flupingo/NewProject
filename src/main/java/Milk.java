public abstract class Milk {
    public String color;
    public static String address;
    void make() {
        select();
        add();
        finish();
    }
    static void get(){
//        select();
    }

    void select() {
        System.out.println("选料");
        System.out.println(Milk.address);
        get();
    }

    abstract void add();

    void finish() {
        System.out.println("完成");
    }

    public Milk(String color) {
        this.color = color;
    }
    public Milk(){

    }
}
