package com.HBase.Client;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created：Jeffrey
 * date   ：2021/7/3 14:39
 */
public class TestHbase002 {
    public static void main(String[] args) {
        Connection connection = HBaseClient.getConnection();
        try {
            Table table = connection.getTable(TableName.valueOf(""));
            Get get = new Get("rowKey".getBytes());
            Result result = table.get(get);
            String value = Bytes.toString(result.getValue(Bytes.toBytes(""), Bytes.toBytes("")));




        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
