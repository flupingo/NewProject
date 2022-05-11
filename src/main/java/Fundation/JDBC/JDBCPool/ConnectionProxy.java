package Fundation.JDBC.JDBCPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * Created：Jeffrey
 * date   ：2021/3/22 18:27
 */
public class ConnectionProxy implements InvocationHandler {
    //真实连接
    private Connection realConnection;
    private MyDataSource dataSource;
    //代理连接
    private  Connection proxyConnection;

    public Connection getRealConnection() {
        return realConnection;
    }

    public void setRealConnection(Connection realConnection) {
        this.realConnection = realConnection;
    }

    public MyDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(MyDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ConnectionProxy(Connection connection, MyDataSource dataSource) {
        this.realConnection = connection;
        this.dataSource = dataSource;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
