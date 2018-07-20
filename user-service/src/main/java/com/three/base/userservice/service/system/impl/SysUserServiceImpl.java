package com.three.base.userservice.service.system.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.three.base.userapi.SysUserService;
import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.result.Result;
import com.three.base.usercommon.utils.MD5Util;
import com.three.base.usercommon.vo.system.SysUserModiVo;
import com.three.base.usercommon.vo.system.SysUserResultVo;
import com.three.base.usercommon.vo.system.SysUserVo;
import com.three.base.userjdbc.dto.SysUserCondDto;
import com.three.base.userjdbc.mapper.SysUserMapper;
import com.three.base.userjdbc.mapper.SysUserRoleMapper;
import com.three.base.userjdbc.modal.SysUser;
import com.three.base.userjdbc.util.Common;
import com.three.base.userservice.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.Date;
import java.util.Map;

/**
 * @Date:2017/10/19 0019 15:08
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    private static  final Logger logger=LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
 /*   @Autowired
    SwDepartEmployeeMapper swDepartEmployeeMapper;
    @Autowired
    SwDepartInfoMapper swDepartInfoMapper;
    @Autowired
    SwCompanyInfoMapper swCompanyInfoMapper;*/


    @Override
    @Transactional
    public Result<Integer> createUser(SysUserVo sysUserVo) {
        SysUser _sysUser=sysUserMapper.selectByUserNo(sysUserVo.getUserNo());
        if(_sysUser!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"账户已存在!");
        }
        SysUser sysUser=new SysUser();
        convertVoToEntity(sysUser,sysUserVo);
        sysUser.setPassword(MD5Util.getMD5(sysUser.getPassword()==null?"123456":sysUser.getPassword()));
        sysUser.setCreateNo(sysUserVo.getOperNo());
        sysUser.setCreateTime(new Date());
        sysUser.setModiNo(sysUserVo.getOperNo());
        sysUser.setModiTime(new Date());
        sysUserMapper.insertSelective(sysUser);
        return Result.newSuccess(1);
    }

    @Override
    public SysUser login(String userNo) {
        return sysUserMapper.selectByUserNo(userNo);
    }

    @Override
    public Result<Integer> updateUser(SysUserVo sysUserVo) {

        SysUser _sysUser=sysUserMapper.selectByUserNo(sysUserVo.getUserNo());
        if(_sysUser==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"账户不存在!");
        }
        SysUser sysUser=new SysUser();
        convertVoToEntity(sysUser,sysUserVo);
        sysUser.setModiNo(sysUserVo.getOperNo());
        sysUser.setModiTime(new Date());
        sysUser.setVersion(_sysUser.getVersion());
        return Result.newSuccess(sysUserMapper.updateByUserNo(sysUser));
    }

    @Override
    public  Result<Integer> delUser(String userNo) {
        SysUser _sysUser=sysUserMapper.selectByUserNo(userNo);
        if(_sysUser==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"账户不存在!");
        }
        return Result.newSuccess(sysUserMapper.deleteByUserNo(userNo));
    }

    @Override
    public SysUser getUserById(String userNo) {
        return sysUserMapper.selectByUserNo(userNo);
    }

    @Override
    public String getUserNameById(String userNo) {
        SysUser sysUser=getUserById(userNo);
        if(sysUser==null) return "";
        return sysUser.getUserName();
    }

    @Override
    public SysUserResultVo getUserInfoByNo(String loginNo) {
        SysUserResultVo sysUserResultVo=new SysUserResultVo();
        SysUser sysUser=getUserById(loginNo);
        sysUserResultVo.setUserNo(loginNo);
        sysUserResultVo.setUserName(sysUser.getUserName());
        sysUserResultVo.setNickName(sysUser.getNickName());
        sysUserResultVo.setEmailAddr(sysUser.getEmailAddr());
        sysUserResultVo.setPhoneNum(sysUser.getPhoneNum());
        return sysUserResultVo;
    }

    @Override
    public Result<Integer> modiPass(SysUserModiVo sysUserModiVo) {
        SysUser oldSysUser=getUserById(sysUserModiVo.getUserNo());
        if(oldSysUser==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"账户不存在!");
        }
        String signPass=MD5Util.getMD5(sysUserModiVo.getOldPass());
        if(!oldSysUser.getPassword().equals(signPass)){
            return  Result.newError(ResultCode.USER_OLD_PASS_ERROR);
        }
        if(!sysUserModiVo.getPasswordNew1().equals(sysUserModiVo.getPasswordNew2())){
            return   Result.newError(ResultCode.USER_PASS_NOT_EQUAL);
        }
        SysUser sysUser=new SysUser();
        sysUser.setUserNo(oldSysUser.getUserNo());
        String signPass1=MD5Util.getMD5(sysUserModiVo.getPasswordNew1());
        sysUser.setPassword(signPass1);
        sysUser.setVersion(oldSysUser.getVersion());
        return Result.newSuccess(sysUserMapper.updateByUserNo(sysUser));
    }

    /**
     * 启用|禁用用户
     * @param userNo
     * @return
     */
    @Override
    public Result<Integer> operUser(String userNo,String operNo) {
        SysUser _sysUser=sysUserMapper.selectByUserNo(userNo);
        if(_sysUser==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"账户不存在!");
        }
        SysUser sysUser=new SysUser();
        sysUser.setUserNo(userNo);
        if("Y".equals(_sysUser.getStatus())){
            sysUser.setStatus("N");
        }else{
            sysUser.setStatus("Y");
        }
        sysUser.setModiNo(operNo);
        sysUser.setModiTime(new Date());
        sysUser.setVersion(_sysUser.getVersion());
        return Result.newSuccess(sysUserMapper.updateByUserNo(sysUser));
    }

    private void convertVoToEntity(SysUser sysUser,SysUserVo sysUserVo) {
           BeanUtils.copyProperties(sysUserVo,sysUser);
    }

    @Override
    public Page<SysUserResultVo> findList(Map<String, String> params) {
        Weekend serviceCondition = Common.getServiceCondition(params, SysUser.class);
        Page<SysUser> sysUsers = (Page<SysUser>)findByCondition(serviceCondition);
        Page<SysUserResultVo> sysUserResultVos=new Page<SysUserResultVo>();
        sysUserResultVos.setTotal(sysUsers.getTotal());
        sysUserResultVos.setPages(sysUsers.getPages());
        sysUserResultVos.setPageSize(sysUsers.getPageSize());
        sysUserResultVos.setPageNum(sysUsers.getPageNum());
        for(SysUser sysUser:sysUsers){
            SysUserResultVo sysUserResultVo=new SysUserResultVo();
            BeanUtils.copyProperties(sysUser,sysUserResultVo);
            sysUserResultVo.setStatusName(SysDictUtils.getNameByUniq("STATUS",sysUser.getStatus()));
            sysUserResultVos.add(sysUserResultVo);
        }
        return sysUserResultVos;
    }

    @Override
    public Page<SysUser> listPage(SysUserCondDto sysUserCondDto) {
        //使用PageHelper类进行分页
        PageHelper.startPage(sysUserCondDto.getPageNum(), sysUserCondDto.getPageSize());
        return (Page) sysUserMapper.selectList(sysUserCondDto);
    }
}
