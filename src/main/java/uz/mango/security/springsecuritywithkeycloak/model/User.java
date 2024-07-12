package uz.mango.security.springsecuritywithkeycloak.model;

public record User(String firstName, String lastName, String email, String username, String password) {

}