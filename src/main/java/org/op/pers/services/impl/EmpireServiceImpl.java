package org.op.pers.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.op.pers.dao.EmpireDao;
import org.op.pers.entity.game.Empire;
import org.op.pers.entity.game.resources.Food;
import org.op.pers.entity.game.resources.Gold;
import org.op.pers.entity.game.resources.Stone;
import org.op.pers.entity.game.resources.Wood;
import org.op.pers.entity.misc.User;
import org.op.pers.services.EmpireService;
import org.op.pers.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmpireServiceImpl implements EmpireService {

    @Autowired
    private EmpireDao empireDao;

    @Autowired
    private WorldService worldService;

    @Override
    public Empire createNewEmpire(User user) {
        Empire empire = new Empire();
        empire.setUser(user);
        Wood w = new Wood();
        w.setAmount(100L);
        w.setEmpire(empire);
        empire.setWood(w);

        Food f = new Food();
        f.setAmount(100L);
        f.setEmpire(empire);
        empire.setFood(f);

        Gold g = new Gold();
        g.setAmount(100L);
        g.setEmpire(empire);
        empire.setGold(g);

        Stone s = new Stone();
        s.setAmount(100L);
        s.setEmpire(empire);
        empire.setStone(s);
        empire.setWorld(worldService.createWorld(empire));
        empireDao.create(empire);
        return empire;
    }

    @Override
    public Empire getEmpire(Long empireId) {
        return empireDao.findOne(empireId);
    }

    @Override
    public List<Empire> getEmpires() {
        return empireDao.findAll();
    }



}
