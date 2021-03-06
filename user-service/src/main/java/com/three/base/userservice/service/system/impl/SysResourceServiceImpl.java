package com.three.base.userservice.service.system.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.three.base.userapi.SysResourceService;
import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.result.Result;
import com.three.base.usercommon.vo.system.SysResourceCondVo;
import com.three.base.usercommon.vo.system.SysResourceResultVo;
import com.three.base.usercommon.vo.system.SysResourceVo;
import com.three.base.userjdbc.mapper.SysResourceMapper;
import com.three.base.userjdbc.modal.SysResource;
import com.three.base.userservice.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date:2017/10/23 0023 14:29
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysResourceServiceImpl extends AbstractService<SysResource> implements SysResourceService {

    private static  final Logger logger= LoggerFactory.getLogger(SysResourceServiceImpl.class);

    @Autowired
    SysResourceMapper sysResourceMapper;


    @Override
    public Result<Integer> create(SysResourceVo sysResourceVo) {
        SysResource _sysResource=sysResourceMapper.selectByResourceNo(sysResourceVo.getSourceNo());
        if(_sysResource!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"资源代码已存在!");
        }
        SysResource sysResource=new SysResource();
        convertVoToEntity(sysResource,sysResourceVo);
        sysResource.setFhSourceNo(sysResourceVo.getPsourceNo());
        sysResource.setCreateNo(sysResourceVo.getOperNo());
        sysResource.setCreateTime(new Date());
        sysResource.setModiNo(sysResourceVo.getOperNo());
        sysResource.setModiTime(new Date());
        return Result.newSuccess(sysResourceMapper.insertSelective(sysResource));
    }

    @Override
    public Result<Integer> update(SysResourceVo sysResourceVo) {
        SysResource _sysResource=sysResourceMapper.selectByResourceNo(sysResourceVo.getSourceNo());
        if(_sysResource==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"菜单资源信息不存在!");
        }
        SysResource sysResource=new SysResource();
        convertVoToEntity(sysResource,sysResourceVo);
        sysResource.setModiNo(sysResourceVo.getOperNo());
        sysResource.setModiTime(new Date());
        return Result.newSuccess(sysResourceMapper.updateByResourceNo(sysResource));
    }

    @Override
    public Result<Integer> delete(String sourceNo) {
        SysResource _sysResource=sysResourceMapper.selectByResourceNo(sourceNo);
        if(_sysResource==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"资源信息不存在!");
        }
        return Result.newSuccess(sysResourceMapper.deleteByPrimaryKey(_sysResource.getId()));
    }

    @Override
    public SysResource getEntityByNo(String sourceNo) {
        return sysResourceMapper.selectByResourceNo(sourceNo);
    }

    @Override
    public Page<SysResource> findList(SysResourceCondVo sysResourceCondVo) {
            PageHelper.startPage(sysResourceCondVo.getPageNum(), sysResourceCondVo.getPageSize());
        List<SysResource> sysResources = sysResourceMapper.selectByList(sysResourceCondVo);
        return (Page<SysResource>) sysResources;
    }

    @Override
    public List<SysResourceResultVo> getListByCurrentUser(String userNo) {
        List<SysResource> sysResources =sysResourceMapper.selectListByUserNo(userNo);
        List<SysResourceResultVo> sysResourceResultVos=new ArrayList<>();
        for(SysResource sysResource:sysResources){
            SysResourceResultVo sysResourceResultVo=new SysResourceResultVo();
            sysResourceResultVo.setId(String.valueOf(sysResource.getSourceNo()));
            sysResourceResultVo.setName(sysResource.getSourceName());
            sysResourceResultVo.setRoute(sysResource.getReqUrl());
            if(sysResource.getSourceLevel()==1){
                //sysResourceResultVo.setBpid("1");
            }else{
                sysResourceResultVo.setBpid(sysResource.getFhSourceNo());
                sysResourceResultVo.setMpid(sysResource.getFhSourceNo());
            }
            sysResourceResultVo.setIcon(sysResource.getRsourceIcon());
            sysResourceResultVos.add(sysResourceResultVo);
        }
        return sysResourceResultVos;
    }

    @Override
    public List<SysResource> listAll() {
        return sysResourceMapper.selectAll();
    }


    private void convertVoToEntity(SysResource sysResource, SysResourceVo sysResourceVo) {
            BeanUtils.copyProperties(sysResourceVo,sysResource);
    }
}
