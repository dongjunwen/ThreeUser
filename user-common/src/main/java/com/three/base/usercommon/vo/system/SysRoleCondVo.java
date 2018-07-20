package com.three.base.usercommon.vo.system;

import com.three.base.usercommon.vo.PageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @Date:2017/10/23 0023 14:39
 * @Author lu.dong
 * @Description：
 **/
@Getter
@Setter
@ToString
@ApiModel(value = "角色操作实体 SysRoleCondVo")
public class SysRoleCondVo extends PageVo {
    @ApiModelProperty(value = "角色代码")
    private String roleCode;
    @ApiModelProperty(value = "角色名称" )
    private String roleName;
    private String status;
}
