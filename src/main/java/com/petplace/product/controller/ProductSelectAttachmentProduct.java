package com.petplace.product.controller;/**
 * packageName    : com.petplace.product.controller
 * fileName       : ProductSelectAttachmentProduct
 * author         : jun
 * date           : 2024. 9. 27.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 27.        jun       최초 생성
 */

import com.google.gson.Gson;
import com.petplace.product.model.vo.AttachmentProduct;
import com.petplace.product.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "selectAtProduct.pd", value = "/selectAtProduct.pd")
public class ProductSelectAttachmentProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productNo = request.getParameter("productNo");
        System.out.println(productNo);
        ArrayList<AttachmentProduct> atList = new ProductService().selectAttachment(productNo);

        response.setContentType("application/json; charset=utf-8");
        if (atList.isEmpty()) {
            response.getWriter().print("XXXX");
        } else {
            new Gson().toJson(atList, response.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
