package com.petplace.mypage.controller;

import java.io.IOException;

import com.petplace.member.model.vo.Member;
import com.petplace.mypage.model.dto.Petinfo;
import com.petplace.mypage.service.MypageServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/mypage.me")
public class MyPageController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = ((Member) session.getAttribute("loginUser")).getMemberId();

        Petinfo petInfo = new MypageServiceImpl().selectPetinfo(userId);

        // JSP로 Petinfo 전달
        request.setAttribute("petInfo", petInfo);
        request.getRequestDispatcher("/views/mypage/mypage.jsp").forward(request, response);
    }
}
