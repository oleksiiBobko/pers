package org.op.pers.dao;

import org.op.pers.entity.game.World;

public interface WorldDao extends IGenericDao<World> {

    public World getWorld();

}
