package tn.esprit.autoloc.Config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* tn.esprit.autoloc.service.*.*(..))")
    public Object mesurerTemps(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long duree = System.currentTimeMillis() - start;
        String methodName = pjp.getSignature().getName();
        log.info("Performance - {} exécutée en {} ms", methodName, duree);
        if (duree > 1000) {
            log.warn("ATTENTION - {} est lente : {} ms", methodName, duree);
        }
        return result;
    }
}
