package com.design.studentMamagement.service.impl;

import com.design.studentMamagement.pojo.Nucleic;
import com.design.studentMamagement.mapper.NucleicMapper;
import com.design.studentMamagement.pojo.Temperature;
import com.design.studentMamagement.service.NucleicService;
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
 * (Nucleic)表服务实现类
 *
 * @author makejava
 * @since 2022-12-14 20:28:46
 */
@Service("nucleicService")
public class NucleicServiceImpl implements NucleicService {
    @Autowired
    private NucleicMapper nucleicMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Nucleic> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Nucleic> list= nucleicMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Nucleic nucleic: list){
                nucleic.setImagesUrl("http://localhost:8087/file/"+nucleic.getImages());
            }
        }
        //根据条件查询数据的条数
        Integer count = nucleicMapper.getPageListCount(page);
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
    public RestFulBean<Nucleic> queryById(Integer id) {
       Nucleic nucleic=this.nucleicMapper.queryById(id);
         return RestFulBean.succ(nucleic);
    }

    /**
     * 新增数据
     *
     * @param nucleic 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Nucleic nucleic) {
        Nucleic nucleiced = this.nucleicMapper.getByUserNoAndDate(nucleic);
        if(nucleiced!=null){
            return RestFulBean.error("该日期已经上传,请不要重复上传");
        }
        this.nucleicMapper.insert(nucleic);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param nucleic 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Nucleic nucleic) {
        this.nucleicMapper.update(nucleic);//执行数据库的修改语句 根据id 修改
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
        this.nucleicMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> getTotalByDay(Nucleic nucleic) {
        Map result =new HashMap(); //定义一个对象
        List countList=new ArrayList(); //定义一个数量的数组
        List dayList =new ArrayList();//定义一个日期的数组
        List<Nucleic> lsit = nucleicMapper.getTotalByDay(nucleic); //获取每日上传体温检测的学生数量
        for(Nucleic nucleiced :lsit)
        {
            countList.add(nucleiced.getCount()); //把学生数量加到数组里面去
            dayList.add(nucleiced.getDay());//把日期加到数组里面去
        }
        result.put("countList",countList);  //将处理好的数据返回前端
        result.put("dayList",dayList);
        return RestFulBean.succ(result);
    }
}
