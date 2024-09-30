package com.petplace.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.petplace.shopping.model.vo.Shopping;
import com.petplace.shopping.service.ShoppingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class shoppingDogListController
 */
@WebServlet(name = "dogList.do", urlPatterns = { "/dogList.do" })
public class AjaxShoppingDogListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxShoppingDogListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName = (String)(request.getParameter("categoryName"));
		
		ArrayList<Shopping> list = new ArrayList<>();
		ShoppingService sService = new ShoppingService();
		
		if(categoryName.equals("전체")) {
			list = sService.selectAllList(categoryName);
		} else if(categoryName.equals("강아지")) {
			list = sService.selectCategoryList(categoryName);
		} else if(categoryName.equals("고양이")) {
			list = sService.selectCategoryList(categoryName);
		} else if(categoryName.equals("기타")) {
			list = sService.selectCategoryList(categoryName);
		} else {
			System.out.println("존재하지 않는 카테고리 입니다");
		}
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
