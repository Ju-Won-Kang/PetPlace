package com.petplace.admin.controller;/**
 * packageName    : com.petplace.admin.controller
 * fileName       : AdminInsertInquiryAnswerController
 * author         : jun
 * date           : 2024. 9. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 30.        jun       최초 생성
 */

import com.petplace.inquiry.service.InquiryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "answerInquiry.do", value = "/answerInquiry.do")
public class AdminInsertInquiryAnswerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
        String answer = request.getParameter("answer");
        int result = new InquiryService().insertInquiry(inquiryNo, answer);
        HttpSession session = request.getSession();
        if (result > 0) { // 성공
            session.setAttribute("alertMsg", "상품 문의 답변에 성공했습니다.");
            response.sendRedirect(request.getContextPath() + "/adminInquiry.in?cpage=1");
        } else { // 실패
            session.setAttribute("alertMsg", "상품 문의 답변에 실패하였습니다.");
            response.sendRedirect(request.getContextPath() + "/adminInquiry.in?cpage=1");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
