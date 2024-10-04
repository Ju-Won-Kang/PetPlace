package com.petplace.community.controller;

import java.io.IOException;

import com.petplace.community.model.vo.Community;
import com.petplace.community.service.CommunityService;
import com.petplace.community.service.CommunityServiceImple;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommunityDetailController
 */
public class CommunityDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int communityNo = Integer.parseInt(request.getParameter("cno"));
		
		CommunityService cService = new CommunityServiceImple();
		
		Community c = cService.increaseCount(communityNo);
		
		if(c != null) {
			//ArrayList<Reply> list = bService.selectReplyList(boardNo);
			
			//request.setAttribute("list", list);
			request.setAttribute("c", c);
			request.getRequestDispatcher("views/community/communityDetail.jsp").forward(request, response);
		} else {
			request.setAttribute("alert", "상세조회 실패");
			response.sendRedirect(request.getContextPath());
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
