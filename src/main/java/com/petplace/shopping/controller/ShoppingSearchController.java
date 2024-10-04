package com.petplace.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.shopping.model.dto.ShoppingList;
import com.petplace.shopping.service.ShoppingService;
import com.petplace.shopping.service.ShoppingServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShoppingSearchController
 */
public class ShoppingSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		
		HashMap<String, String> map = new HashMap<>();
		ShoppingService sService = new ShoppingServiceImpl();
		
		int searchCount = 0;
		
		if(category != null) {
			map.put("category", category);
			map.put("keyword", keyword);
			searchCount = sService.selectSearchCount(map);
		} else {
			searchCount = sService.selectSearchCount(keyword);
		}

		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		PageInfo pi = Template.getPageInfo(searchCount, currentPage, 10, 8);
		
		ArrayList<ShoppingList> list = new ArrayList<>();
		
		if(category != null) {
			list = sService.selectSearchPetList(map, pi);
		} else {
			list = sService.selectSearchAllList(keyword, pi);
		}
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("category", category);
		request.setAttribute("keyword", keyword);
		
		request.getRequestDispatcher("views/shopping/shopping.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
