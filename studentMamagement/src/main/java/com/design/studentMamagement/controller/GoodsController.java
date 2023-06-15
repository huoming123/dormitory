package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.Goods;
import com.design.studentMamagement.service.GoodsService;
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
 * (Goods)表控制层
 *
 * @author makejava
 * @since 2022-12-12 22:30:45
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Autowired
    private GoodsService goodsService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Goods>page) throws Exception{
        return this.goodsService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Goods> queryById(@RequestBody Goods goods) {
        return this.goodsService.queryById(goods.getId());
    }

    /**
     * 新增数据
     *
     * @param goods 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Goods goods) {
        return this.goodsService.insert(goods);
    }

    /**
     * 编辑数据
     *
     * @param goods 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Goods goods) {
        return this.goodsService.update(goods);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Goods goods) {
        return this.goodsService.deleteById(goods.getId());
    }

}

