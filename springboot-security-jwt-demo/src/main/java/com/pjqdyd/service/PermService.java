package com.pjqdyd.service;

import com.pjqdyd.entity.Perm;

import java.util.List;

public interface PermService {

    default List<Perm> selectAllByUserId(Long userId) {
        return null;
    }

}
