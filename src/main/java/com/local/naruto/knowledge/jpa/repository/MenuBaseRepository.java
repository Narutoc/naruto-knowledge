package com.local.naruto.knowledge.jpa.repository;

import com.local.naruto.knowledge.jpa.entity.MenuInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * MenuBaseRepository
 */
@NoRepositoryBean
public interface MenuBaseRepository extends JpaRepository<MenuInfo, String>,
    JpaSpecificationExecutor<MenuInfo> {

}
