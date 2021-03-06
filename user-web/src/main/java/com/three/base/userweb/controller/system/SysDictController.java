package com.three.base.userweb.controller.system;

import com.github.pagehelper.Page;
import com.three.base.userapi.SysDictService;
import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.result.Result;
import com.three.base.usercommon.vo.system.SysDictCondVo;
import com.three.base.usercommon.vo.system.SysDictVo;
import com.three.base.userjdbc.modal.SysDict;
import com.three.base.userweb.utils.PageUitls;
import com.three.base.userweb.validator.ValidatorUtil;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Date:2017/10/20 0020 14:04
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/sysDict")
@Api(tags = "数据字典",description = "数据字典相关api")
public class SysDictController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SysDictService sysDictService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建数据字典", notes="根据数据字典对象创建数据字典")
    //@ApiImplicitParam(name = "sysDictVo", value = "数据字典信息实体 sysDictVo",dataTypeClass = SysDictVo.class)
    @ApiParam(name = "sysDictVo", value = "数据字典信息实体 sysDictVo", required = true)
    public Result<String> create( @RequestBody SysDictVo sysDictVo){
        ValidatorUtil.validateEntity(sysDictVo);//校验
        try{
            Result<Integer> _result= sysDictService.create(sysDictVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getRetCode(),_result.getRetMsg());
            }
            return  Result.newSuccess("添加数据字典成功");
        }catch (Exception e){
            logger.error("添加数据字典异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value="更新数据字典详细信息", notes="根据url的数据字典编号来指定更新对象，并根据传过来的数据字典信息来更新数据字典详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SysDictVo sysDictVo){
        try {
            Result<Integer> _result =  sysDictService.update(sysDictVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getRetCode(), _result.getRetMsg());
            }
            return Result.newSuccess("修改数据字典成功");
        } catch (Exception e) {
            logger.error("修改数据字典异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/delDictByUniq",method = RequestMethod.POST)
    @ApiOperation(value="删除数据字典", notes="根据url的来指定删除对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictType", value = "数据字典类型", required = true, dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "dictCode", value = "数据字典编号", required = true, dataType = "string",paramType = "query")
    })
    public Result<String> delete(@RequestParam("dictType") String dictType, @RequestParam("dictCode")String dictCode){
        try {
            Result<Integer> _result =     sysDictService.delete(dictType,dictCode);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getRetCode(), _result.getRetMsg());
            }
            return Result.newSuccess("删除数据字典成功");
        }catch (Exception e){
            logger.error("删除数据字典异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{dictType}",method = RequestMethod.GET)
    @ApiOperation(value="获取数据字典详细信息", notes="根据url的sourceNo来获取数据字典详细信息")
    @ApiImplicitParam(name = "dictType", value = "数据字典类型", required = true, dataType = "string",paramType = "path")
    public Result< List<SysDict>> getEntityByType(@PathVariable("dictType") String dictType){
        List<SysDict> sysDictList = sysDictService.getEntityByDictType(dictType);
        return Result.newSuccess(sysDictList);
    }

    @RequestMapping(value = "findDictByType",method = RequestMethod.GET)
    @ApiOperation(value="获取数据字典详细信息", notes="根据url的sourceNo来获取数据字典详细信息")
    @ApiImplicitParam(name = "dictType", value = "数据字典类型", required = true, dataType = "string",paramType = "path")
    public Result< List<SysDict>> findDictByType(@RequestParam("dictType") String dictType){
        List<SysDict> sysDictList = sysDictService.getEntityByDictType(dictType);
        return Result.newSuccess(sysDictList);
    }

    @RequestMapping(value = "/getDictByUniq",method = RequestMethod.POST)
    @ApiOperation(value="获取数据字典详细信息", notes="根据url的sourceNo来获取数据字典详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictType", value = "数据字典类型", required = true, dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "dictCode", value = "数据字典编号", required = true, dataType = "string",paramType = "query")
    })
    public Result<SysDict> getEntityByNo(@RequestParam("dictType") String dictType, @RequestParam("dictCode")String dictCode){
        SysDict sysResource = sysDictService.getEntityByNo(dictType,dictCode);
        return Result.newSuccess(sysResource);
    }

    @ApiOperation(value = "数据字典列表")
    @RequestMapping(value = "findList",method = RequestMethod.POST)
    public Result<PageUitls<SysDict>> findList(@RequestBody SysDictCondVo sysDictCondVo){
        Page<SysDict> page =  sysDictService.findList(sysDictCondVo);
        return Result.newSuccess(new PageUitls<SysDict>(page));
    }
}
