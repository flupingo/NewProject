package Fundation.Log;

import java.io.IOException;

/**
 * Created：Jeffrey
 * date   ：2021/9/14 9:28
 */
public class TestException {
    public static void main(String[] args) throws CommonException {
        try {
            int a = 0;
        } catch (RuntimeException e) {
            throw new CommonException(e);
        }

    }

}
