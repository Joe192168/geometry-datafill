package com.geometry.servers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geometry.pojo.vo.NewDataSource;


public interface IDataFrom {

    /**
     * 查询表分页
     * @param sql sql
     * @param pageNum 第几页
     * @param pageSize 页数
     * @param dataSource 数据库实体
     */
    Page getPageList(String sql, int pageNum, int pageSize, NewDataSource dataSource);

}
