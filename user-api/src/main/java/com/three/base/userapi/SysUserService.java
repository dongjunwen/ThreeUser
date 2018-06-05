package com.three.base.userapi;


import com.github.pagehelper.Page;
import com.three.base.usercommon.PO.result.SysUserResultVo;
import com.three.base.usercommon.PO.system.SysUserModiVo;
import com.three.base.usercommon.PO.system.SysUserVo;
import com.three.base.usercommon.result.Result;
import com.three.base.userjdbc.modal.SysUser;

import java.util.Map;

/**
 * @Date:2017/10/19 0019 15:07
 * @Author lu.dong
 * @Description：
 **/
public interface SysUserService {
    /**
     * 创建用户信息
     * @param sysUserVo
     * @return
     */
    Result<Integer> createUser(SysUserVo sysUserVo);

    /**
     * 登录
     * @param userNo 登录账号
     * @return
     */
    SysUser login(String userNo);

    /**
     * 修改用户信息
     * @param sysUserVo
     * @return
     */
    Result<Integer> updateUser(SysUserVo sysUserVo);

    /**
     * 按照用户号删除用户
     * @param userNo
     */
    Result<Integer> delUser(String userNo);

    /**
     * 按照用户号获取用户
     * @param userNo
     * @return
     */
    SysUser getUserById(String userNo);

    String getUserNameById(String userNo);

    /**
     * 按照用户号获取用户信息
     * @param loginNo
     * @return
     */
    SysUserResultVo getUserInfoByNo(String loginNo);

    Result<Integer> modiPass(SysUserModiVo sysUserModiVo);

    Result<Integer> operUser(String userNo,String operNo);

    Page<SysUserResultVo> findList(Map<String, String> params);
}
