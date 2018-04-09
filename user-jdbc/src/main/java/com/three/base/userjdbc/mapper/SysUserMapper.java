package com.three.base.userjdbc.mapper;


import com.three.base.userjdbc.modal.SysUser;

public interface SysUserMapper  {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByUserNo(String userNo);

    int deleteByUserNo(String userNo);

    int updateByUserNo(SysUser sysUser);
}