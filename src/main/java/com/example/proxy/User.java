package com.example.proxy;

// 회원 정보 관리 클래스
public class User {
    private Long id;
    private String name;
    private String birth;

    public User(Long id, String name, String birth) {
        this.id = id;
        this.name = name;
        this.birth =birth;
    }


    public String getUserInfo() {
        return "name: " +this.name + ", birth: " + this.birth;
    }

}