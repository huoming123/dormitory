package com.design.studentMamagement.mapper;

import com.design.studentMamagement.pojo.User;
import java.util.List;
import com.design.studentMamagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-12 22:30:57
 */
public interface UserMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<User> getPageListByCondition(@Param("page") Page<User> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<User> page);


    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);




    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    User getByUserNo(@Param("userNo")String userNo, @Param("role")String role);



    List<User> getDormitoryList();

    List<User> getByDormitoryNo(String dormitoryNo, String build);

    List<User> getUserByYear();
}

