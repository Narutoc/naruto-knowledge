package com.local.naruto.knowledge.jpa.service.impl;

import com.local.naruto.exception.ServiceException;
import com.local.naruto.knowledge.jpa.entity.MenuInfo;
import com.local.naruto.knowledge.jpa.repository.MenuRepository;
import com.local.naruto.knowledge.jpa.service.MenuJpaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuJpaServiceImpl implements MenuJpaService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public void addMenuInfo(MenuInfo model) throws ServiceException {

    }

    @Override
    public List<MenuInfo> getAllMenu() throws ServiceException {
        return null;
    }

    @Override
    public MenuInfo getSingleMenu(String menuId) throws ServiceException {
        return menuRepository.getById("ee25d68cf526430093d8bda415f115b3");
    }

    @Override
    public void updateMenuInfo(MenuInfo model) throws ServiceException {

    }
}
