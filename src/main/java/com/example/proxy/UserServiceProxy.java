package com.example.proxy;

// 실제 클라이언트가 요청한 로직을 수행할 객체인 RealSubject 클래스를 감싼 Proxy

// 프록시는 RealSubject 실제 객체와 동일한 이름의 메서드를 구현해야한다.
// 프록시는 실제 객체의 메서드 호출 전후에 별도의 로직을 수행할 수 있다.
public class UserServiceProxy implements UserService {
    private final UserServiceImpl userService;
    //private final UserService userService;

    public UserServiceProxy() {
        this.userService = new UserServiceImpl();
    }

//    public UserServiceProxy(UserService userService) {
//        this.userService = userService;
//    }

    @Override
    public User findById(Long id) {
        // 실제 객체의 메서드 호출 전 수행 로직 (로깅)
        System.out.println("Method findById called with id: " + id);

        User user = null;

        // 실제 객체의 메서드 호출 전 수행 로직 (유효성 검사) -> 실체 객체에 대한 접근 제어
        if (id != null && String.valueOf(id).length() < 10) {
            // 실제 객체의 메서드 호출
            user = userService.findById(id);
        }
        return user;
    }
}
