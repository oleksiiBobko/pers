package org.op.pers.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.op.pers.dao.PersUserDao;
import org.op.pers.entity.misc.PersUser;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractHibernateDao<PersUser> implements PersUserDao {

    @SuppressWarnings("unchecked")
    public PersUser findByUserName(String username) {

        List<PersUser> users = new ArrayList<PersUser>();

        users = sessionFactory
            .getCurrentSession()
            .createQuery("from User where username=?")
            .setParameter(0, username)
            .list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

}
