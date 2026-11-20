package tn.esprit.autoloc.Config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* tn.esprit.autoloc.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] parameters = joinPoint.getArgs();
        log.info("Before - Methode appelée : {} | Paramètres : {}", methodName, Arrays.toString(parameters));
    }

    @After("execution(* tn.esprit.autoloc.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("After - Methode terminée : {}", joinPoint.getSignature().getName());
    }
}
