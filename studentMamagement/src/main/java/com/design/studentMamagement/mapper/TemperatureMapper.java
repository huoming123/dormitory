package com.design.studentMamagement.mapper;

import com.design.studentMamagement.pojo.Temperature;
import java.util.List;
import com.design.studentMamagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Temperature)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-14 20:31:56
 */
public interface TemperatureMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Temperature queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Temperature> getPageListByCondition(@Param("page") Page<Temperature> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Temperature> page);


    /**
     * 新增数据
     *
     * @param temperature 实例对象
     * @return 影响行数
     */
    int insert(Temperature temperature);




    /**
     * 修改数据
     *
     * @param temperature 实例对象
     * @return 影响行数
     */
    int update(Temperature temperature);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Temperature> getTotalByDay(Temperature temperature);
}

