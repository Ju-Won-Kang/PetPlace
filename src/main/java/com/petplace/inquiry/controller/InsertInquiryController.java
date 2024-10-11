package com.petplace.inquiry.controller;/**
 * packageName    : com.petplace.inquiry.controller
 * fileName       : InsertInquiryController
 * author         : jun
 * date           : 2024. 10. 11.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 10. 11.        jun       최초 생성
 */

import com.petplace.inquiry.model.vo.Inquiry;
import com.petplace.inquiry.service.InquiryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "insertInquiry.in", value = "/insertInquiry.in")
public class InsertInquiryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int productNo = Integer.parseInt(request.getParameter("productNo"));
        String memberId = request.getParameter("memberId");
        String inquiryTitle = request.getParameter("inquiryTitle");
        String inquiryDetail = request.getParameter("inquiryDetail");
        Inquiry inquiry = new Inquiry(memberId, productNo, inquiryTitle, inquiryDetail);
        int result = new InquiryService().createInquiry(inquiry);
        HttpSession session = request.getSession();
        if (result > 0) {
            session.setAttribute("alertMsg","문의 등록에 성공했습니다.");
            response.sendRedirect(request.getContextPath() + "/shoppingdetail.do?productNo=" + productNo);
        } else {
            session.setAttribute("alertMsg","문의 등록에 실패했습니다.");
            response.sendRedirect(request.getContextPath() + "/shoppingdetail.do?productNo=" + productNo);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
