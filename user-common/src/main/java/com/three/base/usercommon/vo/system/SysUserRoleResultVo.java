package com.three.base.usercommon.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Date:2017/10/19 0019 15:26
 * @Author lu.dong
 * @Description：
 **/
@Getter
@Setter
@ApiModel(value = "用户角色显示实体 SysUserRoleResultVo")
public class SysUserRoleResultVo implements Serializable {
    @ApiModelProperty(value = "主键Id",required =true )
    private String id;
    @ApiModelProperty(value = "登录号",required =true )
    private String userNo;
    @ApiModelProperty(value = "角色代码",required = true)
    private String roleCode;
    @ApiModelProperty(value = "角色名称",required = true)
    private String roleName;

}
