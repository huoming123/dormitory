package com.design.studentMamagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Grade)实体类
 *
 * @author makejava
 * @since 2022-12-15 14:46:08
 */
public class Grade implements Serializable {
    private static final long serialVersionUID = -67251046363655166L;
    /**
     * 主键 自增id
     */
    private Integer id;
    /**
     * 记录那栋楼的评分
     */
    private String buildName;
    /**
     * 记录哪个宿舍评分
     */
    private String dormitoryNo;
    /**
     * 评分时间
     */
    private Date createdAt;
    /**
     * 评分人
     */
    private String createdBy;
    /**
     * 床铺评分(20分)
     */
    private Double bed;
    /**
     * 地面评分(20分)
     */
    private Double floor;
    /**
     * 墙壁是否有乱画(20分)
     */
    private Double wall;
    /**
     * 厕所卫生(20分)
     */
    private Double toilet;
    /**
     * 物品摆放(20分)
     */
    private Double layout;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 月份
     */
    private Integer month;

    private  Double totalScore;
    private String excellent;

    public String getExcellent() {
        return excellent;
    }

    public void setExcellent(String excellent) {
        this.excellent = excellent;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
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

    public Double getBed() {
        return bed;
    }

    public void setBed(Double bed) {
        this.bed = bed;
    }

    public Double getFloor() {
        return floor;
    }

    public void setFloor(Double floor) {
        this.floor = floor;
    }

    public Double getWall() {
        return wall;
    }

    public void setWall(Double wall) {
        this.wall = wall;
    }

    public Double getToilet() {
        return toilet;
    }

    public void setToilet(Double toilet) {
        this.toilet = toilet;
    }

    public Double getLayout() {
        return layout;
    }

    public void setLayout(Double layout) {
        this.layout = layout;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

}
