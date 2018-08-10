package com.citi.portfoliomanager.dao;

import com.citi.portfoliomanager.dao.mapper.ResourceMapper;
import com.citi.portfoliomanager.entity.TResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hkz on 2017/4/23.
 */
@Repository
public class ResourceDao {
    @Autowired
    private ResourceMapper resourceMapper;

    public List<TResource> getResourceList(long roleId){
        return resourceMapper.getResourceList(roleId);
    }
    public List<TResource> getAllResources() {
        return resourceMapper.getAllResources();
    }

//    public List<TResource> getResourcesPage(long roleId, int pageIndex, int pageSize) {
//        PageHelper.startPage(pageIndex,pageSize);
//        return resourceMapper.getResourceList(roleId);
//    }
}

