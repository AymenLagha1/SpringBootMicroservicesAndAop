package com.example.helloservice.aspects;

import com.example.helloservice.annotations.Supervision;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SupervisionAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Around("@annotation(supervision)")
    public Object superviser(ProceedingJoinPoint joinPoint, Supervision supervision) throws Throwable {
        long maxDuree = supervision.dureeMillis();
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed(joinPoint.getArgs());
        } finally {
            long end = System.currentTimeMillis();
            long duree = end - start;
            if (duree > maxDuree) {
                LOGGER.warn(String.format("Attention l'appel à %s à durée %dms soit %dms de plus qu'attendu%n",
                        joinPoint.toShortString(), duree, duree - maxDuree));
            }
            else {
                LOGGER.info(String.format("l'appel à %s à durée %dms%n",joinPoint.toShortString(), duree));
            }
        }
    }
}
