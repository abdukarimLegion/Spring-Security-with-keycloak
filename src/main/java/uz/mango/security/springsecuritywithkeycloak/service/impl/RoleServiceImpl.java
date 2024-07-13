package uz.mango.security.springsecuritywithkeycloak.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uz.mango.security.springsecuritywithkeycloak.service.RoleService;
import uz.mango.security.springsecuritywithkeycloak.service.UserService;

import java.util.Collections;

/**
 * RoleServiceImpl
 *
 * @author Abdukarim
 */

@RequiredArgsConstructor
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {


    private final UserService userService;

    @Value("${app.keycloak.realm}")
    private String realm;
    private final Keycloak keycloak;
    @Override
    public void assignRole(String userId, String roleName) {


        UserResource user = userService.getUser(userId);
        RolesResource rolesResource = getRolesResource();
        RoleRepresentation representation = rolesResource.get(roleName).toRepresentation();
        user.roles().realmLevel().add(Collections.singletonList(representation));
    }

    @Override
    public void deleteRoleFromUser(String userId, String roleName) {

        UserResource user = userService.getUser(userId);
        RolesResource rolesResource = getRolesResource();
        RoleRepresentation representation = rolesResource.get(roleName).toRepresentation();
        user.roles().realmLevel().remove(Collections.singletonList(representation));
    }

    private RolesResource getRolesResource(){

        return keycloak.realm(realm).roles();
    }

}
