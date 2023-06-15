package com.design.studentMamagement.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Page<T> implements Serializable {
    private String query;
    private Integer pageSize;
    private Integer pageNum;
    //mysql limit 分页从第几条开始
    private Integer startNum;
    private T key;
    private Date startTime;
    private Date endTime;
    private Date sameTime;
    private Integer seq;
    private Integer showSeq;

    public Integer getShowSeq() {
        return showSeq;
    }

    public void setShowSeq(Integer showSeq) {
        this.showSeq = showSeq;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Date getSameTime() {
        return sameTime;
    }

    public void setSameTime(Date sameTime) {
        this.sameTime = sameTime;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
