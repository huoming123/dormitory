package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.Announcement;
import com.design.studentMamagement.service.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.studentMamagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.studentMamagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Announcement)表控制层
 *
 * @author makejava
 * @since 2022-12-14 20:27:45
 */
@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
    /**
     * 服务对象
     */
    @Autowired
    private AnnouncementService announcementService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Announcement>page) throws Exception{
        return this.announcementService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Announcement> queryById(@RequestBody Announcement announcement) {
        return this.announcementService.queryById(announcement.getId());
    }

    /**
     * 新增数据
     *
     * @param announcement 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Announcement announcement) {
        return this.announcementService.insert(announcement);
    }

    /**
     * 编辑数据
     *
     * @param announcement 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Announcement announcement) {
        return this.announcementService.update(announcement);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Announcement announcement) {
        return this.announcementService.deleteById(announcement.getId());
    }

    @PostMapping("/get/message/list")
    public RestFulBean<List<Announcement>> getMessageList() throws Exception{
        return this.announcementService.getMessageList();
    }

}

