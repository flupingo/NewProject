package Fundation.IO;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;

/**
 * Created：Jeffrey
 * date   ：2021/8/20 19:59
 */
public class TestFreeMark {
    public static void main(String[] args) {
        StringWriter stringWriter = new StringWriter(); //extends Writer
        Configuration cfg = new Configuration();
        try {
//            Template template = cfg.getTemplate("sql名称");
//            Object dataModel = new Object();
//            template.process(dataModel, stringWriter); //输出到writer流
//            String sql = stringWriter.toString();

            //copy
            Reader reader = new FileReader("");
            Writer writer = new FileWriter("");
            char[] chars = new char[8048];
            while (reader.read(chars) != 0) {
                writer.write(chars);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
