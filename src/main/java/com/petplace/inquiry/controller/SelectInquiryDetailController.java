package com.petplace.inquiry.controller;/**
 * packageName    : com.petplace.inquiry.controller
 * fileName       : SelectInquiryDetailController
 * author         : jun
 * date           : 2024. 9. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 30.        jun       최초 생성
 */

import com.google.gson.Gson;
import com.petplace.inquiry.model.vo.Inquiry;
import com.petplace.inquiry.service.InquiryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "selectInquiry.in", value = "/selectInquiry.in")
public class SelectInquiryDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inquiryNo = request.getParameter("inquiryNo");
        Inquiry inquiry = new InquiryService().selectInquiry(Integer.parseInt(inquiryNo));
        System.out.println(inquiryNo);
        response.setContentType("application/json; charset=utf-8");
        if(inquiry !=null){
            new Gson().toJson(inquiry,response.getWriter());
        }else{
            response.getWriter().print("XXXX");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
