package com.citi.portfoliomanager.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by hkz on 2017/4/23.
 * 角色，用于权限管理
 */
public class TRole implements Serializable {
    private Long id;
    private String name; //角色名
    Set<TResource> resources; //角色拥有的资源权限
    private Long code;//唯一

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TResource> getResources() {
        return resources;
    }

    public void setResources(Set<TResource> resources) {
        this.resources = resources;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}
