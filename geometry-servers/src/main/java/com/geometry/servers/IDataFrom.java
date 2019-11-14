package com.geometry.servers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geometry.pojo.vo.NewDataSource;

import java.math.BigDecimal;
import java.sql.SQLException;


public interface IDataFrom {

    /**
     * 查询表分页
     * @param sql sql
     * @param pageNum 第几页
     * @param pageSize 页数
     * @param dataSourceId 数据库id
     */
    Page getPageList(String sql, int pageNum, int pageSize, BigDecimal dataSourceId)throws SQLException;


    /**
     * 通用insert
     *
     * @param tabName
     * @return
     */
    boolean insert(String tabName, String[] fields, String[] data,BigDecimal dataSourceId)throws SQLException;

    /**
     * 删除表数据
     * @param fields 参数字段
     * @param data 参数字段数据
     * @param tabName 表名称
     */
    boolean delete(String tabName, String[] fields, String[] data, BigDecimal dataSourceId)throws SQLException;


    /**
     * 更新表数据
     * @param fields 参数字段
     * @param data 参数字段数据
     * @param conditions 参数字段
     * @param conditions_param 参数字段数据
     * @param tabName 表名称
     */
    boolean update(String tabName, String[] fields, String[] data, String[] conditions, String[] conditions_param,BigDecimal dataSourceId)throws SQLException;

}
