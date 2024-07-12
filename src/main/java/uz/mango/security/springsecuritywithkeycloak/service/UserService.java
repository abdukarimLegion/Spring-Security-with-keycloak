package uz.mango.security.springsecuritywithkeycloak.service;


import uz.mango.security.springsecuritywithkeycloak.model.User;

/**
 * OAuth's resource configuration.
 *
 * @author Abdukarim
 */

public interface UserService {

    void createUser(User user);

}
