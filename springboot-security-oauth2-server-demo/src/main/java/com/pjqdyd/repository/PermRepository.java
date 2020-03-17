package com.pjqdyd.repository;

import com.pjqdyd.domain.Perm;
import org.springframework.data.jpa.repository.JpaRepository;

/**   
 * @Description:  [权限Repository层]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

public interface PermRepository extends JpaRepository<Perm, Integer> {
}
