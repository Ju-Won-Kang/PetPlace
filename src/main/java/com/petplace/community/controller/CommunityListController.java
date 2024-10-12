package com.petplace.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.community.model.vo.Community;
import com.petplace.community.service.CommunityService;
import com.petplace.community.service.CommunityServiceImple;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommunityListController
 */
public class CommunityListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommunityService cService = new CommunityServiceImple();
		
		String category = request.getParameter("category");
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		int arrayPage = Integer.parseInt(request.getParameter("array"));
		
		int listCount = 0;
		
		if(category.equals("all")) {
			listCount = cService.selectListCount(); //총 게시글 수
		} else {
			listCount = cService.selectListCount(category); //총 게시글 수
		}
		
		System.out.println(listCount);
		
		PageInfo pi = Template.getPageInfo(listCount, currentPage, 10, 10);
		
		ArrayList<Community> list = null;
		if(arrayPage == 1) {
			if(category.equals("all")) {
				list = cService.selectList(pi);
			} else {
				list = cService.selectList(pi, category);
			}
		} else {
			if(category.equals("all")) {
				list = cService.selectGoodList(pi);
			} else {
				list = cService.selectGoodList(pi, category);
			}
		}
		
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		request.getRequestDispatcher("views/community/communityListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
