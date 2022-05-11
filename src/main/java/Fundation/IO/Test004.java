package Fundation.IO;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created：Jeffrey
 * date   ：2021/8/11 14:16
 */
public class Test004 {
    public static void main(String[] args) {
        try {
            Object obj = Proxy.newProxyInstance(Test004.class.getClassLoader(), new Class[]{Test004.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return null;
                }
            });


            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    //干活
                }
            });
            t.setDaemon(true);
            t.start();





            InputStream inputStream = new FileInputStream("");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            //序列化
            OutputStream outputStream = new FileOutputStream("");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(null);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
            ObjectOutputStream obj1 = new ObjectOutputStream(byteArrayOutputStream);
            obj1.writeObject(byteArrayOutputStream);
            new String(byteArrayOutputStream.toByteArray());

            Reader reader = new FileReader("");
            try {
                Writer writer = new FileWriter("");


            } catch (IOException e) {
                e.printStackTrace();
            }


            byte[] bytes = new byte[1024];
            try {
                while (bufferedInputStream.read(bytes) != -1) {
                    outputStream.write(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
