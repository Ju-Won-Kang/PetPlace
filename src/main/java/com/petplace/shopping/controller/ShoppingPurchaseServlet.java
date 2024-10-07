package com.petplace.shopping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.petplace.shopping.service.ShoppingService;
import com.petplace.shopping.service.ShoppingServiceImpl;

/**
 * Servlet implementation class ShoppingPurchaseServlet
 */
@WebServlet(name = "shoppingPurchase.do", urlPatterns = { "/shoppingPurchase.do" })
public class ShoppingPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo =Integer.parseInt(request.getParameter("productNo"));
		String productName = request.getParameter("productName"); //string
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		int productCount = Integer.parseInt(request.getParameter("productCount"));
		
		ShoppingService sService = new ShoppingServiceImpl();
//		sService. 여기까지 (dto작성중)
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
