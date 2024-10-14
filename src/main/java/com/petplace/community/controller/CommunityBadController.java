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
 * Servlet implementation class CommunityBadController
 */
public class CommunityBadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityBadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int communityNo = Integer.parseInt(request.getParameter("cno"));
		
		CommunityService cService = new CommunityServiceImple();
		
		int result = cService.communityBad(communityNo);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/communityDetail.do?cno=" + communityNo);
		} else {
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
