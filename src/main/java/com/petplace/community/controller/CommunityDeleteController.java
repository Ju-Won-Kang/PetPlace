package com.petplace.community.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.petplace.community.model.vo.Community;
import com.petplace.community.model.vo.CommunityAttachment;
import com.petplace.community.service.CommunityService;
import com.petplace.community.service.CommunityServiceImple;

/**
 * Servlet implementation class CommunityDeleteController
 */
@WebServlet(name = "communityDelete.do", urlPatterns = { "/communityDelete.do" })
public class CommunityDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int communityNo = Integer.parseInt(request.getParameter("cno"));
		

		CommunityService cService = new CommunityServiceImple();
		
		int result1 = cService.deleteCommunity(communityNo);
		CommunityAttachment atC = cService.selectCommunityAt(communityNo);
		int result2 = 1;
		if(atC != null) {
			result2 = cService.deleteCommunityAt(communityNo);
		}
		
		if(result1 * result2 > 0) {
			request.setAttribute("alertMsg", "게시글 삭제 성공");
			response.sendRedirect(request.getContextPath() + "/communityList.do?cpage=1&category=all&array=1");
		} else {
			request.setAttribute("alertMsg", "게시글 삭제 실패");
			response.sendRedirect(request.getContextPath() + "/communityList.do?cpage=1&category=all&array=1");
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
