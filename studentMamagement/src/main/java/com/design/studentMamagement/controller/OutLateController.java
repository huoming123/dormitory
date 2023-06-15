package com.design.studentMamagement.controller;

import com.design.studentMamagement.dto.Page;
import com.design.studentMamagement.pojo.Goods;
import com.design.studentMamagement.pojo.OutLate;
import com.design.studentMamagement.service.OutLateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.studentMamagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * (OutLate)表控制层
 *
 * @author makejava
 * @since 2022-12-14 12:04:47
 */
@RestController
@RequestMapping("/outLate")
public class OutLateController {
    /**
     * 服务对象
     */
    @Autowired
    private OutLateService outLateService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public RestFulBean<OutLate> queryById(Integer id) {
        return this.outLateService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param outLate 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody OutLate outLate) {
        return this.outLateService.insert(outLate);
    }

    /**
     * 编辑数据
     *
     * @param outLate 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody OutLate outLate) {
        return this.outLateService.update(outLate);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody OutLate outLate) {
        return this.outLateService.deleteById(outLate.getId());
    }
    /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<OutLate> page) throws Exception{
        return this.outLateService.getList(page);
    }
}
