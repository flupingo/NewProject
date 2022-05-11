package com.JVM;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created：Jeffrey
 * date   ：2021/7/22 9:25
 */
public class Test001 extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {  //1.返回的是Class对象，用于存储到内存(序列化？？？)？？？2.the name of the class

        //1.从".class"文件的路径读取二进制字节数组，如果class文件加密了，这里需要解密
        byte[] bytes;

        //2.defindClass？？？

        return super.findClass(name);
    }


    //可以直接继承URLClassLoader
    class test002 extends URLClassLoader {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            return super.findClass(name);
        }

        public test002(URL[] urls) {
            super(urls);
        }
    }

}
