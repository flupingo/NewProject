package Fundation.IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created：Jeffrey
 * date   ：2021/9/13 13:30
 */
public class TestBigData {
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("fileName", "rw");
            Long len = randomAccessFile.length(); //文件字节长度
            FileChannel fileChannel = randomAccessFile.getChannel();
            MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 1, 10);

            for (int i = 0; i < len; i++) {
                Byte byte1 = byteBuffer.get(i); //获取字节
                System.out.println(byte1);
            }
            byteBuffer.clear();
            randomAccessFile.close();
            fileChannel.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        }


    }
}
