package com.example.helloservice.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SupervisionServiceAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Around("execution(public * com.example.helloservice.services.*Service.*(..))")
    public Object superviser(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed(joinPoint.getArgs());
        } finally {
            long end = System.currentTimeMillis();
            long duree = end - start;
            LOGGER.info(String.format("l'appel à %s à durée %dms%n",joinPoint.toShortString(), duree));
        }
    }
}
