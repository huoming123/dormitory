package com.design.studentMamagement.service;

import com.design.studentMamagement.pojo.Build;
import com.design.studentMamagement.pojo.res.RestFulBean;
import com.design.studentMamagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Build)表服务接口
 *
 * @author makejava
 * @since 2022-12-12 22:23:27
 */
public interface BuildService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Build> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Build> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param build 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Build build);

    /**
     * 修改数据
     *
     * @param build 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Build build);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Build>> getBuildList();
}
