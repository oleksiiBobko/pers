package org.op.pers.factory;

import org.op.pers.entity.game.Empire;

public class EmpireAbstractFactory {

    public static Empire getEmpire() {
        return new Empire();
    }

}
