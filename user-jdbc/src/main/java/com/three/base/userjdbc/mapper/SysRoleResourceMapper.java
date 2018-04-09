package com.three.base.userjdbc.mapper;

import com.three.base.userjdbc.modal.SysRoleResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysRoleResourceMapper extends MyMapper<SysRoleResource>{


    List<SysRoleResource> selectByUserNo(String userNo);

    SysRoleResource selectByRoleCodeAndSourceNo(@Param("roleCode") String roleCode, @Param("sourceNo") String sourceNo);
}