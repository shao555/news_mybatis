package com.cs.mapper;

import com.cs.entity.UserInfo;

import java.util.List;

public interface UserInfoMapper {

    //查询用户表所有记录 select * from userinfo
    public List<UserInfo> findAllUserInfo() throws Exception;

}
