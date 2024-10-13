package com.petplace.adopt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.petplace.adopt.model.service.AdoptService;
import com.petplace.adopt.model.service.AdoptServiceImpl;
import com.petplace.adopt.model.vo.Adopt;
import com.petplace.common.PageInfo;
import com.petplace.common.Template;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdoptSearchListController
 */
@WebServlet(name = "adoptSearch.do", urlPatterns = { "/adoptSearch.do" })
public class AdoptSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptSearchListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardType = request.getParameter("boardType");
		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("boardType", boardType);
		map.put("keyword", keyword);
		
		System.out.println(map);
		
		AdoptService aService = new AdoptServiceImpl();

		int searchCount = 0;
		
		if(category != null) {
			map.put("category", category);
			searchCount = aService.selectSearchListCount(map);
		} else {
			searchCount = aService.selectSearchListCount(map);
		}
		
		System.out.println("adoptcon" + searchCount);
		
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		PageInfo pi = Template.getPageInfo(searchCount, currentPage, 10, 10);
		
		ArrayList<Adopt> list = new ArrayList<>();
		
		list = aService.selectSearchList(map, pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("boardType", boardType);
		request.setAttribute("category", category);
		request.setAttribute("keyword", keyword);
		
		request.getRequestDispatcher("views/adopt/adoptListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
