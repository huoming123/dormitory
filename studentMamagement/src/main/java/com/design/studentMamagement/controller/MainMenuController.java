package com.design.studentMamagement.controller;

import com.design.studentMamagement.pojo.MainMenu;
import com.design.studentMamagement.pojo.Submenu;
import com.design.studentMamagement.pojo.User;
import com.design.studentMamagement.service.MainMenuService;
import org.springframework.web.bind.annotation.*;
import com.design.studentMamagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (MainMenu)表控制层
 *
 * @author makejava
 * @since 2022-07-02 09:06:30
 */
@RestController
@RequestMapping("/mainMenu")
public class MainMenuController {
    /**
     * 服务对象
     */
    @Autowired
    private MainMenuService mainMenuService;

    /**
     * 获取菜单
     *
     * @param  user 用户id 查出 该用户是什么角色 进而显示不同的菜单
     * @return Map<Object, Object>
     */
    @PostMapping("/menu")
    public RestFulBean<List<MainMenu>> getMenuTree(@RequestBody User user) throws Exception {
        return mainMenuService.getMenuTree(user);
    }

    /**
     * 新增一个子菜单
     * @param  submenu
     * @return
     * @throws
     */
    @PostMapping("/add/menu")
    public RestFulBean<String> addMenu(@RequestBody Submenu submenu)throws Exception{
        return mainMenuService.addMenu(submenu);
    }
    /**
     * 新增一个主菜单
     * @param  mainMenu
     * @return
     * @throws
     */
    @PostMapping("/add/mainMenu")
    public RestFulBean<String> addMainMenu(@RequestBody MainMenu mainMenu)throws Exception{
        return mainMenuService.addMainMenu(mainMenu);
    }
    /**
     * 修改主菜单
     * @param  mainMenu
     * @return
     * @throws
     */
    @PostMapping("/update/mainMenu")
    public RestFulBean<String> updateMainMenu(@RequestBody MainMenu mainMenu)throws Exception{
        return mainMenuService.updateMainMenu(mainMenu);
    }
    /**
     * 修改子菜单
     * @param  submenu
     * @return
     * @throws
     */
    @PostMapping("/update/menu")
    public RestFulBean<String> updateMenu(@RequestBody Submenu submenu)throws Exception{
        return mainMenuService.updateMenu(submenu);
    }
    /**
     * 删除子菜单
     * @param  submenu
     * @return
     * @throws
     */
    @PostMapping("/del/menu")
    public RestFulBean<String> delMenu(@RequestBody Submenu submenu)throws Exception{
        return mainMenuService.delMenu(submenu);
    }
    /**
     * 删除主菜单
     * @param  mainMenu
     * @return
     * @throws
     */
    @PostMapping("/del/mainMenu")
    public RestFulBean<String> delMainMenu(@RequestBody MainMenu mainMenu)throws Exception{
        return mainMenuService.delMainMenu(mainMenu);
    }
}

