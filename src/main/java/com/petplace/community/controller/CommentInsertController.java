package com.petplace.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.petplace.community.model.vo.BoardComment;
import com.petplace.community.service.CommunityService;
import com.petplace.community.service.CommunityServiceImple;
import com.petplace.member.model.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommentInsertController
 */
public class CommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CommunityService cService = new CommunityServiceImple();
		
		int communityNo = Integer.parseInt(request.getParameter("cno"));
		String memberId = ((Member)request.getSession().getAttribute("loginUser")).getMemberId();
		String commentDetail = request.getParameter("content");
		
		BoardComment bc = new BoardComment();
		bc.setCommunityNo(communityNo);
		bc.setMemberId(memberId);
		bc.setCommentDetail(commentDetail);
		
		int result = cService.insertComment(bc);
		
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
