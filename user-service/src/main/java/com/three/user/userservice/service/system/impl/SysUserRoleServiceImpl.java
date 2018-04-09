package com.three.user.userservice.service.system.impl;


import com.three.base.userapi.SysUserRoleService;
import com.three.base.usercommon.PO.result.SysUserRoleResultVo;
import com.three.base.usercommon.PO.system.SysUserRoleVo;
import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.result.Result;
import com.three.base.userjdbc.mapper.SysRoleMapper;
import com.three.base.userjdbc.mapper.SysUserRoleMapper;
import com.three.base.userjdbc.modal.SysRole;
import com.three.base.userjdbc.modal.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date:2017/10/23 0023 16:13
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public List<SysUserRole> selectByUserNo(String userNo) {
        return sysUserRoleMapper.selectByUserNo(userNo);
    }

    @Override
    public Result<Integer> create(SysUserRoleVo sysUserRoleVo) {
        SysUserRole _sysUserRole=sysUserRoleMapper.selectByUserNoAndRoleCode(sysUserRoleVo.getUserNo(),sysUserRoleVo.getRoleCode());
        if(_sysUserRole!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"用户已经拥有了该角色!");
        }
        SysUserRole sysUserRole=new SysUserRole();
        sysUserRole.setUserNo(sysUserRoleVo.getUserNo());
        sysUserRole.setRoleCode(sysUserRoleVo.getRoleCode());
        sysUserRole.setCreateNo(sysUserRoleVo.getOperNo());
        sysUserRole.setCreateTime(new Date());
        sysUserRole.setModiNo(sysUserRoleVo.getOperNo());
        sysUserRole.setModiTime(new Date());
        sysUserRole.setVersion(0);
        return  Result.newSuccess(sysUserRoleMapper.insertSelective(sysUserRole));
    }

    @Override
    public List<SysUserRoleResultVo> getEntityByUserNo(String userNo) {
        List<SysUserRole> sysUserRoles=selectByUserNo(userNo);
        List<SysUserRoleResultVo> sysUserRoleResultVos=new ArrayList<>();
        for(SysUserRole sysUserRole:sysUserRoles){
            SysUserRoleResultVo sysUserRoleResultVo=new SysUserRoleResultVo();
            sysUserRoleResultVo.setId(sysUserRole.getId());
            sysUserRoleResultVo.setUserNo(sysUserRole.getUserNo());
            sysUserRoleResultVo.setRoleCode(sysUserRole.getRoleCode());
            SysRole sysRole=sysRoleMapper.selectByRoleCode(sysUserRole.getRoleCode());
            sysUserRoleResultVo.setRoleName(sysRole.getRoleName());
            sysUserRoleResultVos.add(sysUserRoleResultVo);
        }
        return sysUserRoleResultVos;
    }

    @Override
    public Result<Integer> deleteByIds(String ids) {
        return Result.newSuccess(sysUserRoleMapper.deleteByIds(ids));
    }

    @Override
    public Result<Integer> delete(String id) {
        return Result.newSuccess(sysUserRoleMapper.deleteByPrimaryKey(id));
    }


}
