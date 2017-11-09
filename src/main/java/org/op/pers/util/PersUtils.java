package org.op.pers.util;

import java.util.UUID;

public class PersUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
