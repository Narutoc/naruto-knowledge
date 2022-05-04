package com.local.naruto.knowledge.jpa.repository;

import com.local.naruto.knowledge.jpa.entity.ContentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContentRepository extends JpaRepository<ContentInfo, String>,
    JpaSpecificationExecutor<ContentInfo> {

}
