package com.three.base.userapi;

import com.github.pagehelper.Page;
import com.three.base.usercommon.PO.system.SysDictCondVo;
import com.three.base.usercommon.PO.system.SysDictVo;
import com.three.base.usercommon.result.Result;
import com.three.base.userjdbc.modal.SysDict;

import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/24 0024 13:48
 * @Author lu.dong
 * @Description：
 **/
public interface SysDictService {
    Result<Integer> create(SysDictVo sysDictVo);

    Result<Integer> update(SysDictVo sysDictVo);

    Result<Integer> delete(String dictType, String dictCode);

    SysDict getEntityByNo(String dictType, String dictCode);

    Page<SysDict> findList(SysDictCondVo sysDictCondVo);

    List<SysDict> getEntityByDictType(String dictType);

    List<SysDict> findAll();
}
