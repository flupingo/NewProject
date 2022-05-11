package Fundation.IO;

import Fundation.User;

import java.io.*;

/**
 * Created：Jeffrey
 * date   ：2021/6/5 21:32
 */
public class Test003 {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("");
            Reader reader = new FileReader("");

            byte[] bytes = new byte[10];
            char[] chars = new char[10];
            inputStream.read(bytes);
            reader.read(chars);

            OutputStream outputStream = new FileOutputStream("");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            User user = new User("1");
            objectOutputStream.writeObject(user);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
