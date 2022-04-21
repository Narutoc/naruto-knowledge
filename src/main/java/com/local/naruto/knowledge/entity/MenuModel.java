package com.local.naruto.knowledge.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 菜单实体
 *
 * @Author Naruto Chen
 * @Date 2022/02/11
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuModel extends CommonModel {
    @NotNull
    private String menuId;
    private String parentId;
    private String language;
    private String zhName;
    private String zhDescription;
    private String enName;
    private String enDescription;
    private String status;
    private String sortNum;
    private List<MenuModel> child;
}
