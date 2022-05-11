package Fundation.Date;

import Fundation.User;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created：Jeffrey
 * date   ：2020/7/17 15:17
 */
public class DateClient {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); //M--大写


        //DateUtils？？？相关方法
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        simpleDateFormat.format(calendar.getTime());
        System.out.println();





        String a = "123".replace("1", "==");
        System.out.println(a);


        List list = new ArrayList();
        List list01 = new ArrayList();
        list01.add(1);

        Set set01 = new HashSet();
        Set set02 = new HashSet();
        set01.add(4);
        set01.add(2);
        set01.addAll(set02);


        list.addAll(list01);
        list.addAll(set01);
        System.out.println(list);

        int i = 1;
        switch (i) {
            case 2:
                System.out.println("1");
                break;
            case 1:
                System.out.println("2");
                break;
            default:
                System.out.println("3");
        }
        testString();

    }


    static void testString() {
        String ab = new String("123");
        ab = ab + 3;


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1213").append(1).append(false);
        stringBuilder.toString();


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1).append("123").append(false);
        stringBuffer.toString();
    }
}
