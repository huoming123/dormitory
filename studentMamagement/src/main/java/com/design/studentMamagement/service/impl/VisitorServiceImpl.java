package com.design.studentMamagement.service.impl;

import com.design.studentMamagement.pojo.Visitor;
import com.design.studentMamagement.mapper.VisitorMapper;
import com.design.studentMamagement.service.VisitorService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.studentMamagement.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.design.studentMamagement.util.PageUtil;
import com.design.studentMamagement.dto.Page;
/**
 * (Visitor)表服务实现类
 *
 * @author makejava
 * @since 2022-12-12 22:31:58
 */
@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorMapper visitorMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Visitor> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Visitor> list= visitorMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = visitorMapper.getPageListCount(page);
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
    public RestFulBean<Visitor> queryById(Integer id) {
       Visitor visitor=this.visitorMapper.queryById(id);
         return RestFulBean.succ(visitor);
    }

    /**
     * 新增数据
     *
     * @param visitor 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Visitor visitor) {
        if(visitor.getUserName()==null){
            return RestFulBean.error("来访人不能为空");
        }
        if(visitor.getBuildName()==null){
            return RestFulBean.error("宿舍楼不能为空");
        }
        if(visitor.getReason()==null){
            return RestFulBean.error("事由不能为空");
        }
        if(visitor.getTelephone()==null){
            return RestFulBean.error("手机号码不能为空");
        }
        if(visitor.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(visitor.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
//        if(visitor.getCreatedAt()==null){
//            return RestFulBean.error("来访日期不能为空");
//        }
        this.visitorMapper.insert(visitor);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param visitor 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Visitor visitor) {
        this.visitorMapper.update(visitor);//执行数据库的修改语句 根据id 修改
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
        this.visitorMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
