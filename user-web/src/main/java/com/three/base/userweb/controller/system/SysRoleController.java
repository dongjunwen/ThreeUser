package com.three.base.userweb.controller.system;

import com.alibaba.fastjson.JSON;

import com.github.pagehelper.Page;
import com.three.base.userapi.SysRoleService;
import com.three.base.usercommon.PO.system.SysRoleCondVo;
import com.three.base.usercommon.PO.system.SysRoleVo;
import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.result.Result;
import com.three.base.userjdbc.modal.SysRole;
import com.three.base.userweb.utils.PageUitls;
import com.three.base.userweb.utils.ShiroUtils;
import com.three.base.userweb.validator.ValidatorUtil;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/20 0020 14:03
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/sysRole")
@Api(tags = "角色",description = "角色相关api")
public class SysRoleController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SysRoleService sysRoleService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建角色", notes="根据角色对象创建角色")
    @ApiParam(name = "sysRoleVo", value = "角色信息实体 sysRoleVo", required = true)
    public Result<String> create(@RequestBody SysRoleVo sysRoleVo){
        ValidatorUtil.validateEntity(sysRoleVo);//校验
        try{
            sysRoleVo.setOperNo(ShiroUtils.getCurrentUserNo());
            Result<Integer> _result= sysRoleService.create(sysRoleVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getRetCode(),_result.getRetMsg());
            }
            return  Result.newSuccess("添加角色成功");
        }catch (Exception e){
            logger.error("添加角色异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value="更新角色详细信息", notes="根据url的角色编号来指定更新对象，并根据传过来的角色信息来更新角色详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SysRoleVo sysRoleVo){
        try {
            sysRoleVo.setOperNo(ShiroUtils.getCurrentUserNo());
            Result<Integer> _result =  sysRoleService.update(sysRoleVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getRetCode(), _result.getRetMsg());
            }
            return Result.newSuccess("修改角色成功");
        } catch (Exception e) {
            logger.error("修改角色异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{roleCode}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除角色", notes="根据url的compNo来指定删除对象")
    @ApiImplicitParam(name = "roleCode", value = "角色编号", required = true, dataType = "string",paramType = "path")
    public Result<String> delete(@PathVariable("roleCode")String roleCode){
        try {
            Result<Integer> _result =     sysRoleService.delete(roleCode);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getRetCode(), _result.getRetMsg());
            }
            return Result.newSuccess("删除角色成功");
        }catch (Exception e){
            logger.error("删除角色异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/findRoleLike/{condStr}",method = RequestMethod.GET)
    @ApiOperation(value="根据条件模糊匹配角色v列表", notes="根据查询条件模糊匹配角色列表")
    @ApiImplicitParam(name = "condStr", value = "查询条件", required = true, dataType = "string",paramType = "path")
    public Result<List<SysRole>> findMaterialLike(@PathVariable("condStr") String condStr){
        List<SysRole> sysRoles = sysRoleService.findRoleLike(condStr);
        return Result.newSuccess(sysRoles);
    }

    @RequestMapping(value = "/{roleCode}",method = RequestMethod.GET)
    @ApiOperation(value="获取角色详细信息", notes="根据url的roleCode来获取角色详细信息")
    @ApiImplicitParam(name = "roleCode", value = "角色编号", required = true, dataType = "string",paramType = "path")
    public Result<SysRole> getEntityByNo(@PathVariable("roleCode") String roleCode){
        SysRole sysRole = sysRoleService.getEntityByNo(roleCode);
        return Result.newSuccess(sysRole);
    }

    @ApiOperation(value = "角色列表")
    @RequestMapping(value = "findList",method = RequestMethod.POST)
    public Result<PageUitls<SysRole>> findList(@RequestBody SysRoleCondVo sysRoleCondVo){
        Page<SysRole> page =  sysRoleService.findList(sysRoleCondVo);
        return Result.newSuccess(new PageUitls<SysRole>(page));
    }

}
