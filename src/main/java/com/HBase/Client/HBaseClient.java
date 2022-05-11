package com.HBase.Client;

import org.apache.commons.collections.CollectionUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.ibatis.annotations.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2020/8/19 21:01
 */
public class HBaseClient {
    private static Admin admin; //HMaster操作DDL！！！
    private static Connection connection;
    private static Logger logger = LoggerFactory.getLogger("HBaseClient");


    public static void main(String[] args) throws Exception {
//        deleteTable("HBaseTable");
//        if (!isTableExists("ns_rkb:HBaseTable01")) {
//            createTable("ns_rkb:HBaseTable01", "cf1，cf2");//cfs列族
//        }
//        System.out.println("===" + isTableExists("HBaseTable") + "=====");
//        createNameSpace("ns_rkb");

        connection = getConnection();
        admin = connection.getAdmin();


        //增，改
        putData("rkb", "1005", "cf1", "value", "12:20,14:50,30:13");

        //查
        getDataByGet("rkb", "1001", "cf1", "age");
//        getDataByGet("rkb", "1001", "cf1", "name");

        getDataByScan("1001", "1003");

//        CollectionUtils.isNotEmpty(null);
    }

    //加载配置
//    static {
//        Configuration configuration = HBaseConfiguration.create();
//        try {
//            configuration.set("hbase.zookeeper.quorum", "192.168.0.103");//zk地址
//            System.out.println("正在创建HBase连接！");
//            connection = ConnectionFactory.createConnection(configuration);
//            System.out.println("HBase连接创建完成！");
//            admin = connection.getAdmin();
////            connection.
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static Connection getConnection() {
        Connection connection = null;
        Configuration configuration = HBaseConfiguration.create();
        try {
            configuration.set("hbase.zookeeper.quorum", "192.168.0.103");//zk地址
            System.out.println("正在创建HBase连接！");
            connection = ConnectionFactory.createConnection(configuration);
            System.out.println("HBase连接创建完成！");
//            admin = connection.getAdmin();
//            connection.

        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;

    }


    //表是否存在
    public static boolean isTableExists(String tableName) throws Exception {
        return admin.tableExists(TableName.valueOf(tableName));
    }

    //删表
    public static void deleteTable(String tableName) throws Exception {
        //先下线表
        admin.disableTable(TableName.valueOf(tableName));
        //再删除
        admin.deleteTable(TableName.valueOf(tableName));
    }

    //建表
    public static boolean createTable(String tableName, String... cfs) throws Exception { //列族数可变
        //表描述器
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
        for (String cf : cfs) {
            HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(cf);//列描述器-列族
            hTableDescriptor.addFamily(hColumnDescriptor);
        }
        admin.createTable(hTableDescriptor);
        return false;
    }

    //建命名空间
    public static void createNameSpace(String ns) throws Exception {
        //命名空间描述器
        NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create(ns).build();
        //创建命名空间
        admin.createNamespace(namespaceDescriptor);

    }

    //插入数据
    public static void putData(String tableName, String rowKey, String cf, String column, String value) {
        try {
            //DML对象！！！
            Table table = connection.getTable(TableName.valueOf(tableName));
            List<Put> putList = new ArrayList();

            //此构造方法需要rowKey先确定下来！！！rowkey是最核心的唯一字段
            Put put = new Put(Bytes.toBytes(rowKey));
            putList.add(put);

            //插入：列族、列和值
            put.addColumn(Bytes.toBytes(cf), Bytes.toBytes(column), Bytes.toBytes(value));
            table.put(put);
            table.close();//关闭连接，轻量级

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取单行数据---GET
    public static void getDataByGet(String tableName, String rowKey, String cf, String column) {
        try {
            //getDataByGet("rkb", "1001", "cf1", "age");
            Table table = connection.getTable(TableName.valueOf(tableName));
            List<Get> getList = new ArrayList();

            //========基于rowKey，添加列族和列名！！！！=======
            Get get = new Get(Bytes.toBytes(rowKey));
//            get.addFamily(Bytes.toBytes(cf));

            //可以指定列族和列，也可以不指定！！！一个rowKey就制定了一行数据
            get.addColumn(Bytes.toBytes(cf), Bytes.toBytes(column));


            Result result = table.get(get);//一行数据
//            getList.add(get);
//            get.setMaxVersions();//设置获取数据版本数，即不同timeStamp对同一个column的赋值
            //1.第一种方式:列族和列获取值！！！
            String value=Bytes.toString(result.getValue(Bytes.toBytes(cf),Bytes.toBytes(column)));


            //2.第二种方式
            Cell[] cells = result.rawCells();//每个单元格就是一个列对应一个值
            for (Cell cell : cells) {
                System.out.println("RowKey:" + Bytes.toString(CellUtil.cloneRow(cell)) + ", 列族:" + Bytes.toString(CellUtil.cloneFamily(cell)) + "， 列：" + Bytes.toString(CellUtil.cloneQualifier(cell))
                        + ", 值：" + Bytes.toString(CellUtil.cloneValue(cell)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取多行数据--SCAN
    public static void getDataByScan(String startRow, String stopRow) {
        try {
            Table table = connection.getTable(TableName.valueOf("rkb"));
            Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(stopRow)); //左闭右开，不指定起始和结束则查询所有
            ResultScanner resultScanner = table.getScanner(scan);//获取迭代器
            for (Result result : resultScanner) {
                for (Cell cell : result.rawCells()) {
                    System.out.println("RowKey:" + Bytes.toString(CellUtil.cloneRow(cell)) + ", 列族:" + Bytes.toString(CellUtil.cloneFamily(cell)) + "， 列：" + Bytes.toString(CellUtil.cloneQualifier(cell))
                            + ", 值：" + Bytes.toString(CellUtil.cloneValue(cell)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //删除数据


}
