package com.three.base.userweb.controller.system;


import com.google.common.collect.Lists;
import com.three.base.userapi.SysResourceService;
import com.three.base.userapi.SysRoleResourceService;
import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.result.Result;
import com.three.base.usercommon.vo.system.SysRoleResourceResultVo;
import com.three.base.usercommon.vo.system.SysRoleResourceVo;
import com.three.base.userjdbc.modal.SysResource;
import com.three.base.userjdbc.modal.SysRoleResource;
import com.three.base.userweb.utils.ShiroUtils;
import com.three.base.userweb.validator.ValidatorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date:2017/10/20 0020 14:03
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/sysRoleResource")
@Api(tags = "角色资源",description = "角色资源相关api")
public class SysRoleResourceController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SysRoleResourceService sysRoleResourceService;
    @Autowired
    SysResourceService sysResourceService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建角色资源", notes="根据角色资源对象创建角色资源")
    @ApiParam(name = "sysRoleResourceVo", value = "角色资源信息实体 sysRoleResourceVo", required = true)
    public Result<String> create(@RequestBody SysRoleResourceVo sysRoleResourceVo){
        ValidatorUtil.validateEntity(sysRoleResourceVo);//校验
        try{
            sysRoleResourceVo.setOperNo(ShiroUtils.getCurrentUserNo());
            Result<Integer> _result= sysRoleResourceService.create(sysRoleResourceVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getRetCode(),_result.getRetMsg());
            }
            return  Result.newSuccess("添加角色资源成功");
        }catch (Exception e){
            logger.error("添加角色资源异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value =  "save",method = RequestMethod.POST)
    @ApiOperation(value="保存角色资源", notes="批量保存角色资源")
    @ApiParam(name = "sysRoleResourceVos", value = "角色资源信息实体 sysRoleResourceVos", required = true)
    public Result<String> save(@RequestBody List<SysRoleResourceVo> sysRoleResourceVos){
        try{
            List<SysRoleResource> sysRoleResources= Lists.newArrayList();
            for(SysRoleResourceVo sysRoleResourceVo:sysRoleResourceVos){
                SysRoleResource sysRoleResource=new SysRoleResource();
                sysRoleResource.setRoleCode(sysRoleResourceVo.getRoleCode());
                sysRoleResource.setSourceNo(sysRoleResourceVo.getSourceNo());
                sysRoleResource.setCreateNo(ShiroUtils.getCurrentUserNo());
                sysRoleResource.setCreateTime(new Date());
                sysRoleResources.add(sysRoleResource);
            }
            Result<Integer> _result= sysRoleResourceService.save(sysRoleResources);
            if(!_result.isSuccess()){
                return Result.newError(_result.getRetCode(),_result.getRetMsg());
            }
            return  Result.newSuccess("保存角色资源成功");
        }catch (Exception e){
            logger.error("保存角色资源异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除角色资源", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "角色资源编号", required = true, dataType = "string",paramType = "path")
    public Result<String> delete(@PathVariable("id")String id){
        try {
            Result<Integer> _result =     sysRoleResourceService.delete(id);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getRetCode(), _result.getRetMsg());
            }
            return Result.newSuccess("删除角色资源成功");
        }catch (Exception e){
            logger.error("删除角色资源异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value="批量删除角色资源", notes="根据url的ids来指定删除对象")
    @ApiImplicitParam(name = "ids", value = "角色资源编号", required = true, dataType = "string",paramType = "path")
    public Result<String> deleteByIds(@PathVariable("ids")String ids){
        try {
            Result<Integer> _result =     sysRoleResourceService.deleteByIds(ids);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getRetCode(), _result.getRetMsg());
            }
            return Result.newSuccess("批量删除角色资源成功");
        }catch (Exception e){
            logger.error("批量删除角色资源异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

   /* @RequestMapping(value = "old/{roleCode}",method = RequestMethod.GET)
    @ApiOperation(value="获取角色资源详细信息", notes="根据url的roleCode来获取角色资源详细信息")
    @ApiImplicitParam(name = "roleCode", value = "角色资源编号", required = true, dataType = "string",paramType = "path")
    public Result<List<SysRoleResourceResultVo>> getEntityByNo(@PathVariable("roleCode") String roleCode){
        List<SysRoleResourceResultVo> sysResources = sysRoleResourceService.getEntityByRoleCode(roleCode);
        return Result.newSuccess(sysResources);
    }*/

    @RequestMapping(value = "/{roleCode}",method = RequestMethod.GET)
    @ApiOperation(value="获取角色资源详细信息", notes="根据url的roleCode来获取角色资源详细信息")
    @ApiImplicitParam(name = "roleCode", value = "角色资源编号", required = true, dataType = "string",paramType = "path")
    public Result<List<SysRoleResourceResultVo>> findByRoleCode(@PathVariable("roleCode") String roleCode){
        List<SysResource> sysResources=sysResourceService.listAll();
        List<SysRoleResource> sysRoleResources = sysRoleResourceService.getEntityByRoleCode(roleCode);
        List<SysRoleResourceResultVo> sysRoleResourceResultVos=new ArrayList<>();
        for(SysResource sysResource:sysResources){
            SysRoleResourceResultVo sysRoleResourceResultVo=new SysRoleResourceResultVo();
            BeanUtils.copyProperties(sysResource,sysRoleResourceResultVo);
            boolean flag=findHasRole(sysRoleResources,sysResource);
            sysRoleResourceResultVo.setChecked(flag);
            sysRoleResourceResultVo.setId(sysResource.getSourceNo());
            sysRoleResourceResultVo.setpId(sysResource.getFhSourceNo());
            sysRoleResourceResultVo.setName(sysResource.getSourceName());
            sysRoleResourceResultVos.add(sysRoleResourceResultVo);
        }
        return Result.newSuccess(sysRoleResourceResultVos);
    }

    private boolean findHasRole(List<SysRoleResource> sysRoleResources, SysResource sysResource) {
        for(SysRoleResource sysRoleResource:sysRoleResources){
            if(sysRoleResource.getSourceNo().equals(sysResource.getSourceNo())){
                return true;
            }
        }
        return false;
    }


}
