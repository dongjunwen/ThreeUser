package com.three.base.userjdbc.mapper;

import com.three.base.userjdbc.modal.SysRoleResource;
import com.three.base.userjdbc.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleResourceMapper extends MyMapper<SysRoleResource> {


    List<SysRoleResource> selectByUserNo(String userNo);

    SysRoleResource selectByRoleCodeAndSourceNo(@Param("roleCode") String roleCode, @Param("sourceNo") String sourceNo);
}