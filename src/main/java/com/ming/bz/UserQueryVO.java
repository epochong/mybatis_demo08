package com.ming.bz;

import com.ming.po.UserCustom;

import java.util.List;

/*
*   包装类
* */
public class UserQueryVO
{

    //应对多个id
    private List<Integer> ids;

    //包装用户的查询条件
    private UserCustom userCustom;//这个是扩展类

    public List<Integer> getIds()
    {
        return ids;
    }

    public void setIds(List<Integer> ids)
    {
        this.ids = ids;
    }


    public UserCustom getUserCustom()
    {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom)
    {
        this.userCustom = userCustom;
    }
}
