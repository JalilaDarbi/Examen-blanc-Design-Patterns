package ma.enset.designpatterns.aspect;

import ma.enset.designpatterns.security.User;

public class SecurityContext {

    private static User currenUser;

    public static void login(User user) {
        currenUser = user;
    }

    public static User getCurrentUser() {
        return currenUser;
    }


}
