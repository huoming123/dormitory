package com.design.studentMamagement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.swing.text.StyledEditorKit;
import java.util.Date;
import java.io.Serializable;

/**
 * (Fee)实体类
 *
 * @author makejava
 * @since 2022-12-13 10:30:07
 */
public class Fee implements Serializable {
    private static final long serialVersionUID = 124377936693365570L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 记录那栋楼的水电费
     */
    private String buildName;
    /**
     * 记录哪个宿舍水电费
     */
    private String dormitoryNo;
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
     * 水电费每年一交
     */
    private Integer year;
    /**
     * 用水量(记录用了多少吨水)
     */
    private Double water;
    /**
     * 总费用
     */
    private Double fee;
    /**
     * 电费
     */
    private Double electricFee;
    /**
     * 水费
     */
    private Double waterFee;
    /**
     * 缴费状态 1为已交 0 为未交
     */
    private Integer status;
    /**
     * 用电(记录用了多少度电)
     */
    private Double ele;

    private Boolean disabled;

    public Double getWater() {
        return water;
    }

    public void setWater(Double water) {
        this.water = water;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getElectricFee() {
        return electricFee;
    }

    public void setElectricFee(Double electricFee) {
        this.electricFee = electricFee;
    }

    public Double getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(Double waterFee) {
        this.waterFee = waterFee;
    }

    public Double getEle() {
        return ele;
    }

    public void setEle(Double ele) {
        this.ele = ele;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



}
