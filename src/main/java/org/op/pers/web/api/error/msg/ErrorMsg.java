package org.op.pers.web.api.error.msg;

import lombok.Data;

@Data
public class ErrorMsg {

    private String status;

    public ErrorMsg(String status) {
        this.status = status;
    }

    public ErrorMsg() {
    }

}
