package com.petplace.adopt.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.petplace.adopt.model.service.AdoptService;
import com.petplace.adopt.model.service.AdoptServiceImpl;
import com.petplace.adopt.model.vo.Adopt;
import com.petplace.common.PageInfo;
import com.petplace.common.Template;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdoptListViewServlet
 */
@WebServlet(name = "adoptList.do", urlPatterns = { "/adoptList.do" })
public class AdoptListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptListViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdoptService aService = new AdoptServiceImpl();
        
        String boardType = request.getParameter("boardType");
        
        int currentPage = Integer.parseInt(request.getParameter("cpage"));
        int listCount = aService.selectAdoptListCount(boardType); // 총 게시글 수
        
        PageInfo pi = Template.getPageInfo(listCount, currentPage, 10, 10);
        
        ArrayList<Adopt> list = aService.selectAdoptList(pi, boardType);
        System.out.println(list);
        request.setAttribute("list", list);
        
        request.setAttribute("boardType", boardType);
        
        request.setAttribute("pi", pi);
        request.getRequestDispatcher("views/adopt/adoptListView.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
