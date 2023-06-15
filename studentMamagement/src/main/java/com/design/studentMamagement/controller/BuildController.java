package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.Build;
import com.design.studentMamagement.service.BuildService;
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
 * (Build)表控制层
 *
 * @author makejava
 * @since 2022-12-12 22:23:25
 */
@RestController
@RequestMapping("/build")
public class BuildController {
    /**
     * 服务对象
     */
    @Autowired
    private BuildService buildService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Build>page) throws Exception{
        return this.buildService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Build> queryById(@RequestBody Build build) {
        return this.buildService.queryById(build.getId());
    }

    /**
     * 新增数据
     *
     * @param build 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Build build) {
        return this.buildService.insert(build);
    }

    /**
     * 编辑数据
     *
     * @param build 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Build build) {
        return this.buildService.update(build);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Build build) {
        return this.buildService.deleteById(build.getId());
    }
    /**
     * 获取学楼下拉数据
     *
     * @param id 主键
     * @return
     */
    @PostMapping("/get/build/list")
    public RestFulBean<List<Build>> getBuildList() {
        return this.buildService.getBuildList();
    }
}

