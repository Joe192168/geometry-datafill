package com.geometry.servers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geometry.pojo.utils.PageUtils;
import java.util.List;
import java.util.Map;

public interface IMetaLoader {

    /**
     * 获得数据库的一些相关信息
     */
    Map<String, Object> getDataBaseInformations();

    /**
     * 获得该用户下面的所有表
     */
    List<Map<String, Object>> getAllTableList();

    /**
     * 获得该用户下面的所有视图
     */
    List<Map<String, Object>> getAllViewList();

    /**
     * 获得数据库中所有方案名称
     */
    List<String> getAllSchemas();

    /**
     * 获得表或视图中的所有列信息
     */
    List<Map<String, Object>> getTableColumns(String tableName);

    /**
     * 获得一个表的索引信息
     */
    List<Map<String, Object>> getIndexInfo(String tableName);

    /**
     * 获得一个表的主键信息
     */
    Map<String, Object> getAllPrimaryKeys(String tableName);

    /**
     * 获得一个表的外键信息
     */
    List<Map<String, Object>> getAllExportedKeys(String tableName);

    /**
     * 执行sql并返回list集合
     * @param sql
     * @return
     */
    List<Map<String, Object>> getQuerySQLByList(String sql);

    /**
     * 查询sql属性
     * @param sql
     * @return
     */
    List<Map<String, Object>> getListColumn(String sql);

    /**
     * @Description TODO增删改的通用方法
     * @Author joe
     * @Date 2019/10/23 9:40
     * @Param [sql 要执行的sql, args 对象类型的数组  里面存放着 sql执行的占位符参数]
     * @Return boolean
     * @Exception
     */
    boolean executeUpdate(String sql, Object... args);

    /**
     * @Program: geometry-bi
     * @Description: TODO通用带参sql查询
     * @Author: xiaoqiaohui
     * @Create: 2019/10/25 10:46
     * @Version: 1.0.0
     */
    List<Map<String, Object>> executeQuery(String sql, Object... args);

    /**
     * 通用insert
     *
     * @param tabName
     * @return
     */
    boolean insert(String tabName, String[] fields, Object[] data);

    /**
     * 删除表数据
     * @param fields 参数字段
     * @param data 参数字段数据
     * @param tabName 表名称
     */
    boolean delete(String tabName, String[] fields, String[] data);


    /**
     * 更新表数据
     * @param fields 参数字段
     * @param data 参数字段数据
     * @param conditions 参数字段
     * @param conditions_param 参数字段数据
     * @param tabName 表名称
     */
    boolean update(String tabName, String[] fields, String[] data, String[] conditions, String[] conditions_param);

    /**
     * 查询表 【查询结果的顺序要和数据库字段的顺序一致】
     * @param tabName 表名
     * @param fields 参数字段
     * @param data 参数字段数据
     * @param tab_fields 数据库的字段
     * @param page 页数
     */
    List<Map<String,Object>> query(String tabName, String[] fields, String[] data, String[] tab_fields, PageUtils page);


    /**
     * 查询表分页
     * @param sql sql
     * @param pageNum 第几页
     * @param pageSize 页数
     * @param dbType 数据库类型
     */
    Page getPageList(String sql, int pageNum, int pageSize,String dbType);

}
