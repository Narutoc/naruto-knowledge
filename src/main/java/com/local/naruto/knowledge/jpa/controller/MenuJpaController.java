package com.local.naruto.knowledge.jpa.controller;

import com.local.naruto.common.JsonResult;
import com.local.naruto.knowledge.jpa.entity.MenuInfo;
import com.local.naruto.knowledge.jpa.service.MenuJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单控制层
 *
 * @Author Naruto Chen
 * @Date 2022/05/04
 */
@RestController
@RequestMapping(value = "/rest/menu/jpa")
public class MenuJpaController {

    @Autowired
    private MenuJpaService menuJpaService;

    /**
     * 查询单个菜单
     *
     * @param id 菜单id
     * @return MenuModel
     */
    @GetMapping(value = "/single/{id}")
    public JsonResult<MenuInfo> getSingleMenu(@PathVariable String id) {
        return new JsonResult<>(menuJpaService.getSingleMenu(id));
    }
}
