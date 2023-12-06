package com.dev.services;

import com.dev.models.Privilege;
import com.dev.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserPrincipal implements UserDetails {

    private User user;

    public CustomUserPrincipal(User user) {
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
        if (user.getPrivileges() == null)
            return authorities;
        for (Privilege privilege : user.getPrivileges())
            authorities.add(new SimpleGrantedAuthority(privilege.getPrivilageName()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail(); // email is the username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
