package com.three.base.usercommon.PO.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * @Date:2017/10/19 0019 15:26
 * @Author lu.dong
 * @Description：
 **/
@Data
@ApiModel(value = "用户操作实体 SysUserVo")
public class SysUserVo implements Serializable {

    @NotBlank(message = "登录号不能为空")
    @ApiModelProperty(value = "登录号",required =true )
    private String userNo;
    @NotBlank(message = "登录密码不能为空")
    @ApiModelProperty(value = "登录密码",required = true)
    private String password;
    @ApiModelProperty(value = "昵称",required = false)
    private String nickName;
    @ApiModelProperty(value = "手机号",required = false)
    private Integer phoneNum;
    @ApiModelProperty(value = "邮箱地址",required = false)
    private String emailAddr;
    @ApiModelProperty(value = "备注",required = false)
    private String memo;
    private Date lastLoginTime;
    private String operNo;



}
