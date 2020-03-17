package com.pjqdyd.service;

import com.pjqdyd.domain.User;

/**   
 * @Description:  [用户服务接口]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

public interface UserService {

    User getUserByName(String username);

}
