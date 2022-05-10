package com.local.naruto.knowledge.jpa.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * common info
 */
@Getter
@Setter
@MappedSuperclass
public class CommonInfo {

    @Column(name = "status")
    private String status;

    @NotNull
    @Column(name = "createduser")
    private String createdUser;

    @NotNull
    @Column(name = "createddate")
    private String createdDate;

    @Column(name = "lastmodifieduser")
    private String lastModifiedUser;

    @Column(name = "lastmodifieddate")
    private String lastModifiedDate;
}
