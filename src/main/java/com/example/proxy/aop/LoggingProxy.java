package com.example.proxy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import java.util.*;

// 스프링 적용 예제 : Spring AOP를 통해 스마트 프록시 패턴 구현

// AOP(관점지향 프로그래밍:Aspect-Oriented Programming)는 비즈니스 로직(주된 관심사)과 보조적인 기능(횡단 관심사)을 분리함으로써 단일 책임 원칙을 지키는 데 큰 역할을 함.
// 로깅, 보안, 트랜잭션 관리, 성능 모니터링 등 애플리케이션의 여러 부분에 걸쳐 나타나는 공통적인 기능이나 로직(횡단 관심사)를 모듈화하여 코드의 중복을 줄이는 데 유용함.

// LoggingProxy => 메소드 호출 전에 메소드 이름과 매개변수를 로그로 남기거나, 메소드 호출 후에 결과값을 로그로 남기는 역할을 한다.
@Aspect
@Component
public class LoggingProxy {

    // 서비스단의 메소드 실행 전에 로깅
    @Before("execution(* com.example.proxy.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) { // 실행되는 메서드의 정보
        // 메소드 이름과 인자들을 로그로 남김
        System.out.println("Method called: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    // 서비스단의 메소드 실행 후에 로깅
    @AfterReturning(pointcut = "execution(* com.example.proxy.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        // 메소드 이름과 반환값을 로그로 남김
        System.out.println("Method returned: " + joinPoint.getSignature().getName());
        System.out.println("Result: " + result);
    }
}



