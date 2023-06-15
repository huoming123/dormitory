package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.Grade;
import com.design.studentMamagement.service.GradeService;
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
 * (Grade)表控制层
 *
 * @author makejava
 * @since 2022-12-14 20:28:06
 */
@RestController
@RequestMapping("/grade")
public class GradeController {
    /**
     * 服务对象
     */
    @Autowired
    private GradeService gradeService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Grade>page) throws Exception{
        return this.gradeService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Grade> queryById(@RequestBody Grade grade) {
        return this.gradeService.queryById(grade.getId());
    }

    /**
     * 新增数据
     *
     * @param grade 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Grade grade) {
        return this.gradeService.insert(grade);
    }

    /**
     * 编辑数据
     *
     * @param grade 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Grade grade) {
        return this.gradeService.update(grade);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Grade grade) {
        return this.gradeService.deleteById(grade.getId());
    }

}

