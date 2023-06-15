package com.design.studentMamagement.service;

import com.design.studentMamagement.pojo.Announcement;
import com.design.studentMamagement.pojo.res.RestFulBean;
import com.design.studentMamagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Announcement)表服务接口
 *
 * @author makejava
 * @since 2022-12-14 20:27:45
 */
public interface AnnouncementService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Announcement> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Announcement> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param announcement 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Announcement announcement);

    /**
     * 修改数据
     *
     * @param announcement 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Announcement announcement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Announcement>> getMessageList();
}
