package ma.enset.designpatterns.aspect;

import ma.enset.designpatterns.security.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Before("@annotation(secured)")
    public void checkSecurity(JoinPoint jp, Secured secured) {

        User user = SecurityContext.getCurrentUser();

        if (user == null || !user.hasRole(secured.value())) {
            throw new SecurityException(
                    "Accès refusé à : " + jp.getSignature()
            );
        }
    }
}
