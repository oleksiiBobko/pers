package org.op.pers.services;

import java.util.List;

import org.op.pers.entity.misc.User;

public interface UserService {

    public User getUser(long id);

    public User createUser(User name);

    public List<User> getAllUsers();

    public void removeUser(long id);

}
