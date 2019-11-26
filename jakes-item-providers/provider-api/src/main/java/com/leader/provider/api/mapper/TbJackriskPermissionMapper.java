package com.leader.provider.api.mapper;

import com.leader.provider.api.domain.TbJackriskPermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface TbJackriskPermissionMapper extends MyMapper<TbJackriskPermission> {

    List<TbJackriskPermission> selectByUserID(@Param(value = "userId") Long userId);

}
