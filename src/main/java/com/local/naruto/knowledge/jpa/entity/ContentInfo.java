package com.local.naruto.knowledge.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Getter
@Setter
@Entity
@Table(name = "tbl_content_info")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentInfo extends CommonInfo {

    @Id
    @Column(name = "contentid", length = 32, nullable = false)
    private String contentId;

    @Column(name = "objectid")
    private String objectId;

    @Column(name = "lang")
    private int lang;

    @Column(name = "content1")
    private String content1;

    @Column(name = "content2")
    private String content2;

    @Column(name = "content3")
    private String content3;

    @Column(name = "content4")
    private String content4;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "objectid", referencedColumnName = "menuid", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private MenuInfo menu;
}
