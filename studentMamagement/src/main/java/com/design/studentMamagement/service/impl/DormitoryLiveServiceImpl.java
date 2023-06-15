package com.design.studentMamagement.service.impl;

import com.design.studentMamagement.pojo.DormitoryLive;
import com.design.studentMamagement.mapper.DormitoryLiveMapper;
import com.design.studentMamagement.service.DormitoryLiveService;
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
 * (DormitoryLive)表服务实现类
 *
 * @author makejava
 * @since 2022-12-12 22:30:01
 */
@Service("dormitoryLiveService")
public class DormitoryLiveServiceImpl implements DormitoryLiveService {
    @Autowired
    private DormitoryLiveMapper dormitoryLiveMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<DormitoryLive> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<DormitoryLive> list= dormitoryLiveMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(DormitoryLive dormitoryLive: list){
               
            }
        }
        //根据条件查询数据的条数
        Integer count = dormitoryLiveMapper.getPageListCount(page);
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
    public RestFulBean<DormitoryLive> queryById(Integer id) {
       DormitoryLive dormitoryLive=this.dormitoryLiveMapper.queryById(id);
         return RestFulBean.succ(dormitoryLive);
    }

    /**
     * 新增数据
     *
     * @param dormitoryLive 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(DormitoryLive dormitoryLive) {
        this.dormitoryLiveMapper.insert(dormitoryLive);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param dormitoryLive 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(DormitoryLive dormitoryLive) {
        this.dormitoryLiveMapper.update(dormitoryLive);//执行数据库的修改语句 根据id 修改
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
        this.dormitoryLiveMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
