package com.example.adapter.controller;

import org.springframework.stereotype.Controller;


// 스프링의 컨트롤러 역할을 하는 클래스
// 스프링에서는 이 컨트롤러가 직접 호출되지 않고, 어댑터를 통해 호출된다.(어댑터 패턴이 자연스럽게 적용)
// 순서1: 클라이언트가 특정 URL로 요청을 보내면 스프링은 해당 요청에 매핑되는 핸들러(컨트롤러)를 찾는다.
@Controller
public class MyController {

    // 클라이언트의 요청을 처리하는 메서드
    // 스프링 MVC에서 해당 컨트롤러가 선택되면 이 메서드가 호출된다.
    public String handleRequest() {
        return "Handled by MyController";
    }
}