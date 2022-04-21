package com.local.naruto.knowledge.common;

import com.local.naruto.knowledge.entity.ConditionModel;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CommonUtils {
    public static Map<String,Object> getConditionMap(ConditionModel param){
        Map<String, Object> map = new HashMap<>();
        map.put("userName", param.getUserName().toLowerCase(Locale.ROOT));
        map.put("realName", param.getRealName().toLowerCase(Locale.ROOT));
        int pageNum = Math.max(param.getCurrentPage(), 0);
        int size = Math.max(param.getPageSize(), 0);
        map.put("index", (pageNum - 1) * pageNum);
        map.put("size", size);
        return map;
    }
}
