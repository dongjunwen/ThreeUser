package com.three.base.userapi;


import com.three.base.usercommon.result.Result;
import com.three.base.usercommon.vo.system.SysUserRoleResultVo;
import com.three.base.usercommon.vo.system.SysUserRoleVo;
import com.three.base.userjdbc.modal.SysUserRole;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @Date:2017/10/23 0023 16:12
 * @Author lu.dong
 * @Description：
 **/
public interface SysUserRoleService  {
    List<SysUserRole> selectByUserNo(String userNo);

    List<SysUserRoleResultVo> getEntityByUserNo(String userNo);

    Result<Integer> deleteByIds(String ids);

    Result<Integer> delete(String id);

    Result<Integer> create(SysUserRoleVo sysUserRoleVo);

    Integer deleteByUserNo(String userNo);

    void insert(List<SysUserRole> sysUserRoleList);
}
