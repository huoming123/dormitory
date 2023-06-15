package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.DormitoryLive;
import com.design.studentMamagement.service.DormitoryLiveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.studentMamagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.studentMamagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (DormitoryLive)表控制层
 *
 * @author makejava
 * @since 2022-12-12 22:30:01
 */
@RestController
@RequestMapping("/dormitoryLive")
public class DormitoryLiveController {
    /**
     * 服务对象
     */
    @Autowired
    private DormitoryLiveService dormitoryLiveService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<DormitoryLive>page) throws Exception{
        return this.dormitoryLiveService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<DormitoryLive> queryById(@RequestBody DormitoryLive dormitoryLive) {
        return this.dormitoryLiveService.queryById(dormitoryLive.getId());
    }

    /**
     * 新增数据
     *
     * @param dormitoryLive 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody DormitoryLive dormitoryLive) {
        return this.dormitoryLiveService.insert(dormitoryLive);
    }

    /**
     * 编辑数据
     *
     * @param dormitoryLive 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody DormitoryLive dormitoryLive) {
        return this.dormitoryLiveService.update(dormitoryLive);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody DormitoryLive dormitoryLive) {
        return this.dormitoryLiveService.deleteById(dormitoryLive.getId());
    }

}

