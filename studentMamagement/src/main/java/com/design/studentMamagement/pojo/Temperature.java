package com.design.studentMamagement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Temperature)实体类
 *
 * @author makejava
 * @since 2022-12-15 09:19:24
 */
public class Temperature implements Serializable {
    private static final long serialVersionUID = -68865810510627033L;
    /**
     * 主键 自增id
     */
    private Integer id;
    /**
     * 学号为8位
     */
    private String userNo;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 早上体温登记
     */
    private Double mornRegister;
    /**
     * 中午体温登记
     */
    private Double noonRegister;
    /**
     * 晚上体温登记
     */
    private Double nightRegister;
    /**
     * 录入时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    /**
     * 录入人
     */
    private String createdBy;
    /**
     * 体温是否正常 1为正常 0为异常
     */
    private Integer status;
    /**
     * 记录是宿管还是学生的体温登记
     */
    private String role;

    private Integer count;
    private String day;
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getMornRegister() {
        return mornRegister;
    }

    public void setMornRegister(Double mornRegister) {
        this.mornRegister = mornRegister;
    }

    public Double getNoonRegister() {
        return noonRegister;
    }

    public void setNoonRegister(Double noonRegister) {
        this.noonRegister = noonRegister;
    }

    public Double getNightRegister() {
        return nightRegister;
    }

    public void setNightRegister(Double nightRegister) {
        this.nightRegister = nightRegister;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
