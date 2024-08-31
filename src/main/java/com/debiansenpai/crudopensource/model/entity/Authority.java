package com.debiansenpai.crudopensource.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_authority")
    private int authorityPk;

    private String authority;

    public int getAuthorityPk() {
        return authorityPk;
    }

    public void setAuthorityPk(int authorityPk) {
        this.authorityPk = authorityPk;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
