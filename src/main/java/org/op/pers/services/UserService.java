package org.op.pers.services;

import java.util.List;

import org.op.pers.entity.misc.PersUser;

public interface UserService {

    public PersUser getUser(long id);

    public PersUser createUser(PersUser name);

    public List<PersUser> getAllUsers();

    public void removeUser(long id);

}
