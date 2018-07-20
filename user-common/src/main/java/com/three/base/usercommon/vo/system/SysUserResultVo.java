package com.three.base.usercommon.vo.system;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @Date:2017/10/30 0030 10:26
 * @Author lu.dong
 * @Description：
 **/
@Getter
@Setter
@ToString
@ApiModel(value = "用户结果实体 SysUserResultVo")
public class SysUserResultVo {
    @ApiModelProperty(value = "用户号")
    private String userNo;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "手机号")
    private String phoneNum;
    @ApiModelProperty(value = "邮箱地址")
    private String emailAddr;
    @ApiModelProperty(value = "角色名称")
    private String roleNames;
    @ApiModelProperty(value = "状态")
    private String status;
    @ApiModelProperty(value = "状态")
    private String statusName;
    private String lastLoginTime;
    private String createNo;
    private String createTime;
    private String modiNo;
    private String modiTime;

    private List<SysRoleResultVo> sysRoleResultVos;
}
