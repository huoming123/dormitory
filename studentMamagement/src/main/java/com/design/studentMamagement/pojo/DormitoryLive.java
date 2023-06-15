package com.design.studentMamagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (DormitoryLive)实体类
 *
 * @author makejava
 * @since 2022-12-12 22:30:01
 */
public class DormitoryLive implements Serializable {
    private static final long serialVersionUID = 821893530204444371L;
     /**
     * 主键id
     */
    private Integer id;
     /**
     * 学生表id 跟user表关联
     */
    private Integer userId;
     /**
     * 学年
     */
    private Integer year;
     /**
     * 宿舍号
     */
    private String dormitoryNo;
     /**
     * 录入时间
     */
    private Date createdAt;
     /**
     * 记录哪栋宿舍楼
     */
    private String buildName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

}

