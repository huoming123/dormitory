package com.design.studentMamagement.service;

import com.design.studentMamagement.pojo.Dormitory;
import com.design.studentMamagement.pojo.res.RestFulBean;
import com.design.studentMamagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Dormitory)表服务接口
 *
 * @author makejava
 * @since 2022-12-12 22:29:46
 */
public interface DormitoryService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Dormitory> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Dormitory> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param dormitory 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Dormitory dormitory);

    /**
     * 修改数据
     *
     * @param dormitory 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Dormitory dormitory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);


    RestFulBean<List<Dormitory>> getDormitoryList(Dormitory dormitory);

    RestFulBean<List<Dormitory>> getDormitory(Dormitory dormitory);
}
