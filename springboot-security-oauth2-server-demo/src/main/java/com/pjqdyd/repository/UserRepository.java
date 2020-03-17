package com.pjqdyd.repository;

import com.pjqdyd.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**   
 * @Description:  [用户Repository层]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
