package com.ming.po;


/**
 * 	user.username,
 * 	user.sex,
 * 	user.address
 */
public class OrderCustom extends Orders
{

    //将表中多出来的数据放入到Order的扩展类中
    private String username;

    private String sex;

    private String address;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
