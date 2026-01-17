package ma.enset.designpatterns.security;

import java.util.Set;

public class User {

    private String username;
    private String password;
    private Set<Role> roles;

    public User(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public boolean hasRole(Role role) {
        return roles.contains(role);
    }
}
