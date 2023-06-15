package com.design.studentMamagement.mapper;

import com.design.studentMamagement.pojo.DormitoryLive;
import java.util.List;
import com.design.studentMamagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (DormitoryLive)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-12 22:30:01
 */
public interface DormitoryLiveMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DormitoryLive queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<DormitoryLive> getPageListByCondition(@Param("page") Page<DormitoryLive> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<DormitoryLive> page);


    /**
     * 新增数据
     *
     * @param dormitoryLive 实例对象
     * @return 影响行数
     */
    int insert(DormitoryLive dormitoryLive);




    /**
     * 修改数据
     *
     * @param dormitoryLive 实例对象
     * @return 影响行数
     */
    int update(DormitoryLive dormitoryLive);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

