package com.three.base.userweb.controller.system;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.three.base.userapi.SysRoleService;
import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.result.Result;
import com.three.base.usercommon.vo.system.SysRoleCondVo;
import com.three.base.usercommon.vo.system.SysRoleResultVo;
import com.three.base.usercommon.vo.system.SysRoleVo;
import com.three.base.userjdbc.dto.SysRoleCondDto;
import com.three.base.userjdbc.modal.SysRole;
import com.three.base.userweb.utils.PageUitls;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @RequestMapping(value = "create",method = RequestMethod.POST)
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

    @RequestMapping(value = "listPage",method = RequestMethod.POST)
    @ApiOperation(value="角色分页查询", notes="角色分页查询")
    @ApiParam(name = "sysRoleCondVo", value = "角色分页查询 sysRoleCondVo", required = true)
    public Result listPage(@RequestBody SysRoleCondVo sysRoleCondVo){
        Page<SysRole> page =  sysRoleService.findList(sysRoleCondVo);
        return Result.newSuccess(new PageInfo<>(page));
    }

    @RequestMapping(value = "listAll",method = RequestMethod.POST)
    @ApiOperation(value="获取所有角色信息", notes="获取所有角色信息")
    public Result listAll(HttpServletRequest request){
        List<SysRole> sysRoleList=sysRoleService.listAll();
        List<SysRoleResultVo> sysRoleResultVos= Lists.newArrayList();
        for(SysRole sysRole:sysRoleList){
            SysRoleResultVo sysRoleResultVo=new SysRoleResultVo();
            sysRoleResultVo.setId(sysRole.getRoleCode());
            sysRoleResultVo.setName(sysRole.getRoleName());
            sysRoleResultVo.setRoleCode(sysRole.getRoleCode());
            sysRoleResultVo.setRoleName(sysRole.getRoleName());
            sysRoleResultVos.add(sysRoleResultVo);
        }
        return Result.newSuccess(sysRoleResultVos);
    }


}
