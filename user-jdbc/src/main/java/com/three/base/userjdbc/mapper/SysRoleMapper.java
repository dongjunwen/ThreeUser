package com.three.base.userjdbc.mapper;


import com.three.base.userjdbc.modal.SysRole;

import java.util.List;

public interface SysRoleMapper extends MyMapper<SysRole> {

    SysRole selectByRoleCode(String roleCode);

    List<SysRole> findRoleLike(String condStr);
}