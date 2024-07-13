package uz.mango.security.springsecuritywithkeycloak.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mango.security.springsecuritywithkeycloak.model.User;
import uz.mango.security.springsecuritywithkeycloak.service.UserService;

/**
 * UsersApi
 *
 * @author Abdukarim
 */

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

    @PutMapping("/{id}/send-verification-email")
    public ResponseEntity<?> sendVerificationEmail(@PathVariable String id) {
        userService.sendVerificationEmail(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
