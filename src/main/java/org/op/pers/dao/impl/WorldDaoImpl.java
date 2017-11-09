package org.op.pers.dao.impl;

import org.op.pers.dao.WorldDao;
import org.op.pers.entity.game.World;
import org.springframework.stereotype.Repository;

@Repository
public class WorldDaoImpl  extends AbstractHibernateDao<World> implements WorldDao {

    @Override
    public World getWorld() {
        return findAll().stream().findFirst().orElse(new World());
    }

}
