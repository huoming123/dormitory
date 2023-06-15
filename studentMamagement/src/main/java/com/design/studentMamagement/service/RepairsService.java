package com.design.studentMamagement.service;

import com.design.studentMamagement.pojo.Repairs;
import com.design.studentMamagement.pojo.res.RestFulBean;
import com.design.studentMamagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Repairs)表服务接口
 *
 * @author makejava
 * @since 2022-12-14 20:29:10
 */
public interface RepairsService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Repairs> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Repairs> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param repairs 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Repairs repairs);

    /**
     * 修改数据
     *
     * @param repairs 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Repairs repairs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
