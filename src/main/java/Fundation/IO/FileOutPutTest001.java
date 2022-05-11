package Fundation.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created：Jeffrey
 * date   ：2020/6/25 10:17
 */
public class FileOutPutTest001 {
    public static void main(String[] args) {
        File file = new File("E:/outPut.txt");
        FileOutputStream fileOutputStream = null;
        try {
//            fileOutputStream = new FileOutputStream(file);
            fileOutputStream =new FileOutputStream("E:/outPut.txt",false); //调用OS建立文件连接
            //1.数据源
            String me="97hello";
            byte[]bytes=me.getBytes();//输出字符串-->字节数组

            //2.写指定大小字节数组：把水往池子里灌
            fileOutputStream.write(bytes,0, bytes.length);
//            fileOutputStream.write(bytes);//字节数组全写入
//            fileOutputStream.write(97);//97->a写入文本
            fileOutputStream.flush();//管子关了
            System.out.println("=结束=");

//            char[]chars=me.toCharArray();
//            fileOutputStream.write(chars);


        } catch (Exception e) {

        } finally {
            try {
                if (null != fileOutputStream) {
                    fileOutputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
