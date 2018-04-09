package com.three.base.userapi;



import com.github.pagehelper.Page;
import com.three.base.usercommon.PO.system.SysRoleVo;
import com.three.base.usercommon.result.Result;
import com.three.base.userjdbc.modal.SysRole;

import java.util.List;
import java.util.Map;

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

    Page<SysRole> findList(Map<String, String> params);

    List<SysRole> findRoleLike(String condStr);
}
