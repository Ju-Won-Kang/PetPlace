package com.petplace.admin.controller;/**
 * packageName    : com.petplace.admin.controller
 * fileName       : AdminModifyProduct
 * author         : jun
 * date           : 2024. 9. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 24.        jun       최초 생성
 */

import com.petplace.common.PageInfo;
import com.petplace.product.model.vo.Product;
import com.petplace.product.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "adminModifyProduct.pd", value = "/adminModifyProduct.pd")
public class AdminModifyProductFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //------------------------ 페이징 처리 ------------------------
        int listCount; //현재 총 게시글 수
        int currentPage; //현재 페이지(사용자가 요청한 페이지)
        int pageLimit = 10; //페이지 하단에 보여질 페이징바의 수
        int boardLimit = 10; //한 페이지 내에 보여질 게시글 최대 갯수
        //위 4개의 값을 기준으로 아래 3개의 값을 구할 수 있다

        int maxPage; //가장 마지막 페이지(총 페이지의 수)
        int startPage; //페이징바의 시작 수
        int endPage; //페이징바의 마지막 수

        // listCount : 총 게시글 수
        listCount = new ProductService().selectListCount();

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
        endPage = (endPage > maxPage) ? maxPage : endPage;

        PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
        ArrayList<Product> pList = new ProductService().selectProductList(pi);
        System.out.println(pList);
        System.out.println(pi);
        request.setAttribute("pi", pi);
        request.setAttribute("pList", pList);

        request.setAttribute("nav",2);
        request.getRequestDispatcher("views/admin/adminModifyProductPage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
