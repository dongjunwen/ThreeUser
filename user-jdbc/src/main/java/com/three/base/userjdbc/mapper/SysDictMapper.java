package com.three.base.userjdbc.mapper;

import com.three.base.usercommon.vo.system.SysDictCondVo;
import com.three.base.userjdbc.modal.SysDict;
import com.three.base.userjdbc.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysDictMapper extends MyMapper<SysDict> {

    SysDict selectByUniqNo(@Param("dictType") String dictType, @Param("dictCode") String dictCode);

    List<SysDict> selectByDictType(String dictType);

    List<SysDict> findAll();

    List<SysDict> findList(SysDictCondVo sysDictCondVo);
}