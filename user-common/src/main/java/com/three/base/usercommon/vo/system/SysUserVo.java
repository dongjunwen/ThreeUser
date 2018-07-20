package com.three.base.usercommon.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Date:2017/10/19 0019 15:26
 * @Author lu.dong
 * @Description：
 **/
@Getter
@Setter
@ToString
@ApiModel(value = "用户操作实体 SysUserVo")
public class SysUserVo implements Serializable {
    @NotNull(message = "登录号不能为空")
    @ApiModelProperty(value = "登录号",required =true )
    private String userNo;
    @ApiModelProperty(value = "姓名",required = true)
    private String userName;
    @ApiModelProperty(value = "昵称",required = false)
    private String nickName;
    @ApiModelProperty(value = "手机号",required = false)
    private String phoneNum;
    @ApiModelProperty(value = "邮箱地址",required = false)
    private String emailAddr;
    @ApiModelProperty(value = "状态",required = false)
    private String status;
    @ApiModelProperty(value = "备注",required = false)
    private String memo;
    @ApiModelProperty(value = "角色列表",required = false)
    private List<SysUserRoleVo> sysUserRoleVos;
    private String operNo;

}
