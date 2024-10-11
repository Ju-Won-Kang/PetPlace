package com.petplace.shopping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.petplace.member.model.dto.HashedMember;
import com.petplace.shopping.model.dto.UserInfo;
import com.petplace.shopping.service.ShoppingService;
import com.petplace.shopping.service.ShoppingServiceImpl;

/**
 * Servlet implementation class ShoppingPurchaseServlet
 */

@WebServlet(name = "shoppingPurchase.do", urlPatterns = { "/shoppingPurchase.do" })
public class OrderPurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productNo =Integer.parseInt(request.getParameter("productNo"));
		String productName = request.getParameter("productName");
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		int productCount = Integer.parseInt(request.getParameter("productCount"));
		
		// 정보 가공
		int totalProductPrice = productPrice * productCount; // 총 상품가격
		int amountPrice = totalProductPrice + 3000;	// 총 결제금액
		
		//세션 로그인 정보로 db에서 정보가져오기
		HttpSession session = request.getSession(); 
		HashedMember loginUser = (HashedMember)session.getAttribute("loginUser"); 
		String userId = loginUser.getMemberId();
		
		ShoppingService sService = new ShoppingServiceImpl();
		UserInfo userInfo = sService.selectUserInfoList(userId);
		
		request.setAttribute("productCount", productCount); 
		request.setAttribute("userId", userId); 
		request.setAttribute("userInfo", userInfo);
		request.setAttribute("productName", productName);
		request.setAttribute("totalProductPrice",totalProductPrice);
		request.setAttribute("amountPrice", amountPrice);
		request.setAttribute("productNo", productNo);
		request.getRequestDispatcher("views/shopping/shopping-purchase.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
