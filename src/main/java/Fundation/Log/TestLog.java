package Fundation.Log;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created：Jeffrey
 * date   ：2021/9/14 9:21
 */
public class TestLog {
    public static void main(String[] args) throws Exception{
        Logger logger= Logger.getLogger("");
        get();

    }

    static void get() throws IOException {
        if (true){
            throw  new IOException();
        }

    }
}
