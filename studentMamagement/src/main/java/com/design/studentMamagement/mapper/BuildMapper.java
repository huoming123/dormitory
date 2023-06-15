package com.design.studentMamagement.mapper;

import com.design.studentMamagement.pojo.Build;
import java.util.List;
import com.design.studentMamagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Build)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-12 22:23:28
 */
public interface BuildMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Build queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Build> getPageListByCondition(@Param("page") Page<Build> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Build> page);


    /**
     * 新增数据
     *
     * @param build 实例对象
     * @return 影响行数
     */
    int insert(Build build);




    /**
     * 修改数据
     *
     * @param build 实例对象
     * @return 影响行数
     */
    int update(Build build);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Build> getBuildList();

    Build getByName(Build build);
}

