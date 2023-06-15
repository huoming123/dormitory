package com.design.studentMamagement.service;

import com.design.studentMamagement.pojo.DormitoryLive;
import com.design.studentMamagement.pojo.res.RestFulBean;
import com.design.studentMamagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (DormitoryLive)表服务接口
 *
 * @author makejava
 * @since 2022-12-12 22:30:01
 */
public interface DormitoryLiveService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<DormitoryLive> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<DormitoryLive> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param dormitoryLive 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(DormitoryLive dormitoryLive);

    /**
     * 修改数据
     *
     * @param dormitoryLive 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(DormitoryLive dormitoryLive);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
