package com.design.studentMamagement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Message)实体类
 *
 * @author makejava
 * @since 2022-12-15 15:18:45
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 330352490016706784L;
    /**
     * 主键 自增id
     */
    private Integer id;
    /**
     * 留言
     */
    private String message;
    /**
     * 留言时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
    /**
     * 留言人
     */
    private String createdBy;
    /**
     * 宿管回复留言
     */
    private String dorMessage;
    /**
     * 回复人
     */
    private String dormitory;
    /**
     * 回复时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateAt;
    /**
     * 管理员回复留言
     */
    private String admMessage;
    /**
     * 学号
     */
    private String userNo;
    private Boolean disabled;
    private Boolean adminDisabled;

    public Boolean getAdminDisabled() {
        return adminDisabled;
    }

    public void setAdminDisabled(Boolean adminDisabled) {
        this.adminDisabled = adminDisabled;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDorMessage() {
        return dorMessage;
    }

    public void setDorMessage(String dorMessage) {
        this.dorMessage = dorMessage;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getAdmMessage() {
        return admMessage;
    }

    public void setAdmMessage(String admMessage) {
        this.admMessage = admMessage;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

}
