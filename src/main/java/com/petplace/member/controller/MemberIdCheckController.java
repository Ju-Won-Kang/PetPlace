package com.petplace.member.controller;/**
 * packageName    : com.petplace.member.controller
 * fileName       : MemberIdCheckController
 * author         : jun
 * date           : 2024. 10. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 10. 7.        jun       최초 생성
 */

import com.petplace.member.service.MemberService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "idCheck.me", value = "/idCheck.me")
public class MemberIdCheckController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkId = request.getParameter("checkId");
        int checkIdCount = new MemberService().checkId(checkId);
        if(checkIdCount > 0){
            response.getWriter().print("NNNNN");
        }else{
            response.getWriter().print("NNNNY");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
