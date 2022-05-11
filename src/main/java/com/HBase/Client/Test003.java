package com.HBase.Client;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created：Jeffrey
 * date   ：2021/8/17 20:54
 */
public class Test003 {
    public static void main(String[] args) {
        try {
            Connection connection = HBaseClient.getConnection();
            Table table = connection.getTable(TableName.valueOf("12"));
            Get get=new Get(Bytes.toBytes("row"));
            table.get(get);





        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
