package Fundation.IO;

import Fundation.User;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import sun.net.ftp.FtpClient;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;


/**
 * Created：Jeffrey
 * date   ：2021/6/3 17:22
 */
public class Test001 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("E:\\b.txt");
            byte[] bytes = new byte[10];
            int a = 1;
//            while (a != -1) {
////                a = inputStream.read();
////                System.out.println(a);
////                System.out.println(new String());
//                inputStream.read(bytes);
//                System.out.println(bytes);
//                System.out.println(new String(bytes));
//            }


            byte[] bytes1 = new byte[10];
            bytes1 = "123abc中".getBytes("GBK");
            String adsf = new String(bytes1, "GBK");
            System.out.println(adsf);

//            bytes1 = "123abc中".getBytes();
//            adsf = new String(bytes1);
//            System.out.println(adsf);

            for (byte b : bytes1) {
                System.out.println((char) b);
            }


            OutputStream outputStream = new FileOutputStream("E:\\output.txt");
            outputStream.write(bytes1);
            System.out.println(bytes1);


            //写对象
            User user = new User();
            user.setAge(1);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(user);


            //???
            InputStream inputStream1 = Test001.class.getClassLoader().getResourceAsStream("");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void test() {
        try {
            //字节流
            InputStream inputStream = new FileInputStream("");//读取文件
            byte[] bytes = new byte[20];
            inputStream.read(bytes);

            //字符流
            Reader reader = new FileReader("");
            char[] chars = new char[20];
            reader.read(chars);

            FTPClient ftp = new FTPClient();
            InputStream inputStream1 = ftp.retrieveFileStream("");
            ftp.storeFile("",null); //将inputStream以文件存储



            HttpServletResponse response=new HttpServletResponseWrapper(null);
            OutputStream outputStream=response.getOutputStream();



        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
