package com.petplace.admin.controller;/**
 * packageName    : com.petplace.admin.controller
 * fileName       : AdminPageController
 * author         : jun
 * date           : 2024. 9. 20.
 * description    : 세션id로 관리자페이지 접근 가능 여부 확인 후 포워드
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 20.        jun       최초 생성
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "adminPage", value = "/adminPage")
public class AdminPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nav = Integer.parseInt(request.getParameter("nav"));
        switch (nav) {
            case 1:
                request.getRequestDispatcher("views/admin/adminMainPage.jsp").forward(request, response);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
