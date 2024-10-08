package com.petplace.member.controller;

import java.io.IOException;

import com.petplace.common.ShaUtil;
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

		Member loginUser = new MemberService().loginMember(userId);
		// 요청으로 들어온 비밀번호 해싱처리
		String hashedUserPwd = ShaUtil.sha256WithSaltEncode(userPwd, loginUser.getSalt());
		HttpSession session = request.getSession();


		if(loginUser == null) { //로그인 실패
			session.setAttribute("alertMsg","로그인에 실패하였습니다.");
			response.sendRedirect(request.getContextPath());
			System.out.println("실패");
		} else { //로그인 성공
			// DB에서 가져온 user 정보와 요청으로 들어온 정보 비교
			if(userId.equals(loginUser.getMemberId()) && hashedUserPwd.equals(loginUser.getMemberPwd())){
				session.setAttribute("loginUser", loginUser);
				session.setAttribute("alertMsg","로그인에 성공했습니다.");
				response.sendRedirect(request.getContextPath());
				System.out.println("성공");
			}else{
				session.setAttribute("alertMsg","로그인에 실패하였습니다.");
				response.sendRedirect(request.getContextPath());
				System.out.println("실패");
			}
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
