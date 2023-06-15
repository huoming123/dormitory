package com.design.studentMamagement.mapper;

import com.design.studentMamagement.pojo.Submenu;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * (Submenu)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-02 09:07:08
 */
public interface SubmenuMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Submenu queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询条件
     * @param limit   查询条数
     * @return 对象列表
     */
    List<Submenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 统计总行数
     *
     * @param submenu 查询条件
     * @return 总行数
     */
    long count(Submenu submenu);

    /**
     * 新增数据
     *
     * @param submenu 实例对象
     * @return 影响行数
     */
    int insert(Submenu submenu);



    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Submenu> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Submenu> entities);

    /**
     * 修改数据
     *
     * @param submenu 实例对象
     * @return 影响行数
     */
    int update(Submenu submenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    void addMenu(Submenu submenu);

    void updateMenu(Submenu submenu);

    List<Submenu> getSubMenu(String type);

    List<Submenu> getByMainId(Integer id);
}

