package com.pjqdyd.repository;

import com.pjqdyd.domain.Perm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**   
 * @Description:  [权限Repository层]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

public interface PermRepository extends JpaRepository<Perm, Integer> {


    /**
     * 这里使用原生sql查询, 根据userId通过多表联查,查出该用户的权限集合
     * @param userId
     * @return
     */
    @Query(value = "SELECT p.* FROM tb_user AS u " +
            "LEFT JOIN tb_user_role AS ur ON u.user_id = ur.user_id " +
            "LEFT JOIN tb_role AS r ON r.role_id = ur.role_id " +
            "LEFT JOIN tb_role_perm AS rp ON r.role_id = rp.role_id " +
            "LEFT JOIN tb_perm AS p ON p.perm_id = rp.perm_id " +
            "WHERE u.user_id = :userId", nativeQuery = true)
    List<Perm> findAllByUserId(@Param("userId") Long userId);

}
