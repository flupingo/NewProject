package Fundation.IO;

import java.io.*;

/**
 * Created：Jeffrey
 * date   ：2021/6/27 9:18
 */
public class BufferedTest {
    public static void main(String[] args) {
        try {
            //字节
            InputStream inputStream = new FileInputStream(new File("E:\\pic.png"));
            OutputStream outputStream = new FileOutputStream("E:\\copy.png");

            //有个默认的byte[8192]的字节数组
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            byte[] bytes = new byte[8192];
            int len = 0;
            Long t1 = System.currentTimeMillis();
            //一次读取1024个字节,返回是实际读到数量
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                System.out.println(len);
//                bufferedOutputStream.write(bytes,0,len);
                bufferedOutputStream.write(len);
            }
            bufferedInputStream.close();
            bufferedOutputStream.close();
            Long t2 = System.currentTimeMillis();
            System.out.println("copy完成！！！消耗：" + (t2 - t1) + "毫秒");
            //字符
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\d.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
