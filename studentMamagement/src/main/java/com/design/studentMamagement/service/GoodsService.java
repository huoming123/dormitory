package com.design.studentMamagement.service;

import com.design.studentMamagement.pojo.Goods;
import com.design.studentMamagement.pojo.res.RestFulBean;
import com.design.studentMamagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2022-12-12 22:30:45
 */
public interface GoodsService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Goods> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Goods> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Goods goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
