package com.design.studentMamagement.service.impl;

import com.design.studentMamagement.mapper.UserMapper;
import com.design.studentMamagement.pojo.Dormitory;
import com.design.studentMamagement.mapper.DormitoryMapper;
import com.design.studentMamagement.pojo.User;
import com.design.studentMamagement.service.DormitoryService;
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
 * (Dormitory)表服务实现类
 *
 * @author makejava
 * @since 2022-12-12 22:29:46
 */
@Service("dormitoryService")
public class DormitoryServiceImpl implements DormitoryService {
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
    public RestFulBean<Map> getList(Page<Dormitory> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Dormitory> list= dormitoryMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Dormitory dormitory: list){
                dormitory.setImagesUrl("http://localhost:8087/file/"+dormitory.getImages());
                List<User> lsit = userMapper.getByDormitoryNo(dormitory.getDormitoryNo(),dormitory.getBuildName()); //根据宿舍号获取这件宿舍住了多少人
                dormitory.setNum(lsit.size());
            }
        }
        //根据条件查询数据的条数
        Integer count = dormitoryMapper.getPageListCount(page);
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
    public RestFulBean<Dormitory> queryById(Integer id) {
       Dormitory dormitory=this.dormitoryMapper.queryById(id);
         return RestFulBean.succ(dormitory);
    }

    /**
     * 新增数据
     *
     * @param dormitory 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Dormitory dormitory) {
        if(dormitory.getDormitoryNo()==null){
            return RestFulBean.error("宿舍号不能为空");
        }
        if(dormitory.getBuildName()==null){
            return RestFulBean.error("宿舍楼不能为空");
        }
        if(dormitory.getType()==null){
            return RestFulBean.error("宿舍类型不能为空");
        }
        List<Dormitory>  dormitoryed =dormitoryMapper.getDormitoryByBuild(dormitory);
        if(dormitoryed.size()>0){
            return RestFulBean.error("该宿舍楼该宿舍号已经添加");
        }
        this.dormitoryMapper.insert(dormitory);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param dormitory 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Dormitory dormitory) {
        this.dormitoryMapper.update(dormitory);//执行数据库的修改语句 根据id 修改
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
        this.dormitoryMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Dormitory>> getDormitoryList(Dormitory dormitory) {
        List<Dormitory> list = this.dormitoryMapper.getDormitoryList(dormitory);
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<List<Dormitory>> getDormitory(Dormitory dormitory) {
        List<Dormitory> list =dormitoryMapper.getDormitoryByBuild(dormitory);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Dormitory dormitoryed: list){
                dormitoryed.setImagesUrl("http://localhost:8087/file/"+dormitoryed.getImages());
                List<User> lsit = userMapper.getByDormitoryNo(dormitoryed.getDormitoryNo(),dormitory.getBuildName()); //根据宿舍号获取这件宿舍住了多少人
                dormitoryed.setNum(lsit.size());
            }
        }
        return RestFulBean.succ(list);
    }
}
