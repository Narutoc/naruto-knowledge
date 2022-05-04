package com.local.naruto.knowledge.jpa.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 批量操作
 *
 * @Author Naruto Chen
 * @Date 2022/05/04
 */
@Transactional
@Service
public class BatchService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 批量插入
     *
     * @param list 实体类集合
     * @param <T>  表对应的实体类
     */
    public <T> void batchInsert(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            entityManager.persist(list.get(i));
            if (i % 50 == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }

    /**
     * 批量更新
     *
     * @param list 实体类集合
     * @param <T>  表对应的实体类
     */
    public <T> void batchUpdate(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            entityManager.merge(list.get(i));
            if (i % 50 == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }
}
