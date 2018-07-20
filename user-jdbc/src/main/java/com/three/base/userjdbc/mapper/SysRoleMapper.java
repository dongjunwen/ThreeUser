package com.three.base.userjdbc.mapper;


import com.three.base.usercommon.vo.system.SysRoleCondVo;
import com.three.base.userjdbc.dto.SysRoleCondDto;
import com.three.base.userjdbc.modal.SysRole;
import com.three.base.userjdbc.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysRoleMapper extends MyMapper<SysRole> {

    SysRole selectByRoleCode(String roleCode);

    List<SysRole> findRoleLike(String condStr);

    List<SysRole> findList(SysRoleCondVo sysRoleCondVo);

}