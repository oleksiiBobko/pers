package org.op.pers.web.api.admin;

import java.util.List;

import org.op.pers.entity.game.Alliance;
import org.op.pers.entity.game.Empire;
import org.op.pers.entity.game.World;
import org.op.pers.entity.misc.User;
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
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        userService.createUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(path = { "/user/{userId}" }, method = RequestMethod.GET)
    public User getUserById(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        log.info("Updating User " + id);
          
        User currentUser = userService.getUser(id);
          
        if (currentUser==null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
  
//        currentUser.setUsername(user.getUsername());
//        currentUser.setAddress(user.getAddress());
//        currentUser.setEmail(user.getEmail());
//          
//        userService. updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String removeUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

   @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
//        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
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
