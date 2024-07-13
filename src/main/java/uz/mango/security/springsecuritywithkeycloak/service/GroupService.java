package uz.mango.security.springsecuritywithkeycloak.service;


/**
 * GroupService
 *
 * @author Abdukarim
 */

public interface GroupService {

    void assignGroup(String userId ,String groupId);

    void deleteGroupFromUser(String userId ,String groupId);

}
