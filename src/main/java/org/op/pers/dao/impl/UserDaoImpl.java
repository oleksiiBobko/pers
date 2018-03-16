package org.op.pers.dao.impl;

import java.util.List;

import org.op.pers.dao.PersUserDao;
import org.op.pers.entity.misc.PersUser;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractHibernateDao<PersUser> implements PersUserDao {

    @SuppressWarnings("unchecked")
    public PersUser findByUserName(String username) {
        List<PersUser> users = sessionFactory
            .getCurrentSession()
            .createQuery("from PersUser where name=?")
            .setParameter(0, username)
            .list();

        if (users != null && !users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }

    }

}
