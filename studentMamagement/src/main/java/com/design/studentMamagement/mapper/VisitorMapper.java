package com.design.studentMamagement.mapper;

import com.design.studentMamagement.pojo.Visitor;
import java.util.List;
import com.design.studentMamagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Visitor)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-12 22:31:58
 */
public interface VisitorMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Visitor queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Visitor> getPageListByCondition(@Param("page") Page<Visitor> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Visitor> page);


    /**
     * 新增数据
     *
     * @param visitor 实例对象
     * @return 影响行数
     */
    int insert(Visitor visitor);




    /**
     * 修改数据
     *
     * @param visitor 实例对象
     * @return 影响行数
     */
    int update(Visitor visitor);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

