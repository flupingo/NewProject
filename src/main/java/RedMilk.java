import org.springframework.context.ConfigurableApplicationContext;

import java.io.InputStream;


public class RedMilk extends  Milk {
    String taste;
    /*
    继承抽象方法
     */
    void add() {
        System.out.println("加入红豆");
    }

//    public RedMilk(String taste) {
//        super("red");
//        this.taste = taste;
//    }

    public RedMilk(String taste) {
        super();
        this.taste = taste;
    }

    public static void main(String[] args) {
        Milk redMilk=new RedMilk("good");
        redMilk.make();
//        ConfigurableApplicationContext configurableApplicationContext=new
//        if(new RedMilk("good") instanceof  Milk){
//            System.out.println("yes");
//        }



    }

    @Override
    public String toString() {
        return "RedMilk{" +
                "taste='" + taste + '\'' +
                '}';
    }

}
