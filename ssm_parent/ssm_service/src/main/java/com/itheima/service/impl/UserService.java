package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.entity.Users;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UserService")
public class UserService implements IUserService{
    @Autowired
    private IUserDao userDao;


    public int save(Users user) {
        return userDao.save(user);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        Users User = userDao.findByUsername(username);
        User user = new User(username,"{noop}"+User.getPassword(),authorities);
        return user;
    }
}
