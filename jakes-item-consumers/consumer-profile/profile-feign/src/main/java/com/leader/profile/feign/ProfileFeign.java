package com.leader.profile.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "profile-server",path = "profile")
public interface ProfileFeign {

    @GetMapping(value = "/user/list")
    String toUsers();

}
