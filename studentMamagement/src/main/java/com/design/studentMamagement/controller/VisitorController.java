package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.Visitor;
import com.design.studentMamagement.service.VisitorService;
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
 * (Visitor)表控制层
 *
 * @author makejava
 * @since 2022-12-12 22:31:58
 */
@RestController
@RequestMapping("/visitor")
public class VisitorController {
    /**
     * 服务对象
     */
    @Autowired
    private VisitorService visitorService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Visitor>page) throws Exception{
        return this.visitorService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Visitor> queryById(@RequestBody Visitor visitor) {
        return this.visitorService.queryById(visitor.getId());
    }

    /**
     * 新增数据
     *
     * @param visitor 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Visitor visitor) {
        return this.visitorService.insert(visitor);
    }

    /**
     * 编辑数据
     *
     * @param visitor 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Visitor visitor) {
        return this.visitorService.update(visitor);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Visitor visitor) {
        return this.visitorService.deleteById(visitor.getId());
    }

}

