package com.HBase.Client;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created：Jeffrey
 * date   ：2021/6/6 10:26
 */
public class TestHbase001 {
    public static void main(String[] args) {
        Connection connection = HBaseClient.getConnection();
        try {
            Table table = connection.getTable(TableName.valueOf(""));


            //utf-8
            Get get = new Get(Bytes.toBytes("rowKey")).addColumn("".getBytes(), "".getBytes());
            Cell[] cells = table.get(get).rawCells();
            for (Cell cell : cells) {
                //UTF8_CHARSET
                Bytes.toString(CellUtil.cloneValue(cell));


            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
