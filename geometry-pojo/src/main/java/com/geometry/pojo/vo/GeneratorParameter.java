package com.geometry.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "构造器实体", description = "主要传入构造器需要的属性")
public class GeneratorParameter implements Serializable {

    private static final long serialVersionUID = 5337686803239756484L;

    @ApiModelProperty(value = "设置作者", name = "Author", required = true)
    private String Author;
    @ApiModelProperty(value = "自定义包路径", name = "PacketPath", required = true)
    private String PacketPath;
    @ApiModelProperty(value = "数据库驱动", name = "DriverName", required = true)
    private String DriverName;
    @ApiModelProperty(value = "数据库URL", name = "Url", required = true)
    private String Url;
    @ApiModelProperty(value = "数据库用户名", name = "UserName", required = true)
    private String UserName;
    @ApiModelProperty(value = "数据库密码", name = "PassWord", required = true)
    private String PassWord;
    @ApiModelProperty(value = "数据库类型", name = "Type", required = true)
    private String Type;
    @ApiModelProperty(value = "表前缀", name = "TablePrefix", required = true)
    private String TablePrefix;
    @ApiModelProperty(value = "表名称数组", name = "Include", required = true)
    private String[] Include;

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPacketPath() {
        return PacketPath;
    }

    public void setPacketPath(String packetPath) {
        PacketPath = packetPath;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTablePrefix() {
        return TablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        TablePrefix = tablePrefix;
    }

    public String[] getInclude() {
        return Include;
    }

    public void setInclude(String[] include) {
        Include = include;
    }
}
