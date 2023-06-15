package com.design.studentMamagement.service;

import com.design.studentMamagement.dto.Page;
import com.design.studentMamagement.pojo.OutLate;
import com.design.studentMamagement.pojo.res.RestFulBean;

import java.util.Map;

/**
 * (OutLate)表服务接口
 *
 * @author makejava
 * @since 2022-12-14 12:04:48
 */
public interface OutLateService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<OutLate> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param outLate 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(OutLate outLate);

    /**
     * 修改数据
     *
     * @param outLate 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(OutLate outLate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> getList(Page<OutLate> page) throws Exception;
}
