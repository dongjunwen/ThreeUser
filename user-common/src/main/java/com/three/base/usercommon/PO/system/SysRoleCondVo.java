package com.three.base.usercommon.PO.system;

import com.three.base.usercommon.PO.PageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Date:2017/12/25 0025 14:46
 * @Author lu.dong
 * @Description：
 **/
@Data
@ApiModel(value = "角色操作实体 SysRoleCondVo")
public class SysRoleCondVo extends PageVo{
    @ApiModelProperty(value = "角色代码",required =true )
    private String roleCode;
    @ApiModelProperty(value = "角色名称",required =true )
    private String roleName;
    @ApiModelProperty(value = "状态",required =false )
    private String status;
}
