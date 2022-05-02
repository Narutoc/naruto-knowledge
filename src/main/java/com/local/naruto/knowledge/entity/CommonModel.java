package com.local.naruto.knowledge.entity;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * 公共属性
 *
 * @Author Naruto Chen
 * @Date 2022/02/11
 */
@Getter
@Setter
public class CommonModel {

    private String status;
    @NotNull
    private String createdUser;
    @NotNull
    private String createdDate;
    private String lastModifiedUser;
    private String lastModifiedDate;
}
