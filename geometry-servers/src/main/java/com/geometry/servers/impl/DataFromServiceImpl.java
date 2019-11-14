package com.geometry.servers.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geometry.pojo.bo.SystemResources;
import com.geometry.pojo.utils.JacksonUtil;
import com.geometry.pojo.vo.NewDataSource;
import com.geometry.servers.IDataFrom;
import com.geometry.servers.ISystemResourcesService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;

@Service
@Log4j2
public class DataFromServiceImpl implements IDataFrom {

    @Autowired
    private ISystemResourcesService iSystemResourcesService;

    @Override
    public Page getPageList(String sql, int pageNum, int pageSize, BigDecimal dataSourceId) throws SQLException {
        SystemResources systemResources = iSystemResourcesService.getById(dataSourceId);
        String contentInfo = systemResources.getContentInfo();
        NewDataSource newDataSource = JacksonUtil.stringToBean(contentInfo,NewDataSource.class);
        MetaLoaderImpl metaLoader = new MetaLoaderImpl(newDataSource);
        return metaLoader.getPageList(sql,pageNum,pageSize,newDataSource.getDataType());
    }

    @Override
    public boolean insert(String tabName, String[] fields, String[] data,BigDecimal dataSourceId) throws SQLException {
        MetaLoaderImpl metaLoader = null;
        SystemResources systemResources = iSystemResourcesService.getById(dataSourceId);
        if (systemResources!=null){
            NewDataSource newDataSource = JacksonUtil.stringToBean(systemResources.getContentInfo(),NewDataSource.class);
            metaLoader = new MetaLoaderImpl(newDataSource);
        }
        return metaLoader.insert(tabName,fields,data);
    }

    @Override
    public boolean delete(String tabName, String[] fields, String[] data,BigDecimal dataSourceId)throws SQLException {
        MetaLoaderImpl metaLoader = null;
        SystemResources systemResources = iSystemResourcesService.getById(dataSourceId);
        if (systemResources!=null){
            NewDataSource newDataSource = JacksonUtil.stringToBean(systemResources.getContentInfo(),NewDataSource.class);
            metaLoader = new MetaLoaderImpl(newDataSource);
        }
        return metaLoader.delete(tabName,fields,data);
    }

    @Override
    public boolean update(String tabName, String[] fields, String[] data, String[] conditions, String[] conditions_param,BigDecimal dataSourceId)throws SQLException {
        MetaLoaderImpl metaLoader = null;
        SystemResources systemResources = iSystemResourcesService.getById(dataSourceId);
        if (systemResources!=null){
            NewDataSource newDataSource = JacksonUtil.stringToBean(systemResources.getContentInfo(),NewDataSource.class);
            metaLoader = new MetaLoaderImpl(newDataSource);
        }
        return metaLoader.update(tabName,fields,data,conditions,conditions_param);
    }
}
