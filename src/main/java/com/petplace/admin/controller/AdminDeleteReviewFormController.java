package com.petplace.admin.controller;/**
 * packageName    : com.petplace.admin.controller
 * fileName       : AdminDeleteReviewController
 * author         : jun
 * date           : 2024. 9. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 24.        jun       최초 생성
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "adminDeleteReview.re", value = "/adminDeleteReview.re")
public class AdminDeleteReviewFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("nav",4);
        request.getRequestDispatcher("views/admin/adminDeleteReviewPage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
