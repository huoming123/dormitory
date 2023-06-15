package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.Nucleic;
import com.design.studentMamagement.pojo.Temperature;
import com.design.studentMamagement.service.NucleicService;
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
 * (Nucleic)表控制层
 *
 * @author makejava
 * @since 2022-12-14 20:28:45
 */
@RestController
@RequestMapping("/nucleic")
public class NucleicController {
    /**
     * 服务对象
     */
    @Autowired
    private NucleicService nucleicService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Nucleic>page) throws Exception{
        return this.nucleicService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Nucleic> queryById(@RequestBody Nucleic nucleic) {
        return this.nucleicService.queryById(nucleic.getId());
    }

    /**
     * 新增数据
     *
     * @param nucleic 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Nucleic nucleic) {
        return this.nucleicService.insert(nucleic);
    }

    /**
     * 编辑数据
     *
     * @param nucleic 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Nucleic nucleic) {
        return this.nucleicService.update(nucleic);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Nucleic nucleic) {
        return this.nucleicService.deleteById(nucleic.getId());
    }
    /**
     * 统计每日上传核酸的学生人数
     *
     * @param
     * @return
     */
    @PostMapping("/get/total/by/day")
    public RestFulBean<Map> getTotalByDay(@RequestBody Nucleic nucleic) throws Exception{
        return this.nucleicService.getTotalByDay(nucleic);
    }
}

