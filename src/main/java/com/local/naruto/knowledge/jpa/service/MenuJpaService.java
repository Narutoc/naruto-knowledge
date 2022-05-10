package com.local.naruto.knowledge.jpa.service;

import com.local.naruto.exception.ServiceException;
import com.local.naruto.knowledge.jpa.entity.MenuInfo;
import java.util.List;

/**
 * MenuJpaService
 */
public interface MenuJpaService {

    /**
     * 新增菜单信息
     *
     * @param model 菜单实体
     * @throws ServiceException 异常
     */
    void addMenuInfo(MenuInfo model) throws ServiceException;

    /**
     * 查询所有菜单
     *
     * @return List<MenuModel>
     * @throws ServiceException 异常
     */
    List<MenuInfo> getAllMenu() throws ServiceException;

    /**
     * 查询单个菜单
     *
     * @param menuId 菜单id
     * @return MenuModel
     * @throws ServiceException 异常
     */
    MenuInfo getSingleMenu(String menuId) throws ServiceException;

    /**
     * 编辑菜单信息
     *
     * @param model 菜单实体
     * @throws ServiceException 异常
     */
    void updateMenuInfo(MenuInfo model) throws ServiceException;
}
