package uz.mango.security.springsecuritywithkeycloak.service;


/**
 * RoleService
 *
 * @author Abdukarim
 */

public interface RoleService {

    void assignRole(String userId ,String roleName);

    void deleteRoleFromUser(String userId ,String roleName);

}
