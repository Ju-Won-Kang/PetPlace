package com.petplace.adopt.controller;

import java.io.IOException;

import com.petplace.adopt.model.service.AdoptService;
import com.petplace.adopt.model.service.AdoptServiceImpl;
import com.petplace.adopt.model.vo.AdoptAttachment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdoptDeleteController
 */
@WebServlet(name = "adoptDelete.do", urlPatterns = { "/adoptDelete.do" })
public class AdoptDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		

		AdoptService aService = new AdoptServiceImpl();
		
		int result1 = aService.deleteAdopt(boardNo);
		AdoptAttachment aAt = aService.selectAdoptAt(boardNo);
		int result2 = 1;
		if(aAt != null) {
			result2 = aService.deleteAdoptAt(boardNo);
		}
		
		if(result1 * result2 > 0) {
			request.setAttribute("alertMsg", "게시글 삭제 성공");
			response.sendRedirect(request.getContextPath() + "/adoptList.do?cpage=1&boardType=A");
		} else {
			request.setAttribute("alertMsg", "게시글 삭제 실패");
			response.sendRedirect(request.getContextPath() + "/adoptList.do?cpage=1&boardType=A");
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
