package com.leader.consumer.securtiy.oauth2.config.service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.leader.common.exploit.StringUtils;
import com.leader.provider.api.domain.TbJackriskPermission;
import com.leader.provider.api.domain.TbJackriskUser;
import com.leader.provider.api.service.TbJackriskPermissionService;
import com.leader.provider.api.service.TbJackriskUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Configuration
public class UserDetailsServiceimpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceimpl.class);

    @Reference(version = "1.0.0")
    TbJackriskUserService tbJackriskUserService;

    @Reference(version = "1.0.0")
    TbJackriskPermissionService tbJackriskPermissionService;

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "$2a$10$WhCuqmyCsYdqtJvM0/J4seCU.xZQHe2snNE5VFUuBGUZWPbtdl3GG";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbJackriskUser user = tbJackriskUserService.selectByUserName(username);
        if (user == null) return null;
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(grantedAuthority);
        return new User(USERNAME, PASSWORD, grantedAuthorities);
    }

}
