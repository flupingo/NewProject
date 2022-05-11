package Fundation.JDBC.JDBCPool;

import org.apache.activemq.jms.pool.ConnectionPool;
import org.apache.zookeeper.ZooKeeper;

import javax.jms.Connection;

/**
 * Created：Jeffrey
 * date   ：2021/3/22 22:12
 */
public class ZookeeperConnectionPool extends ConnectionPool {
    public ZookeeperConnectionPool(Connection connection) {
        super(connection);
    }
}
