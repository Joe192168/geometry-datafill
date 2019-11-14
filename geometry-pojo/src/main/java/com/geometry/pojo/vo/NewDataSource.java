package com.geometry.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "数据源实体", description = "主要传入数据源需要的属性")
public class NewDataSource implements Serializable {

    private static final long serialVersionUID = 8987455574943493788L;
    @ApiModelProperty(value = "数据源用户名", name = "username", required = true)
    private String username;
    @ApiModelProperty(value = "数据源密码", name = "password", required = true)
    private String password;
    @ApiModelProperty(value = "数据源ip", name = "dataIp", required = true)
    private String dataIp;
    @ApiModelProperty(value = "数据源端口", name = "dataPort", required = true)
    private String dataPort;
    @ApiModelProperty(value = "数据源类型", name = "dataType", required = true)
    private String dataType;
    @ApiModelProperty(value = "数据库名称", name = "dataName", required = true)
    private String dataName;
    @ApiModelProperty(value = "数据域", name = "schemaName")
    private String schemaName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDataIp() {
        return dataIp;
    }

    public void setDataIp(String dataIp) {
        this.dataIp = dataIp;
    }

    public String getDataPort() {
        return dataPort;
    }

    public void setDataPort(String dataPort) {
        this.dataPort = dataPort;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    @Override
    public String toString() {
        return "NewDataSource{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dataIp='" + dataIp + '\'' +
                ", dataPort='" + dataPort + '\'' +
                ", dataType='" + dataType + '\'' +
                ", dataName='" + dataName + '\'' +
                ", schemaName='" + schemaName + '\'' +
                '}';
    }
}
