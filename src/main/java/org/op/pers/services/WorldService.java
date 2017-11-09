package org.op.pers.services;

import org.op.pers.entity.game.Empire;
import org.op.pers.entity.game.World;

public interface WorldService {

    public World createWorld(Empire empire);

    public World getWorld();

}
