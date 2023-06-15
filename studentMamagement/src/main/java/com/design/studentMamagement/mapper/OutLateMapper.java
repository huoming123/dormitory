package com.design.studentMamagement.mapper;

import com.design.studentMamagement.dto.Page;
import com.design.studentMamagement.pojo.OutLate;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (OutLate)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-14 12:04:48
 */
public interface OutLateMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OutLate queryById(Integer id);


    /**
     * 新增数据
     *
     * @param outLate 实例对象
     * @return 影响行数
     */
    int insert(OutLate outLate);


    /**
     * 修改数据
     *
     * @param outLate 实例对象
     * @return 影响行数
     */
    int update(OutLate outLate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<OutLate> getPageListByCondition(@Param("page") Page<OutLate> page);

    Integer getPageListCount(@Param("page") Page<OutLate> page);
}
