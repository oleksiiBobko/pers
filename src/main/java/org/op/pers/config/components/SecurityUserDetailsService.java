package org.op.pers.config.components;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.op.pers.dao.PersUserDao;
import org.op.pers.entity.misc.PersUser;
import org.op.pers.entity.misc.PersUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("persUserDetailsService")
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private PersUserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) {

        PersUser user = userDao.findByUserName(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());

        return buildUserForAuthentication(user, authorities);

    }

    private User buildUserForAuthentication(PersUser user, List<GrantedAuthority> authorities) {
        return new User(user.getLogin(), user.getPassword(), user.isActive(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<PersUserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        for (PersUserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<>(setAuths);

    }

}
