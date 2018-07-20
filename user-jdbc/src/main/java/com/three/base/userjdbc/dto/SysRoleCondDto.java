package com.three.base.userjdbc.dto;

/**
 * @Author:luiz
 * @Date: 2018/3/12 15:02
 * @Descripton:
 * @Modify :
 **/

public class SysRoleCondDto extends PageDto {
    private String roleCode;
    private String roleName;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
