package com.ming.po;

import java.util.Date;
import java.util.List;

public class Orders
{
    //字段和表对应
    private Integer id;

    private Integer userid;

    private String number;

    private Date createtime;

    private String note;

    //一对一演示 使用resultMap
    private User user;

    //一对多演示 使用resultMap
    private List<Orderdetail> orderdetails;




    public List<Orderdetail> getOrderdetails()
    {
        return orderdetails;
    }

    public void setOrderdetails(List<Orderdetail> orderdetails)
    {
        this.orderdetails = orderdetails;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getUserid()
    {
        return userid;
    }

    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public Date getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }
}
