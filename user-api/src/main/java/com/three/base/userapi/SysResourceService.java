package com.three.base.userapi;


import com.github.pagehelper.Page;
import com.three.base.usercommon.PO.result.SysResourceResultVo;
import com.three.base.usercommon.PO.system.SysResourceVo;
import com.three.base.usercommon.result.Result;
import com.three.base.userjdbc.modal.SysResource;

import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/23 0023 14:29
 * @Author lu.dong
 * @Description：
 **/
public interface SysResourceService {
    Result<Integer> create(SysResourceVo sysResourceVo);

    Result<Integer> update(SysResourceVo sysResourceVo);

    Result<Integer> delete(String sourceNo);

    SysResource getEntityByNo(String sourceNo);

    Page<SysResource> findList(Map<String, String> params);

    List<SysResourceResultVo> getListByCurrentUser(String userNo);
}
