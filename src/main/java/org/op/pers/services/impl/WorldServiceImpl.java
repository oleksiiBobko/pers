package org.op.pers.services.impl;

import javax.transaction.Transactional;

import org.op.pers.dao.WorldDao;
import org.op.pers.entity.game.Empire;
import org.op.pers.entity.game.World;
import org.op.pers.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class WorldServiceImpl implements WorldService {

    @Autowired
    private WorldDao worldDao;

    @Override
    public World createWorld(Empire empire) {
        World w = worldDao.getWorld();
        if (w.getWorldId() == 0) {
            w.setHeight(1000);
            w.setWidth(1000);
            w.setName("default");
            w.getEmpires().add(empire);
            worldDao.create(w);
        }
        return w;
    }

    @Override
    public World getWorld() {
        return worldDao.getWorld();
    }

}
