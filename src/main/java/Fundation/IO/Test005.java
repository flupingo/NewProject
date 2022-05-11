package Fundation.IO;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created：Jeffrey
 * date   ：2021/11/26 14:23
 */
public class Test005 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("");
            byte[] bytes = new byte[1024];

            inputStream.read(bytes);


            OutputStream outputStream = new FileOutputStream("");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(null);


            inputStream.close();


            Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Test005.class},
                    (proxy, method, a) -> {
                        return 1;
                    }
            );


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
