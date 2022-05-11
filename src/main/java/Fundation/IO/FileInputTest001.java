package Fundation.IO;

import java.io.*;

/**
 * Created：Jeffrey
 * date   ：2020/6/24 20:45
 */
public class FileInputTest001 {
    public static void main(String[] args) {
        //1.源
        File file = new File("E:/b.txt");
        try {
            //2.创建流---建立文件的连接(借助OS)，通过本地方法：open(name)
            InputStream inputStream = new FileInputStream(file);

            //3.读取
            try {
                int data1 = inputStream.read(); //Reads the next byte of data from this input stream.中文2个字节就没法读了
                int data2 = inputStream.read();
                System.out.println((char) data1);//int-->char
                System.out.println((char) data2);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
