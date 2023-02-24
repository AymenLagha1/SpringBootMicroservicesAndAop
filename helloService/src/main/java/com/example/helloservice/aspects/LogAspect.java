package com.example.helloservice.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Before("execution(public * com.example.helloservice.services.*Service.*(..))")
    public void log(JoinPoint joinPoint) {

        LOGGER.info(String.format("Appel de %s avec %d paramètres%n",
                joinPoint.toShortString(),
                joinPoint.getArgs().length));
    }
}


