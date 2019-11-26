package com.leader.provider.user.server.service.permission;

import com.leader.provider.api.domain.TbJackriskPermission;
import com.leader.provider.api.mapper.TbJackriskPermissionMapper;
import com.leader.provider.api.service.TbJackriskPermissionService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(version = "1.0.0")
public class TbJackriskPermissionServiceImpl implements TbJackriskPermissionService {

    @Resource
    TbJackriskPermissionMapper tbJackriskPermissionMapper;

    @Override
    public List<TbJackriskPermission> selectByUserID(Long userId) {
        return tbJackriskPermissionMapper.selectByUserID(userId);
    }

    @Override
    public List<TbJackriskPermission> selectByAll() {
        return tbJackriskPermissionMapper.selectAll();
    }
}
