package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequesetParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[ 전체 파라미터 조회 ] - start");

        // request.getParameterNames()
        // request.getParameter(paramName)
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        System.out.println("[ 전체 파라미터 조회 ] - start");

        System.out.println("[ 단일 파라미터 조회 ] - start");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("age = " + age);
        System.out.println("username = " + username);
        System.out.println("[ 단일 파라미터 조회 ] - end");

        // 한 파라미터에 여러 값을 전달할 수 있음 > request.getParameter(paramName)는 먼저 잡히는 값을 출력
        System.out.println("[ 이름이 같은 복수 파라미터 조회 ]");
        String[] usernames = request.getParameterValues("username");
        // 단축키 iter > 반복문 생성
        for (String name : usernames) {
            System.out.println("username = " + name);
        }

        response.getWriter().write("OK");

    }
}
