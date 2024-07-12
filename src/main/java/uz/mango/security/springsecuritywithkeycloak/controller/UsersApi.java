package uz.mango.security.springsecuritywithkeycloak.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.mango.security.springsecuritywithkeycloak.model.User;
import uz.mango.security.springsecuritywithkeycloak.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersApi {

    private final UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {

        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
