package Fundation.IO;

import Fundation.Dog;
import org.fusesource.hawtbuf.BufferInputStream;

import java.io.*;

/**
 * Created：Jeffrey
 * date   ：2020/6/25 13:42
 */
public class WriterTest {
    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter("D:/f.txt");
//            JavaRDD a

        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            //字节流
            InputStream stream = new FileInputStream(new File(""));
            stream.read(new byte[12]);
            BufferedInputStream bufferInputStream = new BufferedInputStream(stream, 1000000);

            int read = bufferInputStream.read();

            OutputStream outputStream;


            //字符流
            Reader reader = new FileReader("文件名");
            reader.read(new char[22]);
            BufferedReader bufferedReader = new BufferedReader(reader);
            bufferedReader.read();

            bufferedReader.readLine();

            Writer writer;




            //序列化
            OutputStream objectOutputStream1 = new FileOutputStream(new File("12"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(objectOutputStream1);
            objectOutputStream.writeObject(new Dog());


            ByteArrayOutputStream outputStream1=new ByteArrayOutputStream();





            ObjectInputStream objectInputStream = new ObjectInputStream(stream);
            objectInputStream.read();
            objectInputStream.read(new byte[12]);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
