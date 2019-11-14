package com.geometry.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geometry.pojo.bo.SystemResources;
import com.geometry.pojo.vo.Message;
import com.geometry.servers.IDataFrom;
import com.geometry.servers.INumberControlService;
import com.geometry.servers.ISystemResourcesService;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

@Api(description = "数据填报接口",tags = {"DataFromController"})
@RestController
@Log4j2
public class DataFromController {

    @Autowired
    private IDataFrom iDataFrom;

    @Autowired
    private INumberControlService numberControlService;

    @Autowired
    private ISystemResourcesService iSystemResourcesService;

    @ApiOperation(value = "保存数据源",httpMethod = "POST")
    @PostMapping("/saveDataSource")
    public Message saveDataSource(@RequestBody @ApiParam(name = "对象", value = "传入json格式", required = true) SystemResources systemResources){
        boolean falg = false;
        String msg = null;
        try {
            //查询序列id
            BigDecimal number = numberControlService.getMaxmum("t_system_resources");
            systemResources.setId(number);
            systemResources.setCreateTime(new Date());
            systemResources.setUpdateTime(new Date());
            falg = iSystemResourcesService.save(systemResources);
        } catch (Exception e) {
            log.error("DataFromController-->> saveDataSource",e);
            msg = e.getMessage();
        }
        return falg ? new Message().ok(200, "保存成功！") : new Message().error(500, msg);
    }

    @ApiOperation(value = "查询分页", httpMethod = "GET")
    @GetMapping("/getPageList/{sql}/{pageNum}/{pageSize}/{dataSourceId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sql", value = "sql", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageNum", value = "第几页",defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页数",defaultValue = "10", paramType = "path", required = true),
            @ApiImplicitParam(name = "dataSourceId", value = "数据源id", required = true)
    })
    public Message getPageList(@PathVariable String sql, @PathVariable int pageNum, @PathVariable int pageSize, @PathVariable BigDecimal dataSourceId){
        Page pagelist = null;
        boolean falg = false;
        String msg = null;
        try {
            pagelist = iDataFrom.getPageList(sql,pageNum,pageSize,dataSourceId);

            if (pagelist.getSize()>0){
                falg = true;
            }
        } catch (SQLException e) {
            log.error("DataFromController-->> getPageList",e);
            msg = e.getMessage();
        }
        return falg ? new Message().ok(200, "查询成功！").addData("pagelist",pagelist) : new Message().error(500, msg);
    }

    @ApiOperation(value = "保存表单",httpMethod = "POST")
    @PostMapping("/save")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tabName", value = "表名称", required = true),
            @ApiImplicitParam(name = "fields", value = "参数字段", required = true),
            @ApiImplicitParam(name = "data", value = "参数字段数据", required = true),
            @ApiImplicitParam(name = "dataSourceId", value = "数据源id", required = true)
    })
    public Message save(@RequestParam String tabName,@RequestParam String[] fields,@RequestParam String[] data,@RequestParam BigDecimal dataSourceId){
        boolean falg = false;
        String msg = null;
        try {
            falg = iDataFrom.insert(tabName,fields,data,dataSourceId);
        } catch (SQLException e) {
            log.error("DataFromController-->> save",e);
            msg = e.getMessage();
        }
        return falg ? new Message().ok(200, "保存成功！") : new Message().error(500, msg);
    }

}
