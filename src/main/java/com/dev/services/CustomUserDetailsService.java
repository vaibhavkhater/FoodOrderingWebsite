package com.dev.services;

import com.dev.dao.UserJdbcDao;
import com.dev.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private UserJdbcDao userJdbcDao;

    @Autowired
    public CustomUserDetailsService(UserJdbcDao userJdbcDao) {
        this.userJdbcDao = userJdbcDao;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userJdbcDao.getUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        return new CustomUserPrincipal(user);
    }
}
