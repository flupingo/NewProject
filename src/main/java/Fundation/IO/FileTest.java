package Fundation.IO;

import java.io.File;
import java.io.IOException;

/**
 * Created：Jeffrey
 * date   ：2020/6/24 16:18
 */
public class FileTest {
    public static void main(String[] args) {
        try {
            File file=new File("E:/a.txt");
            file.renameTo(new File("E:/b.txt"));
            File file1=new File("E:/c.txt");
            System.out.println(file1.exists());
//            file1.createNewFile();
//            System.out.println(file.getName());
//            System.out.println(file1.exists());
//            System.out.println(file1.delete());
//            System.out.println(file1.exists());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
