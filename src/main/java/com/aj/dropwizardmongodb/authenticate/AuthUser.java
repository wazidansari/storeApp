package com.aj.dropwizardmongodb.authenticate;

import javax.validation.constraints.NotEmpty;
import java.security.Principal;

public class AuthUser implements Principal {

    @NotEmpty
    private String username;

    public AuthUser(String username) {
        this.username=username;
    }

    @Override
    public String getName() {
        return username;
    }

}
