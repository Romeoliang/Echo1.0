package com.liag.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BaseDao {
    /**
     * 当前BaseDao中使用的DbUtils核心类 QueryRunner对象，并且使用
     * 静态成员变量处理方式在类文件加载阶段完成对象的创建过程，简化
     * 后期代码逻辑
     */
    private static QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

    /**
     * 通用查询操作方法，处理insert，delete，update 对应SQL语句
     *
     * @param sql        String SQL语句
     * @param parameters SQL语句对应的参数列表，不定长参数
     * @return 当前SQL语句操作对应当前数据库的受到影响的行数
     * @throws SQLException SQL异常
     */
    public int update(String sql, Object... parameters) throws SQLException {
        return queryRunner.update(sql, parameters);
    }

    public <T> T queryBean(String sql, Class<T> cls, Object... parameters) throws SQLException {
        return queryRunner.query(sql, new BeanHandler<>(cls), parameters);
    }

    public <T> List<T> queryBeanList(String sql, Class<T> cls, Object... parameters) throws SQLException {
        return queryRunner.query(sql, new BeanListHandler<>(cls), parameters);
    }

    public Object[] queryArray(String sql, Object... parameters) throws SQLException {
        return queryRunner.query(sql, new ArrayHandler(), parameters);
    }

    public List<Object[]> queryArrayList(String sql, Object... parameters) throws SQLException {
        return queryRunner.query(sql, new ArrayListHandler(), parameters);
    }

    public Map<String, Object> queryMap(String sql, Object... parameters) throws SQLException {
        return queryRunner.query(sql, new MapHandler(), parameters);
    }

    public List<Map<String, Object>> queryMapList(String sql, Object... parameters) throws SQLException {
        return queryRunner.query(sql, new MapListHandler(), parameters);
    }
}
