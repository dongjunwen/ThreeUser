package com.three.base.userjdbc.mapper;

import com.three.base.userjdbc.modal.SysUserRole;
import com.three.base.userjdbc.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysUserRoleMapper extends MyMapper<SysUserRole> {

    List<SysUserRole> selectByUserNo(String userNo);

    SysUserRole selectByUserNoAndRoleCode(@Param("userNo") String userNo, @Param("roleCode") String roleCode);

    Integer deleteByUserNo(String userNo);

    void insertBatch(List<SysUserRole> sysUserRoleList);
}