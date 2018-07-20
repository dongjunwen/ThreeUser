package com.three.base.userjdbc.mapper;


import com.three.base.usercommon.vo.system.SysResourceCondVo;
import com.three.base.userjdbc.modal.SysResource;
import com.three.base.userjdbc.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysResourceMapper extends MyMapper<SysResource> {

    SysResource selectByResourceNo(String sourceNo);

    int updateByResourceNo(SysResource sysResource);

    List<SysResource> selectListByUserNo(String userNo);

    List<SysResource> selectByList(SysResourceCondVo sysResourceCondVo);
}