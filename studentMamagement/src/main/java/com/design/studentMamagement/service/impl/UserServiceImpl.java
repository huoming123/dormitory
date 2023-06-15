package com.design.studentMamagement.service.impl;

import com.design.studentMamagement.mapper.DormitoryLiveMapper;
import com.design.studentMamagement.mapper.DormitoryMapper;
import com.design.studentMamagement.pojo.Dormitory;
import com.design.studentMamagement.pojo.User;
import com.design.studentMamagement.mapper.UserMapper;
import com.design.studentMamagement.service.UserService;
import com.design.studentMamagement.util.FileUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.studentMamagement.pojo.res.RestFulBean;

import java.util.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.design.studentMamagement.util.PageUtil;
import com.design.studentMamagement.dto.Page;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-12-12 22:30:57
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private UserMapper userMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<User> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<User> list= userMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(User user: list){
                user.setImagesUrl("http://localhost:8087/file/"+user.getImages());
            }
        }
        //根据条件查询数据的条数
        Integer count = userMapper.getPageListCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<User> queryById(Integer id) {
       User user=this.userMapper.queryById(id); //根据id获取详情信息
        user.setImagesUrl( "http://localhost:8087/file/"+user.getImages()); //返回完整的本地照片到前端
         return RestFulBean.succ(user);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(User user) {
        if(user.getUserNo()==null)//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
        {
            return RestFulBean.error("学号不能为空");
        }
        if(user.getUserNo().trim().length()!=8){
            return RestFulBean.error("请输入8位的学号");
        }
        if(user.getSex()==null)
        {
            return RestFulBean.error("性别不能为空");
        }
        if(user.getStatus()==null)
        {
            return RestFulBean.error("状态不能为空");
        }
        if(user.getUserName()==null)
        {
            return RestFulBean.error("姓名不能为空");
        }
        if(user.getImages()==null)
        {
            return RestFulBean.error("照片不能为空");
        }
        if(user.getProfessional()==null)
        {
            return RestFulBean.error("专业不能为空");
        }
        if(user.getClasses()==null)
        {
            return RestFulBean.error("班级不能为空");
        }
        if(user.getBuild()==null)
        {
            return RestFulBean.error("宿舍楼不能为空");
        }
        if(user.getDormitoryNo()==null)
        {
            return RestFulBean.error("宿舍号不能为空");
        }
        if(user.getTelephone()==null)
        {
            return RestFulBean.error("手机号码不能为空");
        }
        if(user.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(user.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        Dormitory dormitory = dormitoryMapper.getDormitory(user.getDormitoryNo(),user.getBuild()); //根据宿舍号获取宿舍是四人宿舍还是6人宿舍
        List<User> lsit = userMapper.getByDormitoryNo(user.getDormitoryNo(),user.getBuild()); //根据宿舍号获取这件宿舍住了多少人
        if(lsit.size()>dormitory.getType() || lsit.size()==dormitory.getType()){ //判断宿舍住的人是不是已经满人了
            return RestFulBean.error("该宿舍已满人");
        }
        User usered =userMapper.getByUserNo(user.getUserNo(),user.getRole());//根据学号跟角色获取用户数据
        if(usered!=null&&user.getRole().equals("student")){//如果查出来数据不为空 说明该学生已经录入过了
            return RestFulBean.error("该学号已经录入,请不要重复录入");
        }
        user.setPassword("123456"); //学生默认密码为123456
        this.userMapper.insert(user);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(User user) {
        this.userMapper.update(user);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ("修改成功"); 
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.userMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
    @Override
    public RestFulBean<Map> login(User users) {
        if(users.getUserNo()==null)//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
        {
            return RestFulBean.error("学号不能为空");
        }
        if(users.getPassword()==null)
        {
            return RestFulBean.error("密码不能为空");
        }

        User user =userMapper.getByUserNo(users.getUserNo(),users.getRole());//根据学号跟角色获取用户数据
        //定义 一个map对象 用于返回数据给前端
        Map<String,Object> result =new HashMap<>();
        //如果用户不为空
        if (user!=null){
            //如果密码跟数据库一样
            if(users.getPassword().equals(user.getPassword()))
            {
                result.put("userName",user.getUserName());               //将用户名userName加到result对象里面
                result.put("userNo",user.getUserNo());  //将学号userNo加到result对象里面
                result.put("dormitoryNo",user.getDormitoryNo());   //将宿舍号加到result对象里面
                result.put("build",user.getBuild()); //将宿舍楼加到result对象里面
                result.put("role",user.getRole());//将角色加到result对象里面
                result.put("userId",user.getId());             //将用户id加到result对象里面

                return RestFulBean.succ(result);             //将数据返回给前端
            }
            else{   //如果密码跟数据库不一样 则返回密码错误
                return RestFulBean.error("密码错误");
            }

        }
        //如果用户为空 说明用户不存在
        return RestFulBean.error("用户不存在");
    }
    @Override
    public RestFulBean<Map> upload(MultipartFile coverFile) throws Exception {
        String destPath ="C:\\design\\wedding\\";//自定义一个路径
        // 存图片
        try{//用一个file文件上传的方法上传照片
            FileUtil.saveFile(coverFile, destPath,coverFile.getOriginalFilename());//上传图片的方法
        }
        catch(Exception e){
            return RestFulBean.error("请求异常");
        }
        Map map =new HashMap();//定义一个map对象
        //返回一个完整的本地照片路径用于前端显示
        map.put("url","http://localhost:8087/file/"+coverFile.getOriginalFilename());
        //把照片的名字重新返回给前端用于保存到数据库users表的images字段中
        map.put("imageName",coverFile.getOriginalFilename());
        return RestFulBean.succ(map);
    }



    @Override
    public RestFulBean<String> addDormitory(User user) {
        if(user.getUserNo()==null)//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
        {
            return RestFulBean.error("宿管不能为空");
        }
        if(user.getUserNo().trim().length()!=8){
            return RestFulBean.error("请输入8位的宿管编号");
        }
        if(user.getSex()==null)
        {
            return RestFulBean.error("性别不能为空");
        }
        if(user.getUserName()==null)
        {
            return RestFulBean.error("姓名不能为空");
        }
        if(user.getImages()==null)
        {
            return RestFulBean.error("照片不能为空");
        }
        if(user.getBuild()==null)
        {
            return RestFulBean.error("宿舍楼不能为空");
        }
        if(user.getTelephone()==null)
        {
            return RestFulBean.error("手机号码不能为空");
        }
        if(user.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(user.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        User usered =userMapper.getByUserNo(user.getUserNo(),user.getRole());//根据宿管跟角色获取宿管数据
        if(usered!=null&&user.getRole().equals("student")){//如果查出来数据不为空 说明该宿管已经录入过了
            return RestFulBean.error("该宿管编号已经录入,请不要重复录入");
        }
        user.setPassword("123456"); //默认密码为123456
        this.userMapper.insert(user);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    @Override
    public RestFulBean<List<User>> getDormitoryList() {
        List<User> list =userMapper.getDormitoryList();
        for (User user:list)
        {
            user.setImagesUrl( "http://localhost:8087/file/"+user.getImages()); //返回完整的本地照片到前端
        }
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<List<User>> getUserByDormitoryNo(User user) {
        List<User> lsit = userMapper.getByDormitoryNo(user.getDormitoryNo(),user.getBuild()); //根据宿舍号获取这件宿舍住了多少人
        return RestFulBean.succ(lsit);
    }

    @Override
    public RestFulBean<Map> getTotalByYear() {
        Map result =new HashMap(); //定义一个对象
        List countList=new ArrayList(); //定义一个数量的数组
        List yearList =new ArrayList();//定义一个年份的数组
        List<User> lsit = userMapper.getUserByYear(); //根据年份获取入住学生数量
        for(User user :lsit)
        {
            countList.add(user.getCount()); //把每年的入住学生数量加到数组里面去
            yearList.add(user.getYear());//把年份加到数组里面去
        }
        result.put("countList",countList);  //将处理好的数据返回前端
        result.put("yearList",yearList);
        return RestFulBean.succ(result);
    }
}
