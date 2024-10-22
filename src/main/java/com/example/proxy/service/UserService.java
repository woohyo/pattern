package com.example.proxy.service;

import org.springframework.stereotype.Service;

// 로깅을 위한 로직이 AOP 어드바이스로 분리되어 있어서, 서비스 클래스는 오직 본연의 비즈니스 로직만을 담당할 수 있다.
// 즉, AOP를 통해 프록시 기능을 분리하여 각 클래스가 하나의 책임만 가지도록 함.
@Service
public class UserService {

    public String getUserById(Long id) {
        // 실제 비즈니스 로직
        hi();
        return "User with ID: " + id;
    }

    public void hi() {
       System.out.println("hi test");
    }
}
