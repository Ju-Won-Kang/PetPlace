package com.petplace.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.petplace.common.PageInfo;
import com.petplace.product.model.vo.AttachmentProduct;
import com.petplace.product.model.vo.Product;
import com.petplace.shopping.service.ShoppingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "shopping.do", urlPatterns = { "/shopping.do" })
public class shoppingServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//------------------------ 페이징 처리 ------------------------
		int listCount; //현재 총 게시글 수
		int currentPage; //현재 페이지(사용자가 요청한 페이지)
		int pageLimit = 10; //페이지 하단에 보여질 페이징바의 수
		int boardLimit = 8; //한 페이지 내에 보여질 게시글 최대 갯수
		//위 4개의 값을 기준으로 아래 3개의 값을 구할 수 있다
		
		int maxPage; //가장 마지막 페이지(총 페이지의 수)
		int startPage; //페이징바의 시작 수
		int endPage; //페이징바의 마지막 수
		
		// listCount : 총 게시글 수
		listCount = new ShoppingService().selectShoppingListCount();
		
		System.out.println(listCount);
		
		//현재 페이지(사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		/**
		 * maxPage : 제일 마지막 페이지 수
		 * 
		 * listCount : 107
		 * boardLimit : 10
		 * 
		 * 총 게시글 수 / 한 페이지에 보여줄 게시글 수 -> 올림
		 */
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		/**
		 * startPage : 페이징바 시작 수
		 * 
		 * currentPage : 1
		 * pageLimit : 10
		 * startPage : 1
		 * 
		 * currentPage : 1
		 * pageLimit : 10
		 * startPage : 2
		 * 
		 * startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1
		 */
		
		startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1;
		
		/**
		 * endPage : 페이징바의 끝 수
		 * 
		 * startPage : 1 -> 10
		 * startPage : 11 -> 20
		 */
		
		endPage = startPage + pageLimit - 1;
		
		//startPage가 11이면 endPage는 20이다(maxPage가 13이라면?)
		endPage = endPage > maxPage ? maxPage : endPage;
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		ArrayList<Product> list = new ShoppingService().selectShoppingList();
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/shopping/shopping.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}