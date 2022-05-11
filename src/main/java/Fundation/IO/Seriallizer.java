package Fundation.IO;

import Fundation.Dog;
import Fundation.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 序列化就是将对象持久化，输出源可以是文档，可以是字节数组
 * Created：Jeffrey
 * date   ：2021/3/15 10:48
 */
public class Seriallizer {
    public static void main(String[] args) {
        try {
            User user = new User("中");
            //1.序列化到文件！！！
//            OutputStream outputStream = new FileOutputStream(new File("E:/outToFile.txt"));
            OutputStream outputStream001 = new FileOutputStream(new File("E:/outToFile.docx"));

            //装饰器：外面装饰了一个对象输出流(加强水管！！！)
            // Creates an ObjectOutputStream that writes to the specified OutputStream

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream001);
//            objectOutputStream.writeObject(user);

            //流把对象往文件里写/传输
            objectOutputStream.writeObject(new User("1"));


//            Map<String,String>map=new HashMap<>();
//            map.put("1","2");


            //======2.序列化到字节数组！！！====
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(byteArrayOutputStream);
//            byte[]b=new byte[3];
//            b[0]=1;
//            b[1]=2;
//            b[2]=3;
//            byteArrayOutputStream.write(b,0,3);
            objectOutputStream1.writeObject(user);

            //读取写入的数据
            String byteToString = new String(byteArrayOutputStream.toByteArray(), "ISO-8859-1");
            System.out.println("字节数组转字符串：" + byteToString);
            System.out.println("读取第二个字节：" + byteArrayOutputStream.toByteArray().length);


            //3.关闭流m
            objectOutputStream.flush();
            objectOutputStream.close();
            objectOutputStream1.flush();
            objectOutputStream1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        }

    }


}
