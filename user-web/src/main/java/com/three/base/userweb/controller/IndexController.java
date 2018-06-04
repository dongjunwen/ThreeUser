package com.three.base.userweb.controller;


import com.three.base.userapi.SysUserService;
import com.three.base.usercommon.PO.result.SysUserResultVo;
import com.three.base.usercommon.PO.system.SysUserModiVo;
import com.three.base.usercommon.PO.system.SysUserVo;
import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.result.Result;
import com.three.base.userweb.utils.ShiroUtils;
import com.three.base.userweb.validator.Assert;
import com.three.base.userweb.validator.ValidatorUtil;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

/**
 * author:lu.dong
 * date:2017-10-17
 *  desc:首页显示
 */
@RestController
@RequestMapping("")
@Api(tags = "首页",description ="App相关操作接口定义类")
//@ApiIgnore
public class IndexController {
    private static final Logger logger= LoggerFactory.getLogger(IndexController.class);

    @Autowired
    SysUserService sysUserService;

    @ApiOperation(value = "Api首页",notes = "所有api接口")
    @RequestMapping(value = "/swagger",method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("swagger/index.html");
    }

    @ApiOperation(value = "登录首页",notes = "登录首页")
    @RequestMapping(value = "/loginIndex",method = RequestMethod.GET)
    public ModelAndView loginIndex(){
        return new ModelAndView("web/loginIndex.html");
    }

    @ApiOperation(value = "无权限页面",notes = "无权限页面")
    @RequestMapping(value = "/403",method = RequestMethod.GET)
    public ModelAndView Error403(){
        return new ModelAndView("web/403.html");
    }

    @ApiOperation(value = "登录",notes = "登录接口")
    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名",paramType = "form"),
            @ApiImplicitParam(name = "password",value = "用户密码",paramType = "form")
    })
    public Result<String> login(String name, String password, RedirectAttributes redirectAttributes){
        Assert.isBlank(name,"用户名不能为空");
        Assert.isBlank(password,"密码不能为空");
        //模拟登录
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject currentUser  = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            SysUserVo sysUserVo=new SysUserVo();
            sysUserVo.setUserNo(name);
            sysUserVo.setLastLoginTime(new Date());
            sysUserService.updateUser(sysUserVo);
            logger.info("账号:{}登录成功",name);
            return Result.newSuccess(name+"登录成功!");
        }catch(Exception e){
            //return new ResponseEntity<String>("用户名或密码错误", HttpStatus.UNPROCESSABLE_ENTITY);
            return Result.newError(ResultCode.USERNAME_OR_PASS_ERR);
        }
    }

    @ApiOperation(value = "修改密码",notes = "修改密码接口")
    @RequestMapping(value = "/api/modiPass",method = RequestMethod.POST)
   // @ApiImplicitParam(name = "sysUserModiVo", value = "用户修改实体 sysUserModiVo",dataTypeClass = SysUserModiVo.class)
    public Result<String> modiPass(@ApiParam(name = "sysUserModiVo", value = "用户修改实体 sysUserModiVo",required = true)@RequestBody SysUserModiVo sysUserModiVo){
        ValidatorUtil.validateEntity(sysUserModiVo);//校验用户实体字段，
        try {
            Result<Integer> _result = sysUserService.modiPass(sysUserModiVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getRetCode(), _result.getRetMsg());
            }
            return Result.newSuccess("修改修改成功");
        } catch (Exception e) {
            logger.error("修改密码修改异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value = "退出登录")
    @RequestMapping(value="/api/logout",method=RequestMethod.GET)
    public Result<String> logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.newSuccess("已退出!");
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value="/api/getCurrentUser",method=RequestMethod.GET)
    public Result<SysUserResultVo> getCurrentUser(){
        String loginNo= ShiroUtils.getCurrentUserNo();
        SysUserResultVo sysUserResultVo= sysUserService.getUserInfoByNo(loginNo);
        return  Result.newSuccess(sysUserResultVo);
    }
}
