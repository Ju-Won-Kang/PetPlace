package com.petplace.member.controller;/**
 * packageName    : com.petplace.member.controller
 * fileName       : MemberEnrollFormController
 * author         : jun
 * date           : 2024. 10. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 10. 7.        jun       최초 생성
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "enrollForm.me", value = "/enrollForm.me")
public class MemberEnrollFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String termsAgree = request.getParameter("termsAgree");
        String privacyAgree = request.getParameter("privacyAgree");

        // 약관 동의를 확인 후 회원가입 페이지로 이동
        if (termsAgree != null && privacyAgree != null) {
            // 회원가입 페이지를 포워딩(절대 경로로 지정)
            request.getRequestDispatcher("views/member/memberEnrollForm.jsp").forward(request,response);
        } else {
            // 약관 동의 페이지로 다시 리다이렉트
            response.sendRedirect(request.getContextPath() + "/termsForm.me");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
