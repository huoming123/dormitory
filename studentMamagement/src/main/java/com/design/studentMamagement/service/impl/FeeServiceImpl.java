package com.design.studentMamagement.service.impl;

import com.design.studentMamagement.pojo.Fee;
import com.design.studentMamagement.mapper.FeeMapper;
import com.design.studentMamagement.service.FeeService;
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
 * (Fee)表服务实现类
 *
 * @author makejava
 * @since 2022-12-12 22:30:32
 */
@Service("feeService")
public class FeeServiceImpl implements FeeService {
    @Autowired
    private FeeMapper feeMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Fee> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Fee> list= feeMapper.getPageListByCondition(page);
        for(Fee fee :list){
            if(fee.getStatus()==1){ //支付状态为1 说明是已支付 的 那么 缴费按钮为不可编辑
                fee.setDisabled(true);
            }
            else{//支付状态为0 说明是未支付 的 那么 缴费按钮为可编辑
                fee.setDisabled(false);
            }
        }
        //根据条件查询数据的条数
        Integer count = feeMapper.getPageListCount(page);
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
    public RestFulBean<Fee> queryById(Integer id) {
       Fee fee=this.feeMapper.queryById(id);
         return RestFulBean.succ(fee);
    }

    /**
     * 新增数据
     *
     * @param fee 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Fee fee) {
        this.feeMapper.insert(fee);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param fee 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Fee fee) {
        this.feeMapper.update(fee);//执行数据库的修改语句 根据id 修改
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
        this.feeMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
