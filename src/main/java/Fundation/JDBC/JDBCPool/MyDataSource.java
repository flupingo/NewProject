package Fundation.JDBC.JDBCPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created：Jeffrey
 * date   ：2021/3/22 18:11
 */
public class MyDataSource implements MyDatasourceInterface {
    private String username;
    private String password;
    private  String url;

    public MyDataSource(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return getConnection(username, password);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return doConnection(username, password);
    }

    private Connection doConnection(String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
