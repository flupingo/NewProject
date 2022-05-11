package com.FreeMarker;

import Fundation.User;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created：Jeffrey
 * date   ：2021/5/12 15:11
 */
public class Client {
    public static void main(String[] args) {
        try {
            //获取Freemarker模板文件(template对象)，将模板输出为流，转成sql！！！

            Configuration cfg = new Configuration();
            cfg.setDirectoryForTemplateLoading(new File("rootPath" + "childPath"));
            //获取模板对象
            Template template = cfg.getTemplate("templateName");
            // 获取输出流（指定到控制台（标准输出））
            StringWriter out = new StringWriter();
            // 数据与模板合并（数据+模板=输出）
            Map<String, Object> sqlParm = new HashMap<>();
            User user=new User("");
            sqlParm.put("taskType", "multidim");
            sqlParm.put("taskParam",user);
            template.process(sqlParm, out);
            String sql = out.toString();
            out.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
