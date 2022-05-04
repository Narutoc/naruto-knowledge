package com.local.naruto.knowledge.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_menu_info")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuInfo extends CommonInfo {

    @Id
    @Column(name = "menuid", length = 32, nullable = false)
    private String menuId;

    @Column(name = "sortnum")
    private int sortNum;

    // 父菜单
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "parentid")
    private MenuInfo parent;

    // 子菜单
    @OneToMany(mappedBy = "parent")
    @JsonIgnore
    private List<MenuInfo> child;


    @OneToMany(mappedBy = "menu")
    private List<ContentInfo> contentList;
}
