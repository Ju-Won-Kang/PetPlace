package com.petplace.admin.controller;/**
 * packageName    : com.petplace.admin.controller
 * fileName       : AdminCreateProduct
 * author         : jun
 * date           : 2024. 9. 24.
 * description    : 상품 등록 페이지로 포워딩을 위한 서블릿
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 24.        jun       최초 생성
 */

import java.io.IOException;
import java.util.ArrayList;

import com.petplace.admin.model.dto.Category;
import com.petplace.member.model.dto.HashedMember;
import com.petplace.product.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "adminCreateProduct.pd", value = "/adminCreateProduct.pd")
public class AdminCreateProductFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 카테고리 리스트
        ArrayList<Category> cList = new ProductService().selectCategoryList();

        // 포워딩
        request.setAttribute("category", cList);
        System.out.println(cList);
        request.setAttribute("nav", 1);
        request.getRequestDispatcher("views/admin/adminCreateProductForm.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
