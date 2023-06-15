package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.Fee;
import com.design.studentMamagement.service.FeeService;
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
 * (Fee)表控制层
 *
 * @author makejava
 * @since 2022-12-12 22:30:32
 */
@RestController
@RequestMapping("/fee")
public class FeeController {
    /**
     * 服务对象
     */
    @Autowired
    private FeeService feeService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Fee>page) throws Exception{
        return this.feeService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Fee> queryById(@RequestBody Fee fee) {
        return this.feeService.queryById(fee.getId());
    }

    /**
     * 新增数据
     *
     * @param fee 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Fee fee) {
        return this.feeService.insert(fee);
    }

    /**
     * 编辑数据
     *
     * @param fee 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Fee fee) {
        return this.feeService.update(fee);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Fee fee) {
        return this.feeService.deleteById(fee.getId());
    }

}

