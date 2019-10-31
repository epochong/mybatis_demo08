package com.ming.mapper;

import com.ming.bz.UserQueryVO;
import com.ming.po.User;
import com.ming.po.UserCustom;

import java.util.List;

public interface UserMapper
{

    public User findUserById(int id) throws Exception;

    public User findUserByIdResultMap(int id) throws Exception;


    public List<User> findUserByName(String name) throws Exception;

    public void insertUser(User user) throws Exception;

    public void deleteUser(int id) throws Exception;

    public void updateUser(User user) throws Exception;

    //用户信息的综合查询
    public List<UserCustom> findUserByListZH(UserQueryVO userQueryVO) throws Exception;

    //用户信息的综合查询总数
    public int findUserCount(UserQueryVO userQueryVO) throws Exception;

}
