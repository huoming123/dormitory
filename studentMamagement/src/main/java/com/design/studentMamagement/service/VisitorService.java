package com.design.studentMamagement.service;

import com.design.studentMamagement.pojo.Visitor;
import com.design.studentMamagement.pojo.res.RestFulBean;
import com.design.studentMamagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Visitor)表服务接口
 *
 * @author makejava
 * @since 2022-12-12 22:31:58
 */
public interface VisitorService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Visitor> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Visitor> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param visitor 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Visitor visitor);

    /**
     * 修改数据
     *
     * @param visitor 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Visitor visitor);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
