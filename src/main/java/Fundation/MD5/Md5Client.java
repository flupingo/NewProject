package Fundation.MD5;

import java.text.MessageFormat;

/**
 * Created：Jeffrey
 * date   ：2021/3/14 17:12
 */
public class Md5Client {
    public static void main(String[] args) {
//        String messageFormat = MessageFormat.format("RKB:ESCACHE:{0},{1}", "orderIndex","purchase");
//        System.out.println(messageFormat);
        byte[]bytes=new byte[3];
        bytes[0]='1';
        bytes[1]='2';
        bytes[2]='3';
        String a=new String(bytes,1,1);
        System.out.println(a);


        String c="97hello";
        byte[]cb=c.getBytes();
        System.out.println(cb.length);




    }
}
