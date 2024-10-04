package com.petplace.admin.controller;/**
 * packageName    : com.petplace.admin.controller
 * fileName       : AdminDeleteReviewController
 * author         : jun
 * date           : 2024. 9. 24.
 * description    : 선택한 리뷰를 삭제하는 요청
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 24.        jun       최초 생성
 */

import com.petplace.common.PageInfo;
import com.petplace.product.service.ProductService;
import com.petplace.review.model.dto.ReviewList;
import com.petplace.review.model.vo.Review;
import com.petplace.review.service.ReviewService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "adminDeleteReview.re", value = "/adminDeleteReview.re")
public class AdminDeleteReviewFormController extends HttpServlet {
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
        listCount = new ReviewService().selectListCount();

        //현재 페이지(사용자가 요청한 페이지)
        currentPage = Integer.parseInt(request.getParameter("cpage"));
        PageInfo pi = PageInfo.getPageInfo(listCount, currentPage, pageLimit, boardLimit);

        ArrayList<ReviewList> rList = new ReviewService().selectReviewList(pi);
        request.setAttribute("pi",pi);
        request.setAttribute("rList",rList);
        request.setAttribute("nav", 4);
        request.getRequestDispatcher("views/admin/adminDeleteReviewPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
