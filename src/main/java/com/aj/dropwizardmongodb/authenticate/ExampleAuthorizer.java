package com.aj.dropwizardmongodb.authenticate;

import io.dropwizard.auth.Authorizer;

public class ExampleAuthorizer implements Authorizer<AuthUser> {
    @Override
    public boolean authorize(AuthUser user, String role) {
        return role.equals("ADMIN");
    }
}
