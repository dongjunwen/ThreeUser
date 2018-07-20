package com.three.base.usercommon.vo.system;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

/**
 * @Date:2017/12/25 0025 14:46
 * @Author lu.dong
 * @Description：
 **/

@ToString
@ApiModel(value = "角色资源显示实体 SysRoleResourceResultVo")
public class SysRoleResourceResultVo {
    @ApiModelProperty(value = "主键Id" )
    private String id;
    /**
     * 面包屑导航的父id
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pId;
    private String name;
    @ApiModelProperty(value = "角色代码" )
    private String roleCode;
    @ApiModelProperty(value = "资源代码" )
    private String sourceNo;
    @ApiModelProperty(value = "资源名称" )
    private String sourceName;
    @ApiModelProperty(value = "是否拥有权限" )
    private boolean checked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
