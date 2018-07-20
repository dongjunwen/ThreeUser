package com.three.base.usercommon.vo.system;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@ApiModel(value = "角色操作实体 SysResourceVo")
public class SysRoleResultVo {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    /**
     * 面包屑导航的父id
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pId;
    private String name;
    @NotBlank(message = "角色代码不能为空")
    @Length(min = 1,max = 32,message = "角色代码长度不能超过32")
    @ApiModelProperty(value = "角色代码",required =true )
    private String roleCode;
    @NotBlank(message = "角色名称不能为空")
    @Length(min = 1,max = 64,message = "角色名称长度不能超过64")
    @ApiModelProperty(value = "角色名称",required =true )
    private String roleName;
    private boolean checked;
}
