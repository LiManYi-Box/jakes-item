package com.leader.consumer.user.port.service;

import com.leader.common.exploit.StringUtils;
import com.leader.provider.api.domain.TbJackriskUser;
import com.leader.provider.api.service.TbJackriskUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Reference(version = "1.0.0")
    TbJackriskUserService tbJackriskUserService;

    public List<TbJackriskUser> selectUserAll(){
        List<TbJackriskUser> users = tbJackriskUserService.selectByAll();
        users.forEach(user->{
            user.setPassword(StringUtils.toUUIDConceal(user.getPassword()));
        });
        return users;
    }

}
