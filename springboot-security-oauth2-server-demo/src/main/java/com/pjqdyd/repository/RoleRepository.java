package com.pjqdyd.repository;

import com.pjqdyd.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**   
 * @Description:  [角色Repository层]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
