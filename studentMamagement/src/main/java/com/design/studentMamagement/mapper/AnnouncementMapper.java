package com.design.studentMamagement.mapper;

import com.design.studentMamagement.pojo.Announcement;
import java.util.List;
import com.design.studentMamagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Announcement)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-14 20:27:45
 */
public interface AnnouncementMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Announcement queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Announcement> getPageListByCondition(@Param("page") Page<Announcement> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Announcement> page);


    /**
     * 新增数据
     *
     * @param announcement 实例对象
     * @return 影响行数
     */
    int insert(Announcement announcement);




    /**
     * 修改数据
     *
     * @param announcement 实例对象
     * @return 影响行数
     */
    int update(Announcement announcement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Announcement> getMessageList();
}

