package com.example.proxy;

// 실제 수행할 회원 조회 기능이 구현되어 있는 RealSubject
public class UserServiceImpl implements UserService {
    @Override
    public User findById(Long id) {
        // id와 일치하는 회원을 찾아서 반환하는 코드로 가정
        return new User(id, "홍길동", "19991212");
    }
}