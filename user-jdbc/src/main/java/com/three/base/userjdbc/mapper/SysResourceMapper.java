package com.three.base.userjdbc.mapper;


import com.three.base.userjdbc.modal.SysResource;

import java.util.List;

public interface SysResourceMapper extends MyMapper<SysResource> {

    SysResource selectByResourceNo(String sourceNo);

    int updateByResourceNo(SysResource sysResource);

    List<SysResource> selectListByUserNo(String userNo);
}