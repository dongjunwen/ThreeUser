package com.three.base.usercommon.PO.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Date:2017/10/19 0019 15:26
 * @Author lu.dong
 * @Description：
 **/
@Getter
@Setter
@ApiModel(value = "用户角色操作实体 SysUserRoleVo")
public class SysUserRoleVo implements Serializable {

    @NotBlank(message = "登录号不能为空")
    @ApiModelProperty(value = "登录号",required =true )
    private String userNo;
    @NotBlank(message = "角色代码不能为空")
    @ApiModelProperty(value = "角色代码",required = true)
    private String roleCode;

    private String operNo;

}
