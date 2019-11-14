package com.geometry.pojo.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaoqiaohui
 * @since 2019-11-13
 */
@TableName("t_system_resources")
public class SystemResources extends Model<SystemResources> {

    private static final long serialVersionUID = 1L;

    private BigDecimal id;

    private BigDecimal parentid;

    private BigDecimal resourceTypeId;

    private String resourceName;

    private String displayName;

    private BigDecimal displayOrder;

    private String description;

    private String displayImg;

    private String resourceLevel;

    private BigDecimal isInnerResource;

    private BigDecimal owner;

    private Date createTime;

    private Date updateTime;

    private BigDecimal lastEditor;

    private BigDecimal resourceState;

    private String externalAppInfo;

    private BigDecimal deriveResourceId;

    private String contentInfo;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getParentid() {
        return parentid;
    }

    public void setParentid(BigDecimal parentid) {
        this.parentid = parentid;
    }

    public BigDecimal getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(BigDecimal resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public BigDecimal getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(BigDecimal displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayImg() {
        return displayImg;
    }

    public void setDisplayImg(String displayImg) {
        this.displayImg = displayImg;
    }

    public String getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(String resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public BigDecimal getIsInnerResource() {
        return isInnerResource;
    }

    public void setIsInnerResource(BigDecimal isInnerResource) {
        this.isInnerResource = isInnerResource;
    }

    public BigDecimal getOwner() {
        return owner;
    }

    public void setOwner(BigDecimal owner) {
        this.owner = owner;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(BigDecimal lastEditor) {
        this.lastEditor = lastEditor;
    }

    public BigDecimal getResourceState() {
        return resourceState;
    }

    public void setResourceState(BigDecimal resourceState) {
        this.resourceState = resourceState;
    }

    public String getExternalAppInfo() {
        return externalAppInfo;
    }

    public void setExternalAppInfo(String externalAppInfo) {
        this.externalAppInfo = externalAppInfo;
    }

    public BigDecimal getDeriveResourceId() {
        return deriveResourceId;
    }

    public void setDeriveResourceId(BigDecimal deriveResourceId) {
        this.deriveResourceId = deriveResourceId;
    }

    public String getContentInfo() {
        return contentInfo;
    }

    public void setContentInfo(String contentInfo) {
        this.contentInfo = contentInfo;
    }

    @Override
    public String toString() {
        return "SystemResources{" +
                "id=" + id +
                ", parentid=" + parentid +
                ", resourceTypeId=" + resourceTypeId +
                ", resourceName='" + resourceName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", displayOrder='" + displayOrder + '\'' +
                ", description='" + description + '\'' +
                ", displayImg='" + displayImg + '\'' +
                ", resourceLevel='" + resourceLevel + '\'' +
                ", isInnerResource=" + isInnerResource +
                ", owner=" + owner +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", lastEditor=" + lastEditor +
                ", resourceState=" + resourceState +
                ", externalAppInfo='" + externalAppInfo + '\'' +
                ", deriveResourceId=" + deriveResourceId +
                ", contentInfo='" + contentInfo + '\'' +
                '}';
    }
}
