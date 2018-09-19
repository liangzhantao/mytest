package com.itheima.service;

import com.itheima.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService{


    int save(Users user);
}
