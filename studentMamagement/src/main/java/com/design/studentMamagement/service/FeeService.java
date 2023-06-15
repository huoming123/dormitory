package com.design.studentMamagement.service;

import com.design.studentMamagement.pojo.Fee;
import com.design.studentMamagement.pojo.res.RestFulBean;
import com.design.studentMamagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Fee)表服务接口
 *
 * @author makejava
 * @since 2022-12-12 22:30:32
 */
public interface FeeService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Fee> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Fee> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param fee 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Fee fee);

    /**
     * 修改数据
     *
     * @param fee 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Fee fee);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
