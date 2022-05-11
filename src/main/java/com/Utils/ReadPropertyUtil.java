package com.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created：Jeffrey
 * date   ：2021/5/31 18:01
 */
public class ReadPropertyUtil {
    public static Properties loadProperty(String resourcePath) {
        Properties properties = new Properties();

        //类加载器为什么可以读取文件？？？
        InputStream inputStream = ReadPropertyUtil.class.getClassLoader().getResourceAsStream(resourcePath);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return properties;
        }
    }


}
