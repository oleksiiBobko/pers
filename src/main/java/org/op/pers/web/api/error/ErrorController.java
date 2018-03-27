package org.op.pers.web.api.error;

import org.op.pers.web.api.error.msg.ErrorMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @RequestMapping(value = "/notfound", method = RequestMethod.GET)
    public ResponseEntity<ErrorMsg> notfound() {
        return new ResponseEntity<>(new ErrorMsg("not found") ,HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public ResponseEntity<ErrorMsg> unauthorized() {
        return new ResponseEntity<>(new ErrorMsg("unauthorized") ,HttpStatus.UNAUTHORIZED);
    }

}
