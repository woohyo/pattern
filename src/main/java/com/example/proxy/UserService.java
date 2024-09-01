package com.example.proxy;

// 클라이언트가 접근할 Subject (하지만 실제로 접근하는 객체는 RealSubject)
public interface UserService {
    User findById(Long id);
}

