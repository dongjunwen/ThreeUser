package com.three.base.userapi;


import com.three.base.usercommon.result.Result;
import com.three.base.usercommon.vo.system.SysRoleResourceVo;
import com.three.base.userjdbc.modal.SysRoleResource;

import java.util.List;

/**
 * @Date:2017/10/23 0023 16:07
 * @Author lu.dong
 * @Description：
 **/
public interface SysRoleResourceService {

    List<SysRoleResource> selectByUserNo(String userNo);

    Result<Integer> create(SysRoleResourceVo sysRoleResourceVo);

    Result<Integer> delete(String id);

    List<SysRoleResource> getEntityByRoleCode(String roleCode);

    Result<Integer> deleteByIds(String ids);

    Result<Integer> save(List<SysRoleResource> sysRoleResources);
}
