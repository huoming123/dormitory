package com.design.studentMamagement.service.impl;

import com.design.studentMamagement.pojo.Grade;
import com.design.studentMamagement.mapper.GradeMapper;
import com.design.studentMamagement.service.GradeService;
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
 * (Grade)表服务实现类
 *
 * @author makejava
 * @since 2022-12-14 20:28:06
 */
@Service("gradeService")
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Grade> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Grade> list= gradeMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Grade grade: list){
                //计算总分
                grade.setTotalScore(grade.getBed()+grade.getLayout()+grade.getToilet()+grade.getWall()+grade.getFloor());

                if(grade.getTotalScore()>95){ //大于95分系统自动评为优秀宿舍
                    grade.setExcellent("优秀宿舍");
                }
            }
        }
        //根据条件查询数据的条数
        Integer count = gradeMapper.getPageListCount(page);
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
    public RestFulBean<Grade> queryById(Integer id) {
       Grade grade=this.gradeMapper.queryById(id);
         return RestFulBean.succ(grade);
    }

    /**
     * 新增数据
     *
     * @param grade 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Grade grade) {
        if(grade.getBuildName()==null){
            return RestFulBean.error("宿舍楼不能为空");
        }
        if(grade.getDormitoryNo()==null){
            return RestFulBean.error("宿舍号不能为空");
        }
        if(grade.getBed()==null){
            return RestFulBean.error("床铺评分不能为空");
        }
        if(grade.getFloor()==null){
            return RestFulBean.error("地面评分不能为空");
        }
        if(grade.getWall()==null){
            return RestFulBean.error("墙壁评分不能为空");
        }
        if(grade.getToilet()==null){
            return RestFulBean.error("厕所评分不能为空");
        }
        if(grade.getLayout()==null){
            return RestFulBean.error("物品摆放不能为空");
        }
        this.gradeMapper.insert(grade);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param grade 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Grade grade) {
        this.gradeMapper.update(grade);//执行数据库的修改语句 根据id 修改
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
        this.gradeMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
