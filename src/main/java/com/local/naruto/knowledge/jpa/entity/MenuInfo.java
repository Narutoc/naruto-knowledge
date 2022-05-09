package com.local.naruto.knowledge.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Getter
@Setter
@Entity
@Table(name = "tbl_menu_info")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class MenuInfo extends CommonInfo {

    @Id
    @Column(name = "menuid", length = 32, nullable = false)
    private String menuId;

    @Column(name = "sortnum")
    private int sortNum;

    @Column(name = "parentid")
    private String parentId;

    // 父菜单
    @ManyToOne
    @JoinColumn(name = "parentid", insertable = false, updatable = false)
    @JsonIgnore
    @NotFound(action = NotFoundAction.IGNORE)
    private MenuInfo parent;

    // 子菜单
    @OneToMany(mappedBy = "parent")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<MenuInfo> child;


    @OneToMany(mappedBy = "menu")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<ContentInfo> contentList;
}
