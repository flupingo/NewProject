package Fundation.IO;

import java.io.*;

/**
 * Created：Jeffrey
 * date   ：2020/6/25 10:09
 */
public class Test002 {
    public static void main(String[] args) {
//        String a=new String(new byte[]{'1','2'},0,2);
//        System.out.println(a);


        try {
            InputStream inputStream = new FileInputStream(new File("E:\\d.txt"));
            //字节数组
            byte[] bytes = new byte[4];
            int i = -1;
            while (inputStream.read(bytes) != -1) {
                String b = new String(bytes);
                System.out.println(b + "\n");

            }

            //字符数组
            char[] chars = new char[4];


            OutputStream outputStream = new FileOutputStream(new File("E:\\g.txt"));
            String e = "abcdefghi";
            byte[] bytes1 = e.getBytes();
            outputStream.write(e.getBytes(), 0, 1);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
