package com.pjqdyd.repository;

import com.pjqdyd.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**   
 * @Description:  [权限Repository层]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    Permission findByPermissionNameCn(String permissionNameCn);

}
