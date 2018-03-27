package org.op.pers.web.api.game;

import javax.servlet.http.HttpServletResponse;

import org.op.pers.entity.game.Empire;
import org.op.pers.entity.game.resources.Gold;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersController {

    Empire e = new Empire();

    long lastRequest;

    @GetMapping("/empire")
    public ResponseEntity<Empire> getEmpire(HttpServletResponse response) {
        long currentTime = System.currentTimeMillis();
        if (lastRequest + 5000 < currentTime) {
            e.setName(String.valueOf(currentTime));
            lastRequest = currentTime;
        }

        e.setGold(new Gold());

        response.setHeader("Cache-Control", "");
        return ResponseEntity.ok(e);
    }

}
