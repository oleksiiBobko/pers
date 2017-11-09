package org.op.pers.dao.impl;

import org.op.pers.dao.UserDao;
import org.op.pers.entity.misc.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractHibernateDao<User> implements UserDao {

}
