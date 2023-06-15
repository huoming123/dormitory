package com.design.studentMamagement.mapper;

import com.design.studentMamagement.pojo.Repairs;
import java.util.List;
import com.design.studentMamagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Repairs)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-14 20:29:10
 */
public interface RepairsMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Repairs queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Repairs> getPageListByCondition(@Param("page") Page<Repairs> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Repairs> page);


    /**
     * 新增数据
     *
     * @param repairs 实例对象
     * @return 影响行数
     */
    int insert(Repairs repairs);




    /**
     * 修改数据
     *
     * @param repairs 实例对象
     * @return 影响行数
     */
    int update(Repairs repairs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

