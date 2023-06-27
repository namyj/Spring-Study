package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // [status-line]
        // 응답 코드 설정
        response.setStatus(HttpServletResponse.SC_OK); // 200
        // response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400

        // [response-header]
        response.setHeader("Content-type", "tesxt/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시를 완전히 무효화
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "header"); // 사용자 지정 헤더 생성 가능

        // [Header의 편의 메서드]
        // content(response);
        // cookie(response);
        redirect(response);

        // [message body]
        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }

    // Content 편의 메서드
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2 // 생략 가능, 생략하면 자동으로 Content-Body에 있는 데이터 길이를 계산해서 넣어줌
        
        // 방법1: setHeader()로 직접 설정
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");

        // 방법2
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); // (생략시 자동 생성)
    }

    // 쿠키 편의 메서드
    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");

        // 쿠키 생성 > response 객체에 넣어줌
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); // 쿠키가 600초 동안 유효
        response.addCookie(cookie);
    }

    // redirect 편의 메서드
    private void redirect(HttpServletResponse response) throws IOException {
        // /basic/hello-form.html로 리다이렉트
        //Status Code 302
        //Location: /basic/hello-form.html

        // 방법 1
        response.setStatus(HttpServletResponse.SC_FOUND); //302
        response.setHeader("Location", "/basic/hello-form.html");

        // 방법 2
        // response.sendRedirect("/basic/hello-form.html");
    }
}
