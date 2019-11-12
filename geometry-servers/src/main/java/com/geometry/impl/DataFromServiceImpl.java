package com.geometry.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geometry.pojo.vo.NewDataSource;
import com.geometry.servers.IDataFrom;
import org.springframework.stereotype.Service;

@Service
public class DataFromServiceImpl implements IDataFrom {
    @Override
    public Page getPageList(String sql, int pageNum, int pageSize, NewDataSource dataSource) {
        MetaLoaderImpl metaLoader = new MetaLoaderImpl(dataSource);
        return metaLoader.getPageList(sql,pageNum,pageSize,dataSource.getDataType());
    }
}
