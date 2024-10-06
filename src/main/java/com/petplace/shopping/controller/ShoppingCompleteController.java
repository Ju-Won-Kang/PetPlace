package com.petplace.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.petplace.shopping.model.dto.ShoppingComplete;
import com.petplace.shopping.service.ShoppingService;
import com.petplace.shopping.service.ShoppingServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShoppingCompleteController
 */
@WebServlet(name = "shoppingComplete.do", urlPatterns = { "/shoppingComplete.do" })
public class ShoppingCompleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCompleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo = Integer.parseInt(request.getParameter("pno"));
		ArrayList<ShoppingComplete> list = null;
		
		ShoppingService sService = new ShoppingServiceImpl();
		
		list = sService.selectShoppingCompleteList(productNo);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/shopping/shoppingComplete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
