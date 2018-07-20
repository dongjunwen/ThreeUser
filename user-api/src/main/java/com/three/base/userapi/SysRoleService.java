package com.three.base.userapi;


import com.github.pagehelper.Page;
import com.three.base.usercommon.result.Result;
import com.three.base.usercommon.vo.system.SysRoleCondVo;
import com.three.base.usercommon.vo.system.SysRoleVo;
import com.three.base.userjdbc.dto.SysRoleCondDto;
import com.three.base.userjdbc.modal.SysRole;

import java.util.List;

/**
 * @Date:2017/10/23 0023 16:07
 * @Author lu.dong
 * @Description：
 **/
public interface SysRoleService {
    Result<Integer> create(SysRoleVo sysRoleVo);

    Result<Integer> update(SysRoleVo sysRoleVo);

    Result<Integer> delete(String roleCode);

    SysRole getEntityByNo(String roleCode);

    Page<SysRole> findList(SysRoleCondVo sysRoleCondVo);

    List<SysRole> findRoleLike(String condStr);

    List<SysRole> listAll();

}
