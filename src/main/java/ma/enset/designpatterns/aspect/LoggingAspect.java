package ma.enset.designpatterns.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(ma.enset.dessin.aspect.Loggable)")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();
        System.out.println("➡️ Début : " + pjp.getSignature());

        Object result = pjp.proceed();

        long end = System.currentTimeMillis();
        System.out.println("⬅️ Fin : " + pjp.getSignature()
                + " | Durée = " + (end - start) + " ms");

        return result;
    }
}
