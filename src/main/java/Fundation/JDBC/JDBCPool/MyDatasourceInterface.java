package Fundation.JDBC.JDBCPool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * Created：Jeffrey
 * date   ：2021/3/22 18:08
 */
public interface MyDatasourceInterface extends DataSource {
    //default
    @Override
    default public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    default public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    default public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    default public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    default public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    default public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    default public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    default public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    default public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
