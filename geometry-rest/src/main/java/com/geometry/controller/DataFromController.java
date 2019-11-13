package com.geometry.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geometry.pojo.vo.Message;
import com.geometry.pojo.vo.NewDataSource;
import com.geometry.servers.IDataFrom;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"数据表单分页"})
@RestController
public class DataFromController {

    @Autowired
    private IDataFrom iDataFrom;

    @ApiOperation(value = "查询分页", httpMethod = "POST")
    @PostMapping("/getPageList/{sql}/{pageNum}/{pageSize}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sql", value = "sql", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageNum", value = "第几页",defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页数",defaultValue = "10", paramType = "path", required = true)
    })
    public Message getPageList(@PathVariable String sql, @PathVariable int pageNum, @PathVariable int pageSize, @RequestBody @ApiParam(name = "对象", value = "传入json格式", required = true) NewDataSource dataSource){
        Page pagelist = iDataFrom.getPageList(sql,pageNum,pageSize,dataSource);
        return new Message().ok(200, "查询成功！").addData("pagelist",pagelist);
    }

}
