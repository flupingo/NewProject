package Fundation.IO;

import java.io.*;

/**
 * Created：Jeffrey
 * date   ：2020/6/24 21:17
 */
public class FileInputTest002 {
    public static void main(String[] args) {
        File file = new File("E:/b.txt");
        byte[] bytes = new byte[2];//buffer
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
//            OutputStream outputStream = new FileOutputStream(file);
            int length = -1;
            try {
                while ((length = fileInputStream.read(bytes)) != -1) { //1.read()将读取数据存到bytes数组里；2.并返回读取长度
                    String str = new String(bytes, 0, length); //3.将字节数组 bytes转成字符串
                    System.out.println(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileInputStream) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
