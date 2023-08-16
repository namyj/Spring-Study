package hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 회원 생성, 회원 호출, 회원 목록 조회 contoller 를 각각 만들 것 > 이 인터페이스를 구현해서
// 그러면 front controller는 각 컨트롤러로 인터페이스를 통해서 쉽게 접근이 가능하기 때문
public interface ControllerV1 {

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
