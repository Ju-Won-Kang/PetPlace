package com.petplace.admin.controller;/**
 * packageName    : com.petplace.admin.controller
 * fileName       : AdminDeleteReviewController
 * author         : jun
 * date           : 2024. 9. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 29.        jun       최초 생성
 */

import com.petplace.review.service.ReviewService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "deleteReview.re", value = "/deleteReview.re")
public class AdminDeleteReviewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
        int result = new ReviewService().deleteReview(reviewNo);
        System.out.println("리뷰번호"+reviewNo);
        HttpSession session = request.getSession();
        if (result > 0) { // 성공
            session.setAttribute("alertMsg", "상품 수정에 성공했습니다.");
            response.sendRedirect(request.getContextPath() + "/adminDeleteReview.re?cpage=1");
        } else { // 실패
            session.setAttribute("alertMsg", "상품 수정에 실패하였습니다.");
            response.sendRedirect(request.getContextPath() + "/adminDeleteReview.re?cpage=1");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
