package com.design.studentMamagement.service.impl;

import com.design.studentMamagement.pojo.Message;
import com.design.studentMamagement.mapper.MessageMapper;
import com.design.studentMamagement.service.MessageService;
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
 * (Message)表服务实现类
 *
 * @author makejava
 * @since 2022-12-14 20:28:23
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Message> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Message> list= messageMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Message message: list){
                if(message.getDorMessage()!=null){ //判断宿管是否回复了 如果回复 那么该留言就不可编辑
                    message.setDisabled(true);
                }
                else{
                    message.setDisabled(false); //否则留言可以编辑
                }
                if(message.getAdmMessage()!=null){ //判断管理员是否回复了 如果回复 那么该留言就不可编辑
                    message.setAdminDisabled(true);
                }
                else{
                    message.setAdminDisabled(false); //否则留言可以编辑
                }
            }
        }
        //根据条件查询数据的条数
        Integer count = messageMapper.getPageListCount(page);
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
    public RestFulBean<Message> queryById(Integer id) {
       Message message=this.messageMapper.queryById(id);
         return RestFulBean.succ(message);
    }

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Message message) {
        this.messageMapper.insert(message);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Message message) {
        this.messageMapper.update(message);//执行数据库的修改语句 根据id 修改
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
        this.messageMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
