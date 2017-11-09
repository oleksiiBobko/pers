package org.op.pers.services.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.op.pers.dao.UserDao;
import org.op.pers.entity.misc.User;
import org.op.pers.services.EmpireService;
import org.op.pers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private EmpireService empireService;

    @Override
    public User getUser(long id) {
        User u = userDao.findOne(id);
        Hibernate.initialize(u.getEmpires());
        return u;
    }

    @Override
    public User createUser(User u) {
        u.getEmpires().add(empireService.createNewEmpire(u));
        userDao.create(u);
        return u;
    }

    @Override
    public void removeUser(long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

}
