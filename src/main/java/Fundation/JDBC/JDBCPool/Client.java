package Fundation.JDBC.JDBCPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * Created：Jeffrey
 * date   ：2021/3/23 9:30
 */
public class Client {
    public static void main(String[] args) {
        DataSource dataSource=new ComboPooledDataSource();



    }
}
