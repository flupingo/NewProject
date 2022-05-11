package Fundation.IO;

import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.io.input.BoundedInputStream;
import org.fusesource.hawtbuf.BufferInputStream;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * Created：Jeffrey
 * date   ：2021/8/29 9:29
 */
public class TestMultipartFile {
    public static void main(String[] args) {
        try {
//            MultipartFile multipartFile = null;
//            multipartFile.getInputStream();
//
//            InputStreamReader inputStream = new InputStreamReader(new BOMInputStream(null), "UTF-8");


            Reader reader = new FileReader("E:\\cc.txt");
            reader.read();


            byte[] bytes = "abc中".getBytes();
            ByteArrayInputStream inputStream1 = new ByteArrayInputStream(bytes);//读取字节数组
            BOMInputStream bomInputStream = new BOMInputStream(inputStream1);
            InputStreamReader reader1 = new InputStreamReader(bomInputStream, "utf-8");
            BufferedReader reader2=new BufferedReader(reader1);
            reader2.readLine();


            InputStream inputStream2 = new FileInputStream("fileName"); //读取文件
            inputStream2.read(bytes);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();//转成字节数组
            byte[] bytes1 = "".getBytes();
            byteArrayOutputStream.write(bytes1);


            OutputStream outputStream = new FileOutputStream("fileName");


        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException g) {
            g.printStackTrace();
        }


    }
}
