package com.design.studentMamagement.mapper;

import com.design.studentMamagement.pojo.Nucleic;
import java.util.List;
import com.design.studentMamagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Nucleic)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-14 20:28:46
 */
public interface NucleicMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Nucleic queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Nucleic> getPageListByCondition(@Param("page") Page<Nucleic> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Nucleic> page);


    /**
     * 新增数据
     *
     * @param nucleic 实例对象
     * @return 影响行数
     */
    int insert(Nucleic nucleic);




    /**
     * 修改数据
     *
     * @param nucleic 实例对象
     * @return 影响行数
     */
    int update(Nucleic nucleic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Nucleic getByUserNoAndDate(Nucleic nucleic);

    List<Nucleic> getTotalByDay(Nucleic nucleic);
}

