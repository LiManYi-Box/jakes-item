package com.leader.provider.api.service;

import com.leader.provider.api.domain.TbJackriskPermission;

import java.util.List;

public interface TbJackriskPermissionService{

    List<TbJackriskPermission> selectByUserID(Long userId);

    List<TbJackriskPermission> selectByAll();

}
