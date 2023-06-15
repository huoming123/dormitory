package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.Build;
import com.design.studentMamagement.pojo.Dormitory;
import com.design.studentMamagement.service.DormitoryService;
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
 * (Dormitory)表控制层
 *
 * @author makejava
 * @since 2022-12-12 22:29:46
 */
@RestController
@RequestMapping("/dormitory")
public class DormitoryController {
    /**
     * 服务对象
     */
    @Autowired
    private DormitoryService dormitoryService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Dormitory>page) throws Exception{
        return this.dormitoryService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Dormitory> queryById(@RequestBody Dormitory dormitory) {
        return this.dormitoryService.queryById(dormitory.getId());
    }

    /**
     * 新增数据
     *
     * @param dormitory 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Dormitory dormitory) {
        return this.dormitoryService.insert(dormitory);
    }

    /**
     * 编辑数据
     *
     * @param dormitory 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Dormitory dormitory) {
        return this.dormitoryService.update(dormitory);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Dormitory dormitory) {
        return this.dormitoryService.deleteById(dormitory.getId());
    }
    /**
     * 获取宿舍下拉数据
     *
     * @param id 主键
     * @return
     */
    @PostMapping("/get/dormitory/list")
    public RestFulBean<List<Dormitory>> getDormitoryList(@RequestBody Dormitory dormitory) {
        return this.dormitoryService.getDormitoryList(dormitory);
    }
    /**
     * 获取宿舍信息
     *
     * @param id 主键
     * @return
     */
    @PostMapping("/get/dormitory")
    public RestFulBean<List<Dormitory>> getDormitory(@RequestBody Dormitory dormitory) {
        return this.dormitoryService.getDormitory(dormitory);
    }
}

