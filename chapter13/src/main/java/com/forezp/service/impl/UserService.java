package com.forezp.service.impl;

import com.forezp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by fangzhipeng on 2017/5/10.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       //1.jpa
        return userRepository.findByUsername(username);
        /*2.mybatis
            1.自定义CustomUserService实现UserDetailsService接口，重写loadUserByUsername方法
            2.生成用户权限集合List<SimpleGrantedAuthority> authorities
            3.生成spring自带的UserDetails
            new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);
         */
    }
}
