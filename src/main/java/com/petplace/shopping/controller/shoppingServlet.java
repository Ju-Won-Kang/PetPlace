package com.petplace.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.shopping.model.dto.ShoppingList;
import com.petplace.shopping.service.ShoppingServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "shopping.do", urlPatterns = { "/shopping.do" })
public class shoppingServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingServiceImpl sService = new ShoppingServiceImpl();
		//------------------------ 페이징 처리 ------------------------
		
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		String categoryName = (String)(request.getParameter("category")); 
		System.err.println(categoryName);
		int listCount = sService.selectShoppingListCount(); //총 게시글 수
		
		PageInfo pi = Template.getPageInfo(listCount, currentPage, 10, 8);
		
		ArrayList<ShoppingList> list = sService.selectShoppingList(pi, categoryName);
		System.out.println(list);
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}