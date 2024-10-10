package com.petplace.adopt.controller;

import java.io.IOException;
import java.util.HashMap;

import com.petplace.adopt.model.service.AdoptService;
import com.petplace.adopt.model.vo.Adopt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MissingDetailViewServlet
 */
@WebServlet(name = "adoptDetail.do", urlPatterns = { "/adoptDetail.do" })
public class AdoptDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String boardType = request.getParameter("bType");

		HashMap<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("boardType", boardType);
		
		
		Adopt a = AdoptService.selectDetailList(map);
		
		request.getRequestDispatcher("views/adopt/adoptDetailView.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
