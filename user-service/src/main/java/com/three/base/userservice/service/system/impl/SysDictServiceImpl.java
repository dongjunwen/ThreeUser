package com.three.base.userservice.service.system.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.three.base.userapi.SysDictService;
import com.three.base.usercommon.PO.system.SysDictCondVo;
import com.three.base.usercommon.PO.system.SysDictVo;
import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.result.Result;
import com.three.base.userjdbc.util.Common;
import com.three.base.userjdbc.mapper.SysDictMapper;
import com.three.base.userjdbc.modal.SysDict;
import com.three.base.userservice.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/24 0024 13:49
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysDictServiceImpl extends AbstractService<SysDict> implements SysDictService {
    private static  final Logger logger= LoggerFactory.getLogger(SysDictServiceImpl.class);
    @Autowired
    SysDictMapper sysDictMapper;

    @Override
    public Result<Integer> create(SysDictVo sysDictVo) {
        SysDict _sysDict=sysDictMapper.selectByUniqNo(sysDictVo.getDictType(),sysDictVo.getDictCode());
        if(_sysDict!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"数据字典已存在!");
        }
        SysDict sysDict=new SysDict();
        convertVoToEntity(sysDict,sysDictVo);
        return Result.newSuccess(sysDictMapper.insertSelective(sysDict));
    }

    @Override
    public Result<Integer> update(SysDictVo sysDictVo) {
        SysDict _sysDict=sysDictMapper.selectByUniqNo(sysDictVo.getDictType(),sysDictVo.getDictCode());
        if(_sysDict==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"数据字典不存在!");
        }
        SysDict sysDict=new SysDict();
        convertVoToEntity(sysDict,sysDictVo);
        sysDict.setId(_sysDict.getId());
        return Result.newSuccess(sysDictMapper.updateByPrimaryKeySelective(sysDict));
    }

    @Override
    public Result<Integer> delete(String dictType,String dictCode) {
        SysDict _sysDict=sysDictMapper.selectByUniqNo(dictType,dictCode);
        if(_sysDict==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"数据字典不存在!");
        }
        String ids=_sysDict.getId().toString();
        return Result.newSuccess(sysDictMapper.deleteByIds(ids));
    }

    @Override
    public SysDict getEntityByNo(String dictType,String dictCode) {
        return sysDictMapper.selectByUniqNo(dictType,dictCode);
    }

    @Override
    public Page<SysDict> findList(SysDictCondVo sysDictCondVo) {
        PageHelper.startPage(sysDictCondVo.getPageNum(), sysDictCondVo.getPageSize());
        List<SysDict> sysDicts = sysDictMapper.findList(sysDictCondVo);
        return (Page<SysDict>) sysDicts;
    }

    public List<SysDict> findAll(){
        return sysDictMapper.findAll();
    }

    @Override
    public List<SysDict> getEntityByDictType(String dictType) {
        return sysDictMapper.selectByDictType(dictType);
    }

    private void convertVoToEntity(SysDict sysDict, SysDictVo sysDictVo) {
        BeanUtils.copyProperties(sysDict,sysDictVo);
    }
}
