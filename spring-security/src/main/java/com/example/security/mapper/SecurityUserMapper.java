package com.example.security.mapper;

import com.example.security.domain.SecurityUser;

public interface SecurityUserMapper {
    int deleteByPrimaryKey(String uid);

    int insert(SecurityUser record);

    int insertSelective(SecurityUser record);

    SecurityUser selectByPrimaryKey(String uid);
    
    // 根据需要手动添加，重新生成时被覆盖
    SecurityUser selectByUserName(String username);

    int updateByPrimaryKeySelective(SecurityUser record);

    int updateByPrimaryKey(SecurityUser record);
}