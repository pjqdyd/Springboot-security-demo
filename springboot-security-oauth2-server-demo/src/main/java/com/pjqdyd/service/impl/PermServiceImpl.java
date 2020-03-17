package com.pjqdyd.service.impl;

import com.pjqdyd.domain.Perm;
import com.pjqdyd.repository.PermRepository;
import com.pjqdyd.service.PermService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**   
 * @Description:  [权限服务实现]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Service
public class PermServiceImpl implements PermService {

    @Resource
    private PermRepository permRepository;

    @Override
    public List<Perm> getPermByUserId(Long userId) {
        return permRepository.findAllByUserId(userId);
    }
}
