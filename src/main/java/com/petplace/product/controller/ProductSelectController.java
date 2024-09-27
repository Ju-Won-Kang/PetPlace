package com.petplace.product.controller;/**
 * packageName    : com.petplace.product.controller
 * fileName       : ProductSelectController
 * author         : jun
 * date           : 2024. 9. 27.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 27.        jun       최초 생성
 */

import com.google.gson.Gson;
import com.petplace.product.model.vo.Product;
import com.petplace.product.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "selectProduct.pd", value = "/selectProduct.pd")
public class ProductSelectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product p = new ProductService().selectProduct(request.getParameter("productNo"));
        response.setContentType("application/json; charset=utf-8");
        if (p != null) {
            new Gson().toJson(p, response.getWriter());
        } else {
            response.getWriter().print("XXXX");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
