package com.leader.provider.user.server.service.user;

import com.leader.provider.api.domain.TbJackriskUser;
import com.leader.provider.api.mapper.TbJackriskUserMapper;
import com.leader.provider.api.service.TbJackriskUserService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service(version = "1.0.0")
public class TbJackriskUserServiceimpl implements TbJackriskUserService {

    @Resource
    TbJackriskUserMapper tbJackriskUserMapper;


    @Override
    public List<TbJackriskUser> selectByAll() {
        return tbJackriskUserMapper.selectAll();
    }

    @Override
    public TbJackriskUser selectByUserName(String username) {
        Example example = new Example(TbJackriskUser.class);
        example.createCriteria().andEqualTo("username",username);
        return tbJackriskUserMapper.selectOneByExample(example);
    }
}
