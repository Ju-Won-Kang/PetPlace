package com.petplace.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.petplace.review.model.vo.Review;
import com.petplace.shopping.model.dto.ShoppingDetailList;
import com.petplace.shopping.service.ShoppingService;
import com.petplace.shopping.service.ShoppingServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;

/**
 * Servlet implementation class shoppingdetailServlet
 */
@WebServlet(name = "shoppingdetail.do", urlPatterns = { "/shoppingdetail.do" })
public class shoppingdetailServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo = Integer.parseInt(request.getParameter("productNo")); // 상품번호 가져옴

		ShoppingService sService = new ShoppingServiceImpl();

		ArrayList<ShoppingDetailList> product = sService.selectDetailProduct(productNo);
		System.out.println("Controller : " + product);
		System.out.println(product.get(0).getFileLevel());
		
		//--------------------리뷰 컨트롤러--------------------------
		int reviewCount = sService.selectReviewCount(productNo);	// 모든 리뷰 수 
		
		ArrayList<Review> list= sService.selectReviewList(productNo);	// 
		
		System.out.println(list);
		
		
		
		// 리뷰가 없으면 리뷰가 없습니다 
		if(reviewCount < 0) {
			request.setAttribute("errorMsg", "리뷰가 없습니다");
		}else {
			request.setAttribute("reviewCount", reviewCount); // 상품의 총 리뷰 개수
		}
		

		
		request.setAttribute("list", list);
		request.setAttribute("product", product);
		request.getRequestDispatcher("views/shopping/shopping-detail.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
