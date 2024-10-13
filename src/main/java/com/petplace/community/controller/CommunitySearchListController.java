package com.petplace.community.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
 * Servlet implementation class CommunitySearchListController
 */
public class CommunitySearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunitySearchListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommunityService cService = new CommunityServiceImple();
		
		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		System.out.println(category);
		System.out.println(keyword);
		HashMap<String, String> map = new HashMap<>();
		
		int listCount = 0;
		//총 게시글 수
		if(category.equals("all")) {
			listCount = cService.selectSearchCount(keyword); 
		} else {
			map.put("category", category);
			map.put("keyword", keyword);
			listCount = cService.selectSearchCount(map);
		}
		
		System.out.println(listCount);
		
		PageInfo pi = Template.getPageInfo(listCount, currentPage, 10, 10);
		
		ArrayList<Community> list = null;
		if(category.equals("all")) {
			System.out.println("all");
			list = cService.selectSearchList(pi, keyword);
		} else {
			list = cService.selectSearchList(pi, map);
		}
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		System.out.println(list);
		
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
