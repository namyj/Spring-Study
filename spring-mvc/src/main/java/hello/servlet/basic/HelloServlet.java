package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // 서블릿이 호출되면 service() 메서드 실행 됨
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // soutm = 메소드 명 출력 단축키
        System.out.println("HelloServlet.service");
        // soutv = 매개변수 출력 단축키
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // 쿼리 파라미터 조회
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 응답 메시지 보내기
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username); // response body에 작성
    }
}
