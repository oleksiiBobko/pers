package org.op.pers.services;

import java.util.List;

import org.op.pers.entity.game.Alliance;

public interface AllianceService {

    public List<Alliance> getAlliances();

    public Alliance getAlliance(long valueOf);

}
