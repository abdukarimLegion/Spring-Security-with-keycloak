package uz.mango.security.springsecuritywithkeycloak.model;


/**
 * User model
 *
 * @author Abdukarim
 */


public record User(String firstName, String lastName, String email, String username, String password) {

}