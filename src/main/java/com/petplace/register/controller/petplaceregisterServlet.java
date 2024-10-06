package com.petplace.register.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register.do") // 여기서는 name 없이 urlPatterns에 직접 경로만 사용합니다.
public class petplaceregisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public petplaceregisterServlet() {
        super();
    }

    // POST 요청이 왔을 때, 약관 동의 여부를 확인 후 처리
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String termsAgree = request.getParameter("termsAgree");
        String privacyAgree = request.getParameter("privacyAgree");

        // 약관 동의를 확인 후 회원가입 페이지로 이동
        if (termsAgree != null && privacyAgree != null) {
            // 회원가입 페이지를 포워딩(절대 경로로 지정) 
        	request.getRequestDispatcher("views/register/register.jsp").forward(request, response);
        } else {
            // 약관 동의 페이지로 다시 리다이렉트
            response.sendRedirect(request.getContextPath() + "/termsAgree.do");
        }
    }

    // GET 요청이 왔을 때, register.jsp로 포워드
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // register.jsp로 포워드 (정적 페이지로 요청을 넘겨 줌)
        request.getRequestDispatcher("views/register/register.jsp").forward(request, response);
    }
}
