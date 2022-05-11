package com.HBase.Client;

import com.alibaba.nacos.common.utils.MD5Utils;
import org.apache.hadoop.hdfs.util.MD5FileUtils;

/**
 * Created：Jeffrey
 * date   ：2022/3/15 16:57
 */
public class TestMD5 {
    public static void main(String[] args) {
      System.out.println( MD5Utils.encodeHexString("12".getBytes()));


    }
}
