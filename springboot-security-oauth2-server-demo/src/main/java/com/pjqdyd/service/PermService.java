package com.pjqdyd.service;

import com.pjqdyd.domain.Perm;

import java.util.List;

/**   
 * @Description:  [权限服务接口]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

public interface PermService {

    List<Perm> getPermByUserId(Long userId);

}
