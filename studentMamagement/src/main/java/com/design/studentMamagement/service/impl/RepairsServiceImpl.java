package com.design.studentMamagement.service.impl;

import com.design.studentMamagement.pojo.Repairs;
import com.design.studentMamagement.mapper.RepairsMapper;
import com.design.studentMamagement.service.RepairsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.studentMamagement.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.studentMamagement.util.PageUtil;
import com.design.studentMamagement.dto.Page;
/**
 * (Repairs)表服务实现类
 *
 * @author makejava
 * @since 2022-12-14 20:29:10
 */
@Service("repairsService")
public class RepairsServiceImpl implements RepairsService {
    @Autowired
    private RepairsMapper repairsMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Repairs> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Repairs> list= repairsMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Repairs repairs: list){
               if(repairs.getStatus()==0){ //判断报修状态 如果为0 说明还未处理 则学生跟宿管可以编辑报修的数据
                   repairs.setDisabled(false);
               }
               else {
                   repairs.setDisabled(true); //否则 说明已经处理了 则不可编辑数据
               }
               if (repairs.getChecked()==0){//判断管理员审核状态 如果为0 说明还未审核 则管理员可以审核报修的数据
                   repairs.setAdminDisabled(false);
               }
               else {
                   repairs.setAdminDisabled(true);//否则 说明已经处理了 则不可编辑数据
               }
            }
        }
        //根据条件查询数据的条数
        Integer count = repairsMapper.getPageListCount(page);
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
    public RestFulBean<Repairs> queryById(Integer id) {
       Repairs repairs=this.repairsMapper.queryById(id);
         return RestFulBean.succ(repairs);
    }

    /**
     * 新增数据
     *
     * @param repairs 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Repairs repairs) {
        this.repairsMapper.insert(repairs);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param repairs 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Repairs repairs) {
        this.repairsMapper.update(repairs);//执行数据库的修改语句 根据id 修改
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
        this.repairsMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
