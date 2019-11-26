package com.leader.consumer.user.port.controller;

import com.leader.common.web.ResponseResult;
import com.leader.common.web.ResultUtil;
import com.leader.provider.api.domain.TbJackriskUser;
import com.leader.provider.api.service.TbJackriskUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserServerController {

    @Reference(version = "1.0.0")
    TbJackriskUserService tbJackriskUserService;

    @GetMapping(value = "/user/list")
    public ResponseResult<List<TbJackriskUser>> toUserAll(){
        return new ResultUtil().success(tbJackriskUserService.selectByAll());
    }

}
