package Fundation.IO;

import java.io.*;

/**
 * Created：Jeffrey
 * date   ：2021/8/29 14:11
 */
public class TestReader {
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("");
            BufferedReader reader1 = new BufferedReader(reader);
            reader1.readLine();




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        }


    }
}
