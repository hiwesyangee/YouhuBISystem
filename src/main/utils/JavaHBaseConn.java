package utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

/**
 * HBase连接类Java版本
 *
 * @author Hiwes
 * @version 1.0
 * @since 2018/10/15
 */
public class JavaHBaseConn {
    private static final JavaHBaseConn INSTANCE = new JavaHBaseConn();
    private static Configuration configuration;
    private static Connection connection;

    /**
     * HBase配置信息
     */
    private JavaHBaseConn() {
        try {
            if (configuration == null) {
                configuration = HBaseConfiguration.create();
//                configuration.set("hbase.zookeeper.quorum", "master:2181,slave1:2181,slave2:2181");
                configuration.set("hbase.zookeeper.quorum", "hiwes:2181");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * HBase连接
     */
    private Connection getConnection() {
        if (connection == null || connection.isClosed()) {
            try {
                connection = ConnectionFactory.createConnection(configuration);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 获取HBase连接
     */
    public static Connection getHBaseConn() {
        return INSTANCE.getConnection();
    }

    /**
     * 获取HBase表对象
     */
    public static Table getTable(String tableName) throws IOException {
        return INSTANCE.getConnection().getTable(TableName.valueOf(tableName));
    }

    /**
     * 关闭Hbase连接
     */
    public static void closeConn() {
        if (connection != null) {
            try {
                connection.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

}
