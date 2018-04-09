package com.three.base.userjdbc.mapper;

import com.three.base.userjdbc.modal.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleMapper extends MyMapper<SysUserRole>{

    List<SysUserRole> selectByUserNo(String userNo);

    SysUserRole selectByUserNoAndRoleCode(@Param("userNo") String userNo, @Param("roleCode") String roleCode);
}