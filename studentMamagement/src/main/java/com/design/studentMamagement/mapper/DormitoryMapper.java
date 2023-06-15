package com.design.studentMamagement.mapper;

import com.design.studentMamagement.pojo.Dormitory;
import java.util.List;
import com.design.studentMamagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Dormitory)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-12 22:29:46
 */
public interface DormitoryMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dormitory queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Dormitory> getPageListByCondition(@Param("page") Page<Dormitory> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Dormitory> page);


    /**
     * 新增数据
     *
     * @param dormitory 实例对象
     * @return 影响行数
     */
    int insert(Dormitory dormitory);




    /**
     * 修改数据
     *
     * @param dormitory 实例对象
     * @return 影响行数
     */
    int update(Dormitory dormitory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    List<Dormitory> getDormitoryList(Dormitory dormitory);



    List<Dormitory> getDormitoryByBuild(Dormitory dormitory);

    Dormitory getDormitory(String dormitoryNo, String build);
}

