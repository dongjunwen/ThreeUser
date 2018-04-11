package com.three.base.userjdbc.mapper;


import com.three.base.usercommon.PO.system.SysRoleCondVo;
import com.three.base.userjdbc.modal.SysRole;
import com.three.base.userjdbc.util.MyMapper;

import java.util.List;

public interface SysRoleMapper extends MyMapper<SysRole> {

    SysRole selectByRoleCode(String roleCode);

    List<SysRole> findRoleLike(String condStr);

    List<SysRole> findList(SysRoleCondVo sysRoleCondVo);
}