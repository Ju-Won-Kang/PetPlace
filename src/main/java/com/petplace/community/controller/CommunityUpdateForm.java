package com.petplace.community.controller;

import java.io.IOException;

import com.petplace.community.model.vo.Community;
import com.petplace.community.model.vo.CommunityAttachment;
import com.petplace.community.service.CommunityService;
import com.petplace.community.service.CommunityServiceImple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommunityUpdateForm
 */
@WebServlet(name = "communityUpdate.do", urlPatterns = { "/communityUpdate.do" })
public class CommunityUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityUpdateForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int communityNo = Integer.parseInt(request.getParameter("cno"));
		
		CommunityService cService = new CommunityServiceImple();
		Community c = cService.selectCommunity(communityNo);
		CommunityAttachment atC = cService.selectCommunityAt(communityNo);
		if(atC != null) {
			request.setAttribute("atC", atC);
		}
		
		request.setAttribute("c", c);
		
		request.getRequestDispatcher("views/community/communityUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}