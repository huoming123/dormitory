package com.design.studentMamagement.service.impl;

import com.design.studentMamagement.dto.Page;
import com.design.studentMamagement.pojo.Fee;
import com.design.studentMamagement.pojo.OutLate;
import com.design.studentMamagement.mapper.OutLateMapper;
import com.design.studentMamagement.service.OutLateService;
import com.design.studentMamagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.design.studentMamagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (OutLate)表服务实现类
 *
 * @author makejava
 * @since 2022-12-14 12:04:48
 */
@Service("outLateService")
public class OutLateServiceImpl implements OutLateService {
    @Autowired
    private OutLateMapper outLateMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<OutLate> queryById(Integer id) {
       OutLate outLate=this.outLateMapper.queryById(id);
         return RestFulBean.succ(outLate);
    }

    /**
     * 新增数据
     *
     * @param outLate 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(OutLate outLate) {
        if(outLate.getUserName()==null){
            return RestFulBean.error("姓名不能为空");
        }
        if(outLate.getUserNo()==null){
            return RestFulBean.error("学号不能为空");
        }
        if(outLate.getBuildName()==null){
            return RestFulBean.error("宿舍楼不能为空");
        }
        if(outLate.getDormitoryNo()==null){
            return RestFulBean.error("宿舍号不能为空");
        }
        if(outLate.getTelephone()==null){
            return RestFulBean.error("手机号不能为空");
        }
        if(outLate.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(outLate.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        this.outLateMapper.insert(outLate);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param outLate 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(OutLate outLate) {
        this.outLateMapper.update(outLate);
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
        this.outLateMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> getList(Page<OutLate> page) throws Exception {
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<OutLate> list= outLateMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = outLateMapper.getPageListCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        return RestFulBean.succ(map);
    }
}
