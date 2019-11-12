package com.geometry.pojo.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.geometry.pojo.vo.NewDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Program: geometry-bi
 * @Description: TODO数据源管理工具
 * @Author: xiaoqiaohui
 * @Create: 2019/11/8 15:01
 * @Version: 1.0.0
 */
public class DataSourceUtils {

    /**
     * 创建数据源对象
     */
    public static DataSource createDataSource(NewDataSource newDataSource) {
        DruidDataSource dataSource = new DruidDataSource();
        String jdbcUrl =String.format(getDbtypeByDriver(newDataSource.getDataType()),newDataSource.getDataIp(),newDataSource.getDataPort(),newDataSource.getDataName());
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(newDataSource.getUsername());
        dataSource.setPassword(newDataSource.getPassword());
        //解决oracle读取不到REMARKS表注解设置
        Properties properties = new Properties();
        properties.setProperty("remarks", "true");
        properties.setProperty("useInformationSchema", "true");
        dataSource.setConnectProperties(properties);
        //配置初始化大小、最小、最大
        dataSource.setInitialSize(1);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(20);
        //连接泄漏监测
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(30);
        //配置获取连接等待超时的时间
        dataSource.setMaxWait(20000);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(20000);
        return dataSource;
    }

    /**
     * 根据数据库类型得到对应的驱动
     * @param _dbType
     * @return
     */
    public static String getDbtypeByDriver(String _dbType) {
        String _driver = "";
        switch (_dbType) {
            case "oracle":
                _driver = "jdbc:oracle:thin:@%s:%s:%s";
                break;
            case "mysql":
                _driver =  "jdbc:mysql://%s:%s/%s?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
                break;
            case "postgresql":
                _driver =  "jdbc:postgresql://%s:%s/%s";
                break;
            case "sqlserver":
                _driver =  "jdbc:sqlserver://%s:%s;databaseName=%s";
                break;
            case "db2":
                _driver =  "jdbc:db2://%s:%s/%s";
                break;
            default:
                return null;
        }
        return _driver;
    }

    /**
     * 释放资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void colseResource(Connection conn,Statement st,ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
        closeConnection(conn);
    }

    /**
     * 释放连接 Connection
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if(conn !=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        conn = null;
    }

    /**
     * 释放语句执行者 Statement
     * @param st
     */
    public static void closeStatement(Statement st) {
        if(st !=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        st = null;
    }

    /**
     * 释放结果集 ResultSet
     * @param rs
     */
    public static void closeResultSet(ResultSet rs) {
        if(rs !=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        rs = null;
    }

}