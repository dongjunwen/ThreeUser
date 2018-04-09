package com.three.base.userjdbc.mapper;

import com.three.base.userjdbc.modal.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictMapper extends MyMapper<SysDict> {

    SysDict selectByUniqNo(@Param("dictType") String dictType, @Param("dictCode") String dictCode);

    List<SysDict> selectByDictType(String dictType);

    List<SysDict> findAll();
}