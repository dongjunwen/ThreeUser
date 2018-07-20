package com.three.base.userweb.controller.system;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.three.base.userapi.SysRoleService;
import com.three.base.userapi.SysUserRoleService;
import com.three.base.userapi.SysUserService;
import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.result.Result;
import com.three.base.usercommon.utils.DateUtil;
import com.three.base.usercommon.vo.system.*;
import com.three.base.userjdbc.dto.SysUserCondDto;
import com.three.base.userjdbc.modal.SysRole;
import com.three.base.userjdbc.modal.SysUser;
import com.three.base.userjdbc.modal.SysUserRole;
import com.three.base.userweb.utils.PageUitls;
import com.three.base.userweb.utils.ShiroUtils;
import com.three.base.userweb.validator.ValidatorUtil;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/19 0019 15:05
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户",description = "用户相关api")
public class SysUserController {
    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysUserRoleService sysUserRoleService;
    @Autowired
    SysRoleService sysRoleService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiParam(name = "sysUserVo", value = "用户操作实体 sysUserVo",required = true)
    public Result<String> createUser(@RequestBody SysUserVo sysUserVo){
        ValidatorUtil.validateEntity(sysUserVo);//校验用户实体字段，
        try{
            sysUserVo.setOperNo(ShiroUtils.getCurrentUserNo());

            Result<Integer> _result=sysUserService.createUser(sysUserVo);
            saveUserRole(sysUserVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getRetCode(),_result.getRetMsg());
            }
            return  Result.newSuccess("添加账号成功");
        }catch (Exception e){
            logger.error("用户添加异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    private void saveUserRole(SysUserVo sysUserVo) {
        if(sysUserVo.getSysUserRoleVos()!=null){
            List<SysUserRole> sysUserRoleList= Lists.newArrayList();
            for(SysUserRoleVo sysUserRoleVo:sysUserVo.getSysUserRoleVos()){
                SysUserRole sysUserRole=new SysUserRole();
                sysUserRole.setUserNo(sysUserVo.getUserNo());
                sysUserRole.setRoleCode(sysUserRoleVo.getRoleCode());
                sysUserRole.setRoleName(sysUserRoleVo.getRoleName());
                sysUserRole.setCreateTime(new Date());
                sysUserRole.setCreateNo(ShiroUtils.getCurrentUserNo());
                sysUserRoleList.add(sysUserRole);
            }
            sysUserRoleService.deleteByUserNo(sysUserVo.getUserNo());
            sysUserRoleService.insert(sysUserRoleList);
        }
    }

    @RequestMapping(value = "updateUser",method = RequestMethod.PUT)
    @ApiOperation(value="修改用户", notes="根据User对象修改用户")
    //@ApiImplicitParam(name = "sysUserVo", value = "用户操作实体 sysUserVo",dataTypeClass = SysUserVo.class)
    @ApiParam(name = "sysUserVo", value = "用户操作实体 sysUserVo",required = true)
    public Result<String> updateUser(@RequestBody SysUserVo sysUserVo) {
        ValidatorUtil.validateEntity(sysUserVo);//校验用户实体字段，
        try {
            sysUserVo.setOperNo(ShiroUtils.getCurrentUserNo());
            Result<Integer> _result = sysUserService.updateUser(sysUserVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getRetCode(), _result.getRetMsg());
            }
            return Result.newSuccess("修改账号成功");
        } catch (Exception e) {
            logger.error("用户修改异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{userNo}",method = RequestMethod.PUT)
    @ApiOperation(value="启用|禁用用户", notes="根据url的用户编号来启用禁用用户")
    @ApiImplicitParam(name = "userNo", value = "用户编号", required = true, dataType = "string",paramType = "path")
    public Result<String>  operUser(@PathVariable("userNo")String userNo){
        try {
            Result<Integer> _result =  sysUserService.operUser(userNo, ShiroUtils.getCurrentUserNo());
            if (!_result.isSuccess()) {
                return Result.newError(_result.getRetCode(), _result.getRetMsg());
            }
        }catch (Exception e){
            logger.error("启用|禁用用户异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
        return Result.newSuccess("启用|禁用用户成功");
    }

    @RequestMapping(value = "/{userNo}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除用户", notes="根据url的用户编号来指定删除对象")
    @ApiImplicitParam(name = "userNo", value = "用户编号", required = true, dataType = "string",paramType = "path")
    public Result<String>  delUser(@PathVariable("userNo")String userNo){
        try {
            Result<Integer> _result =  sysUserService.delUser(userNo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getRetCode(), _result.getRetMsg());
            }
        }catch (Exception e){
            logger.error("用户删除异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
        return Result.newSuccess("已删除");
    }
/*
    @RequestMapping(value = "/{userNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取用户详细信息", notes="根据url的用户编号来获取用户详细信息")
    @ApiImplicitParam(name = "userNo", value = "用户编号", required = true, dataType = "string",paramType = "path")
    public Result<SysUser> getUserById(@PathVariable("userNo")String userNo){
        SysUser user = sysUserService.getUserById(userNo);
        return Result.newSuccess(user);
    }*/

    @ApiOperation(value = "用户列表")
    @RequestMapping(method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currPage",value = "当前页",paramType = "query"),
            @ApiImplicitParam(name = "sort",value = "排序 ASC 或 DESC",required = false,example = "asc/desc",paramType = "query"),
            @ApiImplicitParam(name = "orderBy",value = "排序字段",required = false,example = "createdTime",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示条数",required = false,example = "createdTime",paramType = "query"),
            //@ApiImplicitParam(name = "startTime",value = "开始时间",dataType = "long",paramType = "query"),如果时间类型则可以打开
            //@ApiImplicitParam(name = "endTime",value = "结束时间",dataType = "long",paramType = "query"),
            @ApiImplicitParam(name = "filter",value = "通用表过滤器。发送JSON键/值对，如<code>{“key”:“value”}</code>。", paramType = "query",dataTypeClass = JSON.class)

    })
    public Result<PageUitls<SysUserResultVo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SysUserResultVo> page =  sysUserService.findList(params);
        return Result.newSuccess(new PageUitls<SysUserResultVo>(page));
    }


    @RequestMapping(value = "/{userNo:.+}",method = RequestMethod.GET)
    @ApiOperation(value="获取用户详细信息", notes="根据url的用户编号来获取用户详细信息")
    @ApiImplicitParam(name = "userNo", value = "用户编号", required = true, dataType = "string",paramType = "path")
    public Result<SysUserResultVo> getUserById(@PathVariable("userNo")String userNo){
        SysUser user = sysUserService.getUserById(userNo);
        if(user==null){
            return Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS);
        }
        SysUserResultVo sysUserResultVo=new SysUserResultVo();
        BeanUtils.copyProperties(user,sysUserResultVo);
        if(user.getModiTime()!=null)
            sysUserResultVo.setModiTime(DateUtil.getDateFormat(user.getModiTime(),"yyyy-MM-dd HH:mm:ss"));
        if(user.getCreateTime()!=null)
            sysUserResultVo.setCreateTime(DateUtil.getDateFormat(user.getCreateTime(),"yyyy-MM-dd HH:mm:ss"));
        List<SysRole> sysRoleList=sysRoleService.listAll();
        List<SysUserRole> sysUserRoles=sysUserRoleService.selectByUserNo(userNo);
        List<SysRoleResultVo> sysRoleResultVos= Lists.newArrayList();
        StringBuffer stb=new StringBuffer();
        for(SysRole sysRole:sysRoleList){
            SysRoleResultVo sysRoleResultVo=new SysRoleResultVo();
            sysRoleResultVo.setId(sysRole.getRoleCode());
            sysRoleResultVo.setName(sysRole.getRoleName());
            sysRoleResultVo.setRoleCode(sysRole.getRoleCode());
            sysRoleResultVo.setRoleName(sysRole.getRoleName());
            boolean flag=findHasRole(sysUserRoles,sysRole);
            sysRoleResultVo.setChecked(flag);
            if(flag){
                stb.append(sysRole.getRoleName()).append(",");
            }
            sysRoleResultVos.add(sysRoleResultVo);
        }
        String roleNames=stb.toString();
        roleNames=roleNames.substring(0,roleNames.lastIndexOf(",")-1);
        sysUserResultVo.setRoleNames(roleNames);
        sysUserResultVo.setSysRoleResultVos(sysRoleResultVos);
        return Result.newSuccess(sysUserResultVo);
    }

    private boolean findHasRole(List<SysUserRole> sysUserRoles, SysRole sysRole) {
        for(SysUserRole sysUserRole:sysUserRoles){
            if(sysRole.getRoleCode().equals(sysUserRole.getRoleCode())){
                return true;
            }
        }
        return false;
    }


    @RequestMapping(value = "listPage",method = RequestMethod.POST)
    @ApiOperation(value="用户分页查询", notes="用户分页查询")
    @ApiParam(name = "SysUserCondVo", value = "用户分页查询 sysUserCondVo", required = true)
    public Result listPage(@RequestBody SysUserCondVo sysUserCondVo){
        SysUserCondDto sysUserCondDto=new SysUserCondDto();
        BeanUtils.copyProperties(sysUserCondVo,sysUserCondDto);
        Page<SysUser> page =  sysUserService.listPage(sysUserCondDto);
        return Result.newSuccess(new PageInfo<>(page));
    }


}
