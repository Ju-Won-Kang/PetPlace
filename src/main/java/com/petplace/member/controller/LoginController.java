package com.petplace.member.controller;

import java.io.IOException;

import com.petplace.member.model.dto.HashedMember;
import com.petplace.member.model.vo.Member;
import com.petplace.member.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 전달받은 값 추출후 변수 또는 객체에 기록
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		HashedMember loginUser = new MemberService().loginMember(userId, userPwd);
		
		if(loginUser == null) { //로그인 실패
			response.sendRedirect(request.getContextPath());
			System.out.println("실패");
		} else { //로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			response.sendRedirect(request.getContextPath());
			System.out.println("성공");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
