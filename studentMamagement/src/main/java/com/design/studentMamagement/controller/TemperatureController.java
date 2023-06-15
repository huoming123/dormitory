package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.Temperature;
import com.design.studentMamagement.service.TemperatureService;
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
 * (Temperature)表控制层
 *
 * @author makejava
 * @since 2022-12-14 20:31:51
 */
@RestController
@RequestMapping("/temperature")
public class TemperatureController {
    /**
     * 服务对象
     */
    @Autowired
    private TemperatureService temperatureService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Temperature>page) throws Exception{
        return this.temperatureService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Temperature> queryById(@RequestBody Temperature temperature) {
        return this.temperatureService.queryById(temperature.getId());
    }

    /**
     * 新增数据
     *
     * @param temperature 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Temperature temperature) {
        return this.temperatureService.insert(temperature);
    }

    /**
     * 编辑数据
     *
     * @param temperature 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Temperature temperature) {
        return this.temperatureService.update(temperature);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Temperature temperature) {
        return this.temperatureService.deleteById(temperature.getId());
    }
    /**
     * 统计每日上传体温的学生人数
     *
     * @param
     * @return
     */
    @PostMapping("/get/total/by/day")
    public RestFulBean<Map> getTotalByDay(@RequestBody Temperature temperature) throws Exception{
        return this.temperatureService.getTotalByDay(temperature);
    }
}

