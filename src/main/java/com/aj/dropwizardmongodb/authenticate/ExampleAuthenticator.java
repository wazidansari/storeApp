package com.aj.dropwizardmongodb.authenticate;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;

import java.util.Optional;

public class ExampleAuthenticator implements Authenticator<BasicCredentials, AuthUser> {
    @Override
    public Optional<AuthUser> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if ("secret".equals(credentials.getPassword())) {
            return Optional.of(new AuthUser(credentials.getUsername()));
        }
        return Optional.empty();
    }
}