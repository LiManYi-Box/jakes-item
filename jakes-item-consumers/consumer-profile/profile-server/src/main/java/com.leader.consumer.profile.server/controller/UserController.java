package com.leader.consumer.profile.server.controller;

import com.leader.common.web.ResponseResult;
import com.leader.common.web.ResultUtil;
import com.leader.provider.api.domain.TbJackriskUser;
import com.leader.provider.api.service.TbJackriskUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "profile")
public class UserController {

    @Reference
    TbJackriskUserService tbJackriskUserService;

    @GetMapping(value = "/user/list")
    public ResponseResult<List<TbJackriskUser>> toUsers(){
        return ResultUtil.success(tbJackriskUserService.selectByAll());
    }

}
