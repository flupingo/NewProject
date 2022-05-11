package Fundation.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created：Jeffrey
 * date   ：2020/6/25 11:30
 */
public class ReaderTest {
    public static void main(String[] args) {
        try {
            File file = new File("E:/d.txt");
            //底层还是生成输入流:FileInputStream，  super(new FileInputStream(file))
            FileReader reader = new FileReader(file);
            char[] chars = new char[2];
            int length = -1;
            try {
//                char c = (char) reader.read();
                while ((length = reader.read(chars, 0, chars.length)) != -1) {
                    String a = new String(chars, 0, chars.length);
                    System.out.println(length);
                    System.out.println(a);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
