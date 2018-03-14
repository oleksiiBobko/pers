package org.op.pers.web.api.admin;

import java.util.List;

import org.op.pers.entity.game.Alliance;
import org.op.pers.entity.game.Empire;
import org.op.pers.entity.game.World;
import org.op.pers.entity.misc.PersUser;
import org.op.pers.services.AllianceService;
import org.op.pers.services.EmpireService;
import org.op.pers.services.UserService;
import org.op.pers.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private WorldService worldService;

    @Autowired
    private EmpireService empireService;

    @Autowired
    private AllianceService allianceService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<PersUser>> getAllUsers() {
        List<PersUser> users = userService.getAllUsers();
        return new ResponseEntity<List<PersUser>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody PersUser user, UriComponentsBuilder ucBuilder) {
        userService.createUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(path = { "/user/{userId}" }, method = RequestMethod.GET)
    public PersUser getUserById(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PersUser> updateUser(@PathVariable("id") long id, @RequestBody PersUser user) {
        log.info("Updating PersUser " + id);
          
        PersUser currentPersUser = userService.getUser(id);
          
        if (currentPersUser==null) {
            return new ResponseEntity<PersUser>(HttpStatus.NOT_FOUND);
        }
  
//        currentPersUser.setPersUsername(user.getPersUsername());
//        currentPersUser.setAddress(user.getAddress());
//        currentPersUser.setEmail(user.getEmail());
//          
//        userService. updatePersUser(currentPersUser);
        return new ResponseEntity<PersUser>(currentPersUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String removeUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

   @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<PersUser> deleteAllPersUsers() {
//        userService.deleteAllPersUsers();
        return new ResponseEntity<PersUser>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = { "/empire/{empireId}" }, method = RequestMethod.GET)
    public Empire getEmpire(@PathVariable Long empireId) {
        return empireService.getEmpire(empireId);
    }

    @RequestMapping(path = { "/world" }, method = RequestMethod.GET)
    public World getWorld() {
        return worldService.getWorld();
    }

    @RequestMapping(path = { "/alliances" }, method = RequestMethod.GET)
    public List<Alliance> getAlliance() {
        return allianceService.getAlliances();
    }

    @RequestMapping(path = { "/empires" }, method = RequestMethod.GET)
    public List<Empire> getEmpire() {
        return empireService.getEmpires();
    }

}
