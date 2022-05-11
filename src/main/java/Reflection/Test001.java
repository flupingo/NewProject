package Reflection;



import com.springIOC.demonAnn.Entity.AnnUser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created：Jeffrey
 * date   ：2020/5/29 15:41
 */
public class Test001 {
    public static void main(String[] args) {
        try {
            Computer001 computer001=new Computer001();
            Class cl = Computer001.class;
//            Field[] fields = cl.getFields();
//            System.out.println(fields[0]);
            Method method = cl.getDeclaredMethod("count");

//            method.invoke(null);
//            Computer computer=new Computer001();
            //属性和方法执行前都需要安全检查
            method.setAccessible(true);//不需要安全检查
            method.invoke(cl.newInstance());
            System.out.println(cl.getModifiers()); //获取修饰符int数值
            System.out.println(cl.getAnnotations());

            System.out.println(method.getName());
            Field field=cl.getDeclaredField("name");
            field.setAccessible(true);
            field.set(computer001,"yangjie"); //不能访问非public属性
            System.out.println(field.get(computer001));;
            System.out.println(computer001.getName());
            System.out.println(field.get(computer001));


            //构造器来创建对象！！！
            Constructor constructor = AnnUser.class.getDeclaredConstructor();
            AnnUser annUser = (AnnUser) constructor.newInstance();

            Constructor constructor1=AnnUser.class.getDeclaredConstructor(String.class);
            AnnUser annUser1= (AnnUser) constructor1.newInstance("zhangsan");

//            Cat cat=new Cat();
//            Class cl1=Cat.class;
//            Class cl2=cat.getClass();
//            System.out.println(cl2.equals(cl2));
//            System.out.println(cl);
//            System.out.println("milk".getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
