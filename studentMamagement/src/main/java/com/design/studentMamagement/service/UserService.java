package com.design.studentMamagement.service;

import com.design.studentMamagement.pojo.User;
import com.design.studentMamagement.pojo.res.RestFulBean;
import com.design.studentMamagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-12-12 22:30:57
 */
public interface UserService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<User> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<User> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> login(User user);

    RestFulBean<Map> upload(MultipartFile coverFile)throws Exception;


    RestFulBean<String> addDormitory(User user);


    RestFulBean<List<User>> getDormitoryList();

    RestFulBean<List<User>> getUserByDormitoryNo(User user);

    RestFulBean<Map> getTotalByYear();
}
