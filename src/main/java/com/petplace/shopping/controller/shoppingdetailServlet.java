package com.petplace.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.petplace.shopping.model.dto.ShoppingDetailList;
import com.petplace.shopping.service.ShoppingService;
import com.petplace.shopping.service.ShoppingServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class shoppingdetailServlet
 */
@WebServlet(name = "shoppingdetail.do", urlPatterns = { "/shoppingdetail.do" })
public class shoppingdetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo = Integer.parseInt(request.getParameter("productNo")); // 상품번호 가져옴

		ShoppingService sService = new ShoppingServiceImpl();

		ArrayList<ShoppingDetailList> product = sService.selectDetailProduct(productNo);
		System.out.println("Controller : " + product);
		System.out.println(product.get(0).getFileLevel());

		request.setAttribute("product", product);
		request.getRequestDispatcher("views/shopping/shopping-detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
