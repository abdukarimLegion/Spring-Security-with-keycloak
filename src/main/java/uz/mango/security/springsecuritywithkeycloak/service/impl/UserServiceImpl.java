package uz.mango.security.springsecuritywithkeycloak.service.impl;

import jakarta.ws.rs.core.Response;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uz.mango.security.springsecuritywithkeycloak.config.KeycloakConfig;
import uz.mango.security.springsecuritywithkeycloak.model.User;
import uz.mango.security.springsecuritywithkeycloak.service.UserService;

import java.util.List;
import java.util.Objects;

/**
 * OAuth's resource configuration.
 *
 * @author Abdukarim
 */

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Value("${app.keycloak.realm}")
    String realm;

    @Autowired
    private KeycloakConfig keycloakConfig;

    @Override
    public void createUser(User user) {

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEnabled(true);
        userRepresentation.setFirstName(user.firstName());
        userRepresentation.setLastName(user.lastName());
        userRepresentation.setUsername(user.username());
        userRepresentation.setEmail(user.email());
        userRepresentation.setEmailVerified(false);


        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();

        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(user.password());

        userRepresentation.setCredentials(List.of(credentialRepresentation));


        UsersResource userResource = getUserResource();
        Response response = userResource.create(userRepresentation);

        log.info("Status code {}", response.getStatus());

        if (!Objects.equals(201, response.getStatus())) {

            throw new RuntimeException("Status code " + response.getStatus());
        }

        log.info("New user created");

    }

    private UsersResource getUserResource() {

        return keycloakConfig.keycloak().realm(realm).users();

    }

}
