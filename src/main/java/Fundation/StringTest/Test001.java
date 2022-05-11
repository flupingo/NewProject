package Fundation.StringTest;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created：Jeffrey
 * date   ：2021/8/29 8:44
 */
public class Test001 {
    public static void main(String[] args) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("我");
            stringBuffer.append("中");
//        System.out.println(stringBuffer);
            stringBuffer.toString();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("1111");
//            System.out.println(stringBuilder);
            stringBuilder.toString();

            char[] chars = new char[4048];
            chars[1]='2';
            Writer writer = new StringWriter();
            writer.write(chars);
            String a = writer.toString();
            System.out.println(a);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
