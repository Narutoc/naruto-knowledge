package com.local.naruto.knowledge.mybatis.mapper.menu;

import com.local.naruto.knowledge.mybatis.entity.MenuModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 菜单信息dao层
 *
 * @Author Naruto Chen
 * @Date 2022/02/11
 */
@Mapper
public interface MenuMapper {

    /**
     * 新增菜单信息
     *
     * @param model 菜单实体
     */
    void addMenuInfo(MenuModel model);

    /**
     * 批量新增菜单信息
     *
     * @param list 菜单列表
     */
    void batchInsertMenu(List<MenuModel> list);

    /**
     * 根据菜单id查询信息
     *
     * @param menuId 菜单id
     * @return MenuModel
     */
    MenuModel getSingleMenu(@Param("menuId") String menuId);

    /**
     * 查询所有菜单
     *
     * @return List<MenuModel>
     */
    List<MenuModel> getAllMenu();

    /**
     * 编辑菜单信息
     *
     * @param model 菜单实体
     */
    void updateMenuInfo(MenuModel model);
}
