package com.citi.portfoliomanager.dao.mapper;

import com.citi.portfoliomanager.entity.TResource;

import java.util.List;


/**
 * Created by hkz on 2017/4/23.
 */
public interface ResourceMapper {
    List<TResource> getResourceList(long role_id);

    List<TResource> getAllResources();
}
