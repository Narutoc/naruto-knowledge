package com.local.naruto.knowledge.jpa.service.impl;

import com.local.naruto.exception.ServiceException;
import com.local.naruto.knowledge.jpa.entity.MenuInfo;
import com.local.naruto.knowledge.jpa.repository.MenuRepository;
import com.local.naruto.knowledge.jpa.service.MenuJpaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * implement for MenuJpaService
 */
@Service
public class MenuJpaServiceImpl implements MenuJpaService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public void addMenuInfo(MenuInfo model) throws ServiceException {

    }

    @Override
    public List<MenuInfo> getAllMenu() throws ServiceException {
        Sort sort = Sort.by(Direction.ASC, "sortNum");
        List<MenuInfo> menuList = menuRepository.findAll(sort);
        // 移除结果集中parentId不为空的
        menuList.removeIf(menu -> StringUtils.isNotEmpty(menu.getParentId()));
        return menuList;
    }

    @Override
    public MenuInfo getSingleMenu(String menuId) throws ServiceException {
        return menuRepository.getById(menuId);
    }

    @Override
    public void updateMenuInfo(MenuInfo model) throws ServiceException {

    }
}
