package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.Repairs;
import com.design.studentMamagement.service.RepairsService;
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
 * (Repairs)表控制层
 *
 * @author makejava
 * @since 2022-12-14 20:29:10
 */
@RestController
@RequestMapping("/repairs")
public class RepairsController {
    /**
     * 服务对象
     */
    @Autowired
    private RepairsService repairsService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Repairs>page) throws Exception{
        return this.repairsService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Repairs> queryById(@RequestBody Repairs repairs) {
        return this.repairsService.queryById(repairs.getId());
    }

    /**
     * 新增数据
     *
     * @param repairs 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Repairs repairs) {
        return this.repairsService.insert(repairs);
    }

    /**
     * 编辑数据
     *
     * @param repairs 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Repairs repairs) {
        return this.repairsService.update(repairs);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Repairs repairs) {
        return this.repairsService.deleteById(repairs.getId());
    }

}

