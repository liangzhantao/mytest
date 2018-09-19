package com.itheima.dao;

import com.itheima.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface IUserDao {
    @Select("select * from users where username=#{username}")
    Users findByUsername(String username);

    @Insert("insert into users values(null,#{username},#{password},#{telephone},#{state})")
    int save(Users user);
}
