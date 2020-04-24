package com.pjqdyd.mapper;

import com.pjqdyd.entity.Perm;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface PermMapper extends MyMapper<Perm> {

    /**
     * 通过用户Id查询该用户的所有权限
     * @param userId
     * @return
     */
    List<Perm> selectAllByUserId(@Param("userId") Long userId);

}