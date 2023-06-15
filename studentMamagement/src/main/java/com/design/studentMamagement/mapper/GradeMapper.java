package com.design.studentMamagement.mapper;

import com.design.studentMamagement.pojo.Grade;
import java.util.List;
import com.design.studentMamagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Grade)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-14 20:28:06
 */
public interface GradeMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Grade queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Grade> getPageListByCondition(@Param("page") Page<Grade> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Grade> page);


    /**
     * 新增数据
     *
     * @param grade 实例对象
     * @return 影响行数
     */
    int insert(Grade grade);




    /**
     * 修改数据
     *
     * @param grade 实例对象
     * @return 影响行数
     */
    int update(Grade grade);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

