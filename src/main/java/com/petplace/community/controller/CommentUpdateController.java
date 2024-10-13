package com.petplace.community.controller;

import java.io.IOException;

import com.petplace.community.model.vo.BoardComment;
import com.petplace.community.service.CommunityService;
import com.petplace.community.service.CommunityServiceImple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommentUpdateController
 */
@WebServlet(name = "updatecComment.do", urlPatterns = { "/updatecComment.do" })
public class CommentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int commentNo = Integer.parseInt(request.getParameter("cmno"));
		int communityNo = Integer.parseInt(request.getParameter("cno"));
		String detail = request.getParameter("detail");
		
		CommunityService cService = new CommunityServiceImple();
		
		BoardComment bc = new BoardComment();
		
		bc.setCommentNo(commentNo);
		bc.setCommentDetail(detail);
		
		int result = cService.updateComment(bc);
		
		if(result > 0) {
			request.setAttribute("alertMsg", "댓글 수정 성공");
			response.sendRedirect(request.getContextPath() + "/communityDetail.do?cno=" + communityNo);
		} else {
			request.setAttribute("alertMsg", "댓글 수정 실패");
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
