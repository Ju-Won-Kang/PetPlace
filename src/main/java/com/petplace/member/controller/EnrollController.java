package com.petplace.member.controller;/**
 * packageName    : com.petplace.member.controller
 * fileName       : EnrollController
 * author         : jun
 * date           : 2024. 10. 4.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 10. 4.        jun       최초 생성
 */

import com.petplace.member.model.dto.BeforeHashingMember;
import com.petplace.member.model.dto.HashedMember;
import com.petplace.member.model.vo.Member;
import com.petplace.member.service.MemberService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "enroll.me", value = "/enroll.me")
public class EnrollController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 요청 파라미터 파싱
        String memberId = request.getParameter("userId");
        String memberPwd = request.getParameter("userPwd");
        String memberName = request.getParameter("userName");
        String SSN1 = request.getParameter("SSN1");
        String SSN2 = request.getParameter("SSN2");
        String phoneFirst = request.getParameter("phone_1");
        String phoneSecond = request.getParameter("phone_2");
        String phoneThird = request.getParameter("phone_3");
        String phone = phoneFirst + "-" + phoneSecond + "-" + phoneThird;
        String address = request.getParameter("address");
        String nickName = request.getParameter("nickName");

        int result = new MemberService().enrollMember(new BeforeHashingMember(memberId, memberPwd, memberName, SSN1, SSN2, phone, nickName, address));

        HttpSession session = request.getSession();
        if (result > 0) {
            session.setAttribute("alertMsg","회원가입에 성공했습니다.");
            response.sendRedirect(request.getContextPath());
        } else {
            session.setAttribute("alertMsg","회원가입에 실패했습니다.");
            response.sendRedirect(request.getContextPath());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
