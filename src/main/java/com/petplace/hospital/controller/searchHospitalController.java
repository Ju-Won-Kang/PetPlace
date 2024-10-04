package com.petplace.hospital.controller;
/**
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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "searchHospital.do", value = "/searchHospital.do")
public class searchHospitalController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Properties 파일에서 API 키 가져오기
        Properties prop = new Properties();
        String filePath = searchHospitalController.class.getResource("/config.properties").getPath();
        prop.load(new FileInputStream(filePath));
        String apiKey = prop.getProperty("KAKAO_MAP_API_KEY");

        // JSP에 API 키 전달
        request.setAttribute("apiKey", apiKey);
        request.getRequestDispatcher("views/hospital/searchHospital.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
