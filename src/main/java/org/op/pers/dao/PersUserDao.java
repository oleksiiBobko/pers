package org.op.pers.dao;

import org.op.pers.entity.misc.PersUser;

public interface PersUserDao extends IGenericDao<PersUser> {

    public PersUser findByUserName(String name);

}
