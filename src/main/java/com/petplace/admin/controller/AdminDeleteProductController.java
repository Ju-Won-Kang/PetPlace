package com.petplace.admin.controller;/**
 * packageName    : com.petplace.admin.controller
 * fileName       : AdminDeleteProductController
 * author         : jun
 * date           : 2024. 9. 29.
 * description    : 상품 삭제(STATUS = 'N')
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 29.        jun       최초 생성
 */

import com.petplace.product.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "delteProduct.pd", value = "/delteProduct.pd")
public class AdminDeleteProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productNo = request.getParameter("productNo");
        int result = new ProductService().deleteProduct(productNo);
        System.out.println("상품 삭제 result : " + result);
        HttpSession session = request.getSession();
        if (result > 0) { // 성공
            session.setAttribute("alertMsg", "상품 수정에 성공했습니다.");
            response.sendRedirect(request.getContextPath() + "/adminDeleteProduct.pd?cpage=1");
        } else { // 실패
            session.setAttribute("alertMsg", "상품 수정에 실패하였습니다.");
            response.sendRedirect(request.getContextPath() + "/adminDeleteProduct.pd?cpage=1");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
