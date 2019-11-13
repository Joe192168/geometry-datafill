package com.geometry.pojo.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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

    private String id;

    private String parentid;

    private String resourceTypeId;

    private String resourceName;

    private String displayName;

    private String displayOrder;

    private String description;

    private String displayImg;

    private String resourceLevel;

    private String isInnerResource;

    private String owner;

    private Date createTime;

    private Date updateTime;

    private String lastEditor;

    private String resourceState;

    private String externalAppInfo;

    private String deriveResourceId;

    private String contentInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }
    public String getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(String resourceTypeId) {
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
    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
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
    public String getIsInnerResource() {
        return isInnerResource;
    }

    public void setIsInnerResource(String isInnerResource) {
        this.isInnerResource = isInnerResource;
    }
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
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
    public String getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(String lastEditor) {
        this.lastEditor = lastEditor;
    }
    public String getResourceState() {
        return resourceState;
    }

    public void setResourceState(String resourceState) {
        this.resourceState = resourceState;
    }
    public String getExternalAppInfo() {
        return externalAppInfo;
    }

    public void setExternalAppInfo(String externalAppInfo) {
        this.externalAppInfo = externalAppInfo;
    }
    public String getDeriveResourceId() {
        return deriveResourceId;
    }

    public void setDeriveResourceId(String deriveResourceId) {
        this.deriveResourceId = deriveResourceId;
    }
    public String getContentInfo() {
        return contentInfo;
    }

    public void setContentInfo(String contentInfo) {
        this.contentInfo = contentInfo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SystemResources{" +
        "id=" + id +
        ", parentid=" + parentid +
        ", resourceTypeId=" + resourceTypeId +
        ", resourceName=" + resourceName +
        ", displayName=" + displayName +
        ", displayOrder=" + displayOrder +
        ", description=" + description +
        ", displayImg=" + displayImg +
        ", resourceLevel=" + resourceLevel +
        ", isInnerResource=" + isInnerResource +
        ", owner=" + owner +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", lastEditor=" + lastEditor +
        ", resourceState=" + resourceState +
        ", externalAppInfo=" + externalAppInfo +
        ", deriveResourceId=" + deriveResourceId +
        ", contentInfo=" + contentInfo +
        "}";
    }
}
