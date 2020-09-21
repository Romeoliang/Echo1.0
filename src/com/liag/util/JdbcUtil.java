package com.liag.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JdbcUtil功能简述
 *      1. 程序预处理驱动问题和连接所需数据
 *      2. 获取数据库连接对象
 *      3. 关闭数据库操作所使用资源
 *
 * @author Anonymous
 */
public class JdbcUtil {
    /*
    定义一个DataSource数据库连接池静态成员变量
     */
    private static DataSource dataSource = null;

    static {

        try {
            /*
            加载druid.properties文件
             */
            Properties properties = new Properties();
            /*
            JdbcUtil.class.getClassLoader() 获取类加载器
            在类加载位置检索 "druid.properties" 文件，创建对应文件的InputStream 字节输入流对象
             */
            properties.load(JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties"));

            /*
            DruidDataSourceFactory.createDataSource(properties);
            通过DruidDataSourceFactory Druid数据库连接池工厂类，创建新的数据库连接对象
             */
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*

    直接在JdbcUtil工具类中创建ComboPooledDataSource类对象，返回值类型
    可以认为是DataSource 数据库连接池对象

     private static DataSource dataSource = new ComboPooledDataSource();
    */

    /**
     * 获取Connection 数据库连接对象
     *
     * @return Connection 对象。如果没有获取到数据库连接对象，返回null
     */
    public static Connection getConnection() {
        Connection connection = null;

        try {
            /*
             这里是通过数据库连接池获取数据库连接对象
             数据库连接池中的对象在调用close方法时，会被拦截，不是真的关闭
             数据库连接对象，而是规划给数据库连接池。
            */
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 获取当前JdbcUtil工具类中处理得到的数据连接对象
     *
     * @return DataSource数据库连接对象
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void close(Connection connection) {
        close(connection, null, null);
    }

    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源使用方法，需要的参数是AutoCloseable接口实现类对象，
     * 不定长参数
     *
     * @param source AutoCloseable... 不定长参数
     */
    public static void close(AutoCloseable... source) {
        // 不定长参数在方法中就是一个数组！！！
        for (AutoCloseable closeable : source) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
