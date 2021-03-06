package com.three.base.userservice.service.system.impl;


import com.three.base.userapi.SysRoleResourceService;
import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.result.Result;
import com.three.base.usercommon.vo.system.SysRoleResourceVo;
import com.three.base.userjdbc.mapper.SysResourceMapper;
import com.three.base.userjdbc.mapper.SysRoleResourceMapper;
import com.three.base.userjdbc.modal.SysRoleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @Date:2017/10/23 0023 16:18
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService {
    @Autowired
    SysRoleResourceMapper sysRoleResourceMapper;
    @Autowired
    SysResourceMapper sysResourceMapper;
    @Override
    public List<SysRoleResource> selectByUserNo(String userNo) {
        return sysRoleResourceMapper.selectByUserNo(userNo);
    }

    @Override
    public Result<Integer> create(SysRoleResourceVo sysRoleResourceVo) {
        SysRoleResource oldSysRoleResource=sysRoleResourceMapper.selectByRoleCodeAndSourceNo(sysRoleResourceVo.getRoleCode(),sysRoleResourceVo.getSourceNo());;
        if(oldSysRoleResource!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"角色已经拥有该资源权限!");
        }
        SysRoleResource sysRoleResource=new SysRoleResource();
        sysRoleResource.setRoleCode(sysRoleResourceVo.getRoleCode());
        sysRoleResource.setSourceNo(sysRoleResourceVo.getSourceNo());
        sysRoleResource.setCreateNo(sysRoleResourceVo.getOperNo());
        sysRoleResource.setCreateTime(new Date());
        sysRoleResource.setModiNo(sysRoleResourceVo.getOperNo());
        sysRoleResource.setModiTime(new Date());
        sysRoleResource.setVersion(0);
        return  Result.newSuccess(sysRoleResourceMapper.insertSelective(sysRoleResource));
    }

    @Override
    public Result<Integer> delete(String id) {
        return Result.newSuccess(sysRoleResourceMapper.deleteByPrimaryKey(id));
    }

    @Override
    public List<SysRoleResource> getEntityByRoleCode(String roleCode) {
        Condition condition = new Condition(SysRoleResource.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andCondition("role_code= '"+roleCode+"'");
        return sysRoleResourceMapper.selectByCondition(condition);
    }

    @Override
    public Result<Integer> deleteByIds(String ids) {
        return Result.newSuccess(sysRoleResourceMapper.deleteByIds(ids));
    }

    @Override
    public  Result<Integer> save(List<SysRoleResource> sysRoleResources) {
        String roleCode=sysRoleResources.get(0).getRoleCode();
        sysRoleResourceMapper.deleteByRoleCode(roleCode);
        return Result.newSuccess(sysRoleResourceMapper.insertList(sysRoleResources));
    }
}
