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
		String categoryName = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("categoryName", categoryName);
		map.put("keyword", keyword);
		
		ShoppingService sService = new ShoppingServiceImpl();
		
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		int searchCount = sService.selectSearchCount(map);
		
		PageInfo pi = Template.getPageInfo(searchCount, currentPage, 10, 8);
		ArrayList<ShoppingList> list = sService.selectSearchList(map, pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("categoryName", categoryName);
		request.setAttribute("keyword", keyword);
		
		if(categoryName != null) {
			if(categoryName.equals("강아지")) {
				request.getRequestDispatcher("views/shopping/shoppingDogList.jsp").forward(request, response);
			} else if(categoryName.equals("고양이")) {
				request.getRequestDispatcher("views/shopping/shoppingCatList.jsp").forward(request, response);
			} else if(categoryName.equals("기타")) {
				request.getRequestDispatcher("views/shopping/shoppingEtcList.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("views/shopping/shopping.jsp").forward(request, response);
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
