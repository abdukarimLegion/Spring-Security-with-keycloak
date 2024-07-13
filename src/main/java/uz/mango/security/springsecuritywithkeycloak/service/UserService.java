package uz.mango.security.springsecuritywithkeycloak.service;


import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import uz.mango.security.springsecuritywithkeycloak.model.User;

import java.util.List;

/**
 * UserService
 *
 * @author Abdukarim
 */

public interface UserService {

    void createUser(User user);

    void sendVerificationEmail(String userId);

    void deleteUser(String userId);

    void forgotPassword(String username);

    UserResource getUser(String userId);

    List<RoleRepresentation> getUserRoles(String userId);

    List<GroupRepresentation> getUserGroups(String userId);

}
