package com.geometry.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geometry.mapper.SystemResourcesMapper;
import com.geometry.pojo.bo.SystemResources;
import com.geometry.pojo.vo.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaoqiaohui
 * @since 2019-11-13
 */
@Api(description = "资源查询器",tags = {"SystemResourcesController"})
@RestController
@RequestMapping("/systemResources")
public class SystemResourcesController {

    @Autowired
    private SystemResourcesMapper systemResourcesMapper;

    @ApiOperation(value = "查询分页", httpMethod = "GET")
    @GetMapping("/listPage/{pageNum}/{pageSize}/{resourceName}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页数",defaultValue = "10", required = true),
            @ApiImplicitParam(name = "resourceName", value = "查询资源名称")
    })
    public Message listPage(@PathVariable int pageNum, @PathVariable int pageSize,String resourceName){
        //分页的简便语法。不用专门定义分页类。
        IPage<SystemResources> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SystemResources> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(SystemResources::getResourceName, resourceName);
        wrapper.orderByDesc(SystemResources::getId);
        try {
            page = systemResourcesMapper.selectPage( page, wrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Message().ok(200, "查询成功！").addData("page",page);
    }

}
