package com.design.studentMamagement.service.impl;

import com.design.studentMamagement.pojo.Build;
import com.design.studentMamagement.mapper.BuildMapper;
import com.design.studentMamagement.service.BuildService;
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
 * (Build)表服务实现类
 *
 * @author makejava
 * @since 2022-12-12 22:23:27
 */
@Service("buildService")
public class BuildServiceImpl implements BuildService {
    @Autowired
    private BuildMapper buildMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Build> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Build> list= buildMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Build build: list){
                build.setImagesUrl("http://localhost:8087/file/"+build.getImages());
            }
        }
        //根据条件查询数据的条数
        Integer count = buildMapper.getPageListCount(page);
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
    public RestFulBean<Build> queryById(Integer id) {
       Build build=this.buildMapper.queryById(id);
         return RestFulBean.succ(build);
    }

    /**
     * 新增数据
     *
     * @param build 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Build build) {
        if(build.getName()==null)
        {
            return RestFulBean.error("宿舍楼不能为空");
        }
        Build builded =buildMapper.getByName(build);
        if(builded!=null){
            return RestFulBean.error("该宿舍楼已经添加，请不要重复添加");
        }
        this.buildMapper.insert(build);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param build 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Build build) {
        this.buildMapper.update(build);//执行数据库的修改语句 根据id 修改
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
        this.buildMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Build>> getBuildList() {
        List<Build> list = buildMapper.getBuildList();
        return RestFulBean.succ(list);
    }
}