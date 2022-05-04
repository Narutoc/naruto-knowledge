package com.local.naruto.knowledge.common;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.local.naruto.knowledge.mybatis.common.CommonUtils;
import com.local.naruto.knowledge.mybatis.entity.ConditionModel;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CommonUtilsTest {

    @Test
    void shouldGetConditionMap() {
        ConditionModel param = new ConditionModel();
        param.setUserName("naruto");
        param.setRealName("ChenXiaoQiang");
        param.setCurrentPage(10);
        param.setPageSize(1);
        Map<String, Object> condition = CommonUtils.getConditionMap(param);
        assertThat(condition).isNotNull();
        assertThat(condition.get("userName")).isEqualTo("naruto");
    }
}