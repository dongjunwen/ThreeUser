package com.three.base.userweb.controller.system;


import com.three.base.userapi.SysUserService;
import com.three.base.usercommon.PO.system.SysUserVo;
import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.result.Result;
import com.three.base.userjdbc.modal.SysUser;
import com.three.base.userweb.utils.ShiroUtils;
import com.three.base.userweb.validator.ValidatorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiParam(name = "sysUserVo", value = "用户操作实体 sysUserVo",required = true)
    public Result<String> createUser(@RequestBody SysUserVo sysUserVo){
        ValidatorUtil.validateEntity(sysUserVo);//校验用户实体字段，
        try{
            sysUserVo.setOperNo(ShiroUtils.getCurrentUserNo());
            Result<Integer> _result=sysUserService.createUser(sysUserVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getRetCode(),_result.getRetMsg());
            }
            return  Result.newSuccess("添加账号成功");
        }catch (Exception e){
            logger.error("用户添加异常!{}",e);
            return Result.newError(ResultCode.FAIL);
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

    @RequestMapping(value = "/{userNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取用户详细信息", notes="根据url的用户编号来获取用户详细信息")
    @ApiImplicitParam(name = "userNo", value = "用户编号", required = true, dataType = "string",paramType = "path")
    public Result<SysUser> getUserById(@PathVariable("userNo")String userNo){
        SysUser user = sysUserService.getUserById(userNo);
        return Result.newSuccess(user);
    }


}
