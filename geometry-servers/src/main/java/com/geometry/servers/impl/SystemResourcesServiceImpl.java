package com.geometry.servers.impl;

import com.geometry.persistence.mapper.SystemResourcesMapper;
import com.geometry.pojo.bo.SystemResources;
import com.geometry.servers.ISystemResourcesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaoqiaohui
 * @since 2019-11-13
 */
@Service
public class SystemResourcesServiceImpl extends ServiceImpl<SystemResourcesMapper, SystemResources> implements ISystemResourcesService {

}
