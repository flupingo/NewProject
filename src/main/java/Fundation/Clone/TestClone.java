package Fundation.Clone;

import Fundation.User;

/**
 * Created：Jeffrey
 * date   ：2021/6/28 10:03
 */
public class TestClone {
    public static void main(String[] args) {

        String a="123";
        a.substring(0,2);




        User user=new User("a");
        User user01=new User();
        try {
            user01=(User)user.clone();

            System.out.println(user01.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
