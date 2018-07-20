package com.three.base.usercommon.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Date:2017/12/25 0025 14:46
 * @Author lu.dong
 * @Description：
 **/
@Getter
@Setter
@ToString
@ApiModel(value = "角色操作实体 SysRoleResourceVo")
public class SysRoleResourceVo {
    @NotBlank(message = "角色代码不能为空")
    @Length(min = 1,max = 32,message = "角色代码长度不能超过32")
    @ApiModelProperty(value = "角色代码",required =true )
    private String roleCode;
    @NotBlank(message = "资源代码不能为空")
    @Length(min = 1,max = 32,message = "资源代码长度不能超过32")
    @ApiModelProperty(value = "资源代码",required =true )
    private String sourceNo;
    private String operNo;

}
