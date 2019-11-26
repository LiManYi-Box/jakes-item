package com.leader.provider.api.service;

import com.leader.provider.api.domain.TbJackriskUser;

import java.util.List;

public interface TbJackriskUserService {

    List<TbJackriskUser> selectByAll();

    TbJackriskUser selectByUserName(String username);

}

