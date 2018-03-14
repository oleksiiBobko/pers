package org.op.pers.services.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.op.pers.dao.PersUserDao;
import org.op.pers.entity.misc.PersUser;
import org.op.pers.services.EmpireService;
import org.op.pers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private PersUserDao userDao;

    @Autowired
    private EmpireService empireService;

    @Override
    public PersUser getUser(long id) {
        PersUser u = userDao.findOne(id);
        Hibernate.initialize(u.getEmpires());
        return u;
    }

    @Override
    public PersUser createUser(PersUser u) {
        u.getEmpires().add(empireService.createNewEmpire(u));
        userDao.create(u);
        return u;
    }

    @Override
    public void removeUser(long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<PersUser> getAllUsers() {
        return userDao.findAll();
    }

}
