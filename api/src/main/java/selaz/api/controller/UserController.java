package selaz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import selaz.api.dto.UserDTO;
import selaz.api.entity.user.User;
import selaz.api.service.UserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User newUser = userService.createUser(userDTO);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser/{useId}")
    public ResponseEntity<User> updateUser(
            @PathVariable("useId") Long useId, @RequestBody UserDTO userDTO
    ) throws Exception {
        User attUser = userService.updateUser(useId, userDTO);

        return new ResponseEntity<>(attUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{useId}")
    public ResponseEntity<User> deleteUser(@PathVariable("useId") Long useId)  throws Exception {
        userService.deleteUser(useId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
