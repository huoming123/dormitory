package com.design.studentMamagement.service.impl;

import com.design.studentMamagement.pojo.Temperature;
import com.design.studentMamagement.mapper.TemperatureMapper;
import com.design.studentMamagement.pojo.User;
import com.design.studentMamagement.service.TemperatureService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.studentMamagement.pojo.res.RestFulBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.studentMamagement.util.PageUtil;
import com.design.studentMamagement.dto.Page;
/**
 * (Temperature)表服务实现类
 *
 * @author makejava
 * @since 2022-12-14 20:31:56
 */
@Service("temperatureService")
public class TemperatureServiceImpl implements TemperatureService {
    @Autowired
    private TemperatureMapper temperatureMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Temperature> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Temperature> list= temperatureMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = temperatureMapper.getPageListCount(page);
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
    public RestFulBean<Temperature> queryById(Integer id) {
       Temperature temperature=this.temperatureMapper.queryById(id);
         return RestFulBean.succ(temperature);
    }

    /**
     * 新增数据
     *
     * @param temperature 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Temperature temperature) {
        if(temperature.getUserNo()==null)
        {
            return RestFulBean.error("学号不能为空");
        }
        if(temperature.getUserName()==null)
        {
            return RestFulBean.error("姓名不能为空");
        }
        if(temperature.getMornRegister()!=null) //早上体温
        {
            if(35.9<temperature.getMornRegister()&&temperature.getMornRegister()<37.1) //判断体温是否在36-37之间
            {
                temperature.setStatus(1); //如果是则说明体温正常
            }
            else{
                temperature.setStatus(0); //否则体温不正常
            }
        }
        if(temperature.getNoonRegister()!=null) //中午体温
        {
            if(35.9<temperature.getNoonRegister()&&temperature.getNoonRegister()<37.1) //判断体温是否在36-37之间
            {
                temperature.setStatus(1); //如果是则说明体温正常
            }
            else{
                temperature.setStatus(0); //否则体温不正常
            }
        }
        if(temperature.getNightRegister()!=null) //晚上体温
        {
            if(35.9<temperature.getNightRegister()&&temperature.getNightRegister()<37.1) //判断体温是否在36-37之间
            {
                temperature.setStatus(1); //如果是则说明体温正常
            }
            else{
                temperature.setStatus(0); //否则体温不正常
            }
        }
        this.temperatureMapper.insert(temperature);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param temperature 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Temperature temperature) {
        if(temperature.getMornRegister()!=null) //早上体温
        {
            if(35.9<temperature.getMornRegister()&&temperature.getMornRegister()<37.1) //判断体温是否在36-37之间
            {
                temperature.setStatus(1); //如果是则说明体温正常
            }
            else{
                temperature.setStatus(0); //否则体温不正常
            }
        }
        if(temperature.getNoonRegister()!=null) //中午体温
        {
            if(35.9<temperature.getNoonRegister()&&temperature.getNoonRegister()<37.1) //判断体温是否在36-37之间
            {
                temperature.setStatus(1); //如果是则说明体温正常
            }
            else{
                temperature.setStatus(0); //否则体温不正常
            }
        }
        if(temperature.getNightRegister()!=null) //晚上体温
        {
            if(35.9<temperature.getNightRegister()&&temperature.getNightRegister()<37.1) //判断体温是否在36-37之间
            {
                temperature.setStatus(1); //如果是则说明体温正常
            }
            else{
                temperature.setStatus(0); //否则体温不正常
            }
        }
        this.temperatureMapper.update(temperature);//执行数据库的修改语句 根据id 修改
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

        this.temperatureMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> getTotalByDay(Temperature temperature) {
        Map result =new HashMap(); //定义一个对象
        List countList=new ArrayList(); //定义一个数量的数组
        List dayList =new ArrayList();//定义一个日期的数组
        List<Temperature> lsit = temperatureMapper.getTotalByDay(temperature); //获取每日上传体温检测的学生数量
        for(Temperature temperatured :lsit)
        {
            countList.add(temperatured.getCount()); //把学生数量加到数组里面去
            dayList.add(temperatured.getDay());//把日期加到数组里面去
        }
        result.put("countList",countList);  //将处理好的数据返回前端
        result.put("dayList",dayList);
        return RestFulBean.succ(result);
    }
}
