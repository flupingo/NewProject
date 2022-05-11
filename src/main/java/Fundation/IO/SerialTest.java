package Fundation.IO;

import Fundation.User;

import java.io.*;

/**
 * Created：Jeffrey
 * date   ：2021/6/27 10:47
 */
public class SerialTest {

    public static void main(String[] args) {
        try {
            User user = new User();
            user.setAge(1);
            user.setName("zhangsan");

            //1.=====写到文件=====
            //序列化：serial
//            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("E:\\obj.txt"));
//            //用增强的功能方法
//            obj.writeObject(user);
//
//            //反序列化： deSerial
//            ObjectInputStream obi = new ObjectInputStream(new FileInputStream("E:\\obj.txt"));
//            User user1 = (User) obi.readObject();
//            System.out.println(user1.getName());

            //2.=====写到字节数组里=====
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(user);
            byte[] array = byteArrayOutputStream.toByteArray();
            System.out.println(array);
            String use=new String(array);
            System.out.println(use);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
