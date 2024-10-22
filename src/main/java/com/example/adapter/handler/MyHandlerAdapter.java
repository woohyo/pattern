package com.example.adapter.handler;

import com.example.adapter.controller.MyController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

// HandlerAdapter
// 스프링 MVC는 다양한 형태의 컨트롤를 일관되게 처리하기 위해 HandlerAdapter라는 어댑터를 사용한다.
// 각 컨트롤러에 맞는 어댑터가 중간에서 적절히 변환해주기 때문에, 클라이언트는 다양한 컨트롤러의 내부 구현을 신경 쓰지 않고도 동일한 방식으로 요청을 처리할 수 있다.



// 어댑터 역할을 하는 MyHandlerAdapter 클래스
// 여기서 MyHandlerAdapter는 스프링이 요청을 처리할 때 MyController를 대신 호출해주는 역할을 한다.

// 순서2: 핸들러(컨트롤러)가 결정되면, 스프링은 해당 핸들러를 실행할 수 있는 적합한 HandlerAdapter를 찾는다.
// (모든 등록된 HandlerAdapter를 순차적으로 조회하면서, 각각의 HandlerAdapter에 대해 supports() 메서드를 호출.
//  이 메서드가 true를 반환하는 경우, 해당 HandlerAdapter가 선택)
public class MyHandlerAdapter implements HandlerAdapter {


    // supports 메서드는 MyHandlerAdapter가 특정 핸들러(컨트롤러)를 처리할 수 있는지 여부를 확인한다.
    // 여기서는 MyController 타입의 핸들러만 처리할 수 있음. -> MyController의 인스턴스가 들어오면 true를 반환
    @Override
    public boolean supports(Object handler) {
        return handler instanceof MyController;
    }

    // handle 메서드는 실제로 컨트롤러의 메서드를 호출하여 요청을 처리하는 곳이다.
    // 스프링은 handle() 메서드를 통해 MyController의 handleRequest() 메서드를 호출하고, 그 결과를 ModelAndView에 담아 반환한다.
    // 순서3: 적합한 HandlerAdapter가 선택된 후, handle() 메서드가 호출되어 해당 핸들러(컨트롤러)를 실행하고, 컨트롤러의 메서드가 호출되어 응답을 반환하는 것.
    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MyController controller = (MyController) handler;
        String result = controller.handleRequest();
        return new ModelAndView("viewName", "data", result);
    }

    @Override
    public long getLastModified(HttpServletRequest request, Object handler) {
        return -1;
    }
}