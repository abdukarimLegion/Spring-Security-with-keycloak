package uz.mango.security.springsecuritywithkeycloak.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RBACApi
 *
 * @author Abdukarim
 */

@RestController
@RequestMapping("/rbac")
@RequiredArgsConstructor
public class RBACApi {

    @GetMapping("merge-role")
    @PreAuthorize("hasAnyRole('MERGE')")
    public ResponseEntity<?> testForMergeRole() {


        System.out.println("SOMETHING ");
        return ResponseEntity.status(HttpStatus.OK).body("I HAVE ACCESS to MERGE ROLE");
    }

}
