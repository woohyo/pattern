package com.example.proxy;


// 고수준 모듈(클라이언트 요청시 비즈니스 로직을 수행하는 클래스로 가정)
public class UserApplication {

    private UserService userService;

    // 고수준 모듈은 추상화에 의존 -> 해당 코드에서는 필요없는 코드, 유연한 구조 예시용
    public UserApplication(UserService userService) {
        this.userService = userService;
    }

    // 클라이언트가 id로 회원정보를 조회하기 위해 UserServiceProxy 클래스를 접근하고 있다.
    // 클라이언트 입장에서 요청이 UserServiceImpl에 접근하는지, 아니면 UserServiceProxy에 접근하는지 알 수 없다.
    public static void main(String[] args) {
        UserService userService = new UserServiceProxy();
        // 저수준 모듈(main)은 추상화에 의존.
        // UserServiceProxy(구현체)는 UserService(추상화) 인터페이스에 의존하므로, UserService의 다양한 구현체를 주입받아 사용할 수 있다.
        // 예를 들어, 새로운 UserService 구현체를 생성하여 반영하고자 할 때, 기존 코드를 변경할 필요 없이 UserServiceImpl 대신 새 구현체를 주입하기만 하면 된다.
//        UserService userService = new UserServiceProxy(new UserServiceImpl());

        User user = userService.findById(3726L);
        System.out.println(user.getUserInfo());

    }
}
