package com.three.base.userjdbc.mapper;


import com.three.base.userjdbc.modal.SysUser;
import com.three.base.userjdbc.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper  extends MyMapper<SysUser> {
    SysUser selectByUserNo(String userNo);

    int deleteByUserNo(String userNo);

    int updateByUserNo(SysUser sysUser);
}