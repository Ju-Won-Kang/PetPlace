package com.petplace.community.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.petplace.community.service.CommunityService;
import com.petplace.community.service.CommunityServiceImple;

/**
 * Servlet implementation class CommentDeleteController
 */
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentNo = Integer.parseInt(request.getParameter("cmno"));
		int communityNo = Integer.parseInt(request.getParameter("cno"));
		CommunityService cService = new CommunityServiceImple();
		
		int result = cService.deleteComment(commentNo);
		
		if(result > 0) {
			request.setAttribute("alertMsg", "댓글 삭제 성공");
			response.sendRedirect(request.getContextPath() + "/communityDetail.do?cno=" + communityNo);
		} else {
			request.setAttribute("alertMsg", "댓글 삭제 실패");
			response.sendRedirect(request.getContextPath() + "/communityDetail.do?cno=" + communityNo);
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
