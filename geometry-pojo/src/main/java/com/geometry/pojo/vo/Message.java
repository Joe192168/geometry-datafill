package com.geometry.pojo.vo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: geometry-bi
 * @description: 前后端统一消息定义协议 Message  之后前后端数据交互都按照规定的类型进行交互
 * @author: 肖乔辉
 * @create: 2018-08-17 15:39
 * @version: 1.0.0
 */
public class Message {

    // 消息头meta 存放状态信息 code message
    private Map<String,Object> meta = new HashMap<String,Object>();
    // 消息内容  存储实体交互数据
    private Map<String,Object> data = new HashMap<String,Object>();

    public Map<String, Object> getMeta() {
        return meta;
    }

    public Message setMeta(Map<String, Object> meta) {
        this.meta = meta;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Message setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }
    public Message addMeta(String key, Object object) {
        this.meta.put(key,object);
        return this;
    }
    public Message addData(String key,Object object) {
        this.data.put(key,object);
        return this;
    }
    public Message ok(int statusCode,String statusMsg) {
        this.addMeta("success",Boolean.TRUE);
        this.addMeta("code",statusCode);
        this.addMeta("msg",statusMsg);
        this.addMeta("timestamp",new Timestamp(new Date().getTime()));
        return this;
    }
    public Message error(int statusCode,String statusMsg) {
        this.addMeta("success",Boolean.FALSE);
        this.addMeta("code",statusCode);
        this.addMeta("msg",statusMsg);
        this.addMeta("timestamp",new Timestamp(new Date().getTime()));
        return this;
    }

    public Message ok() {
        this.addMeta("success",Boolean.TRUE);
        this.addMeta("code",200);
        this.addMeta("msg","操作成功");
        this.addMeta("timestamp",new Timestamp(new Date().getTime()));
        return this;
    }


    public Message error() {
        this.addMeta("success",Boolean.FALSE);
        this.addMeta("code",500);
        this.addMeta("msg","操作失败");
        this.addMeta("timestamp",new Timestamp(new Date().getTime()));
        return this;
    }
}
