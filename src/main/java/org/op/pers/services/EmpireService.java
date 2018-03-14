package org.op.pers.services;

import java.util.List;

import org.op.pers.entity.game.Empire;
import org.op.pers.entity.misc.PersUser;

public interface EmpireService {

    public Empire createNewEmpire(PersUser user);

    public Empire getEmpire(Long empireId);

    public List<Empire> getEmpires();

}
