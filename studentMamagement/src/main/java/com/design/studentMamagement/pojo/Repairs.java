package com.design.studentMamagement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Repairs)实体类
 *
 * @author makejava
 * @since 2022-12-15 12:03:46
 */
public class Repairs implements Serializable {
    private static final long serialVersionUID = 551882919743951724L;
    /**
     * 主键 自增id
     */
    private Integer id;
    /**
     * 记录那栋楼的报修
     */
    private String buildName;
    /**
     * 报修的物品
     */
    private String repairsName;
    /**
     * 报修的问题
     */
    private String reason;
    /**
     * 记录哪个宿舍报修
     */
    private String dormitoryNo;
    /**
     * 报修时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    /**
     * 报修人
     */
    private String createdBy;
    /**
     * 报修的状态 -1不通过 1 通过 0 未处理
     */
    private Integer status;
    /**
     * 管理员审核 1 为通过 0 为未审核 -1 为不通过
     */
    private Integer checked;
    /**
     * 8位学号
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

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getRepairsName() {
        return repairsName;
    }

    public void setRepairsName(String repairsName) {
        this.repairsName = repairsName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDormitoryNo() {
        return dormitoryNo;
    }

    public void setDormitoryNo(String dormitoryNo) {
        this.dormitoryNo = dormitoryNo;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

}
