package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.User;
import com.design.studentMamagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.studentMamagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.studentMamagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-12-12 22:30:57
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;


     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<User>page) throws Exception{
        return this.userService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<User> queryById(@RequestBody User user) {
        return this.userService.queryById(user.getId());
    }

    /**
     * 新增学生数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody User user) {
        return this.userService.insert(user);
    }

    /**
     * 新增宿管数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping("/add/dormitory")
    public RestFulBean<String> addDormitory(@RequestBody User user) {
        return this.userService.addDormitory(user);
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody User user) {
        return this.userService.update(user);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody User user) {
        return this.userService.deleteById(user.getId());
    }
    /**
     * 登录接口
     *
     * @param users 实体
     * @return 登录接口
     */
    @PostMapping("/login")
    public RestFulBean<Map> login(@RequestBody  User user) {
        return this.userService.login(user);
    }


    //上传照片
    @PostMapping("/upload/image")
    public RestFulBean<Map> upload(@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception {
        return userService.upload(coverFile);
    }
    /**
     * 根据宿舍号获取该宿舍居住的人员资料
     *
     * @param users 实体
     * @return
     */
    @PostMapping("/get/by/dormitoryNo")
    public RestFulBean<List<User>> getUserByDormitoryNo(@RequestBody  User user) {
        return this.userService.getUserByDormitoryNo(user);
    }

    /**
     * 获取宿管人员数据
     *
     * @param users 实体
     * @return
     */
    @PostMapping("/get/dormitory/list")
    public RestFulBean<List<User>> getDormitoryList() {
        return this.userService.getDormitoryList();
    }

    /**
     * 根据年份获取每年入住学生数量
     *
     * @param
     * @return
     */
    @PostMapping("/get/total/by/year")
    public RestFulBean<Map> getTotalByYear() throws Exception{
        return this.userService.getTotalByYear();
    }

}

