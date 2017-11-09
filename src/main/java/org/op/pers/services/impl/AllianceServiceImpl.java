package org.op.pers.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.op.pers.dao.AllianceDao;
import org.op.pers.entity.game.Alliance;
import org.op.pers.services.AllianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AllianceServiceImpl implements AllianceService {

    @Autowired
    private AllianceDao allianceDao;

    @Override
    public List<Alliance> getAlliances() {
        List<Alliance> alliances = allianceDao.findAll();
        alliances.stream().forEach(a -> Hibernate.initialize(a.getEmpires()));
        return alliances;
    }

    @Override
    public Alliance getAlliance(long id) {
        return allianceDao.findOne(id);
    }

}
