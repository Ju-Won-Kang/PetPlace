package com.petplace.hospital.controller;/**
 * packageName    : com.petplace.controller
 * fileName       : searchHospitalServlet
 * author         : jun
 * date           : 2024. 9. 12.
 * description    : 포워딩을 위한 서블릿
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 12.        jun       최초 생성
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "searchHospital.hs", value = "/searchHospital.hs")
public class searchHospitalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/hospital/searchHospital.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
