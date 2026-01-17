package ma.enset.designpatterns.aspect;

import ma.enset.designpatterns.security.Role;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Secured {
    Role value();


    }

