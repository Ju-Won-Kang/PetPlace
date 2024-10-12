package com.petplace.shopping.controller;/**
 * packageName    : com.petplace.shopping.controller
 * fileName       : SelectShopingTopListController
 * author         : jun
 * date           : 2024. 10. 11.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 10. 11.        jun       최초 생성
 */

import com.google.gson.Gson;
import com.petplace.shopping.model.dto.ShoppingList;
import com.petplace.shopping.service.ShoppingServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "selectProduct.do", value = "/selectProduct.do")
public class SelectShopingTopListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ArrayList<ShoppingList> list = new ShoppingServiceImpl().selectShoppingTopList();
        System.out.println(list);
        if (list == null){
            response.getWriter().print("NNNNN");
        }else{
//            response.getWriter().print("NNNNY");
            response.setContentType("application/json; charset=utf-8");
            new Gson().toJson(list, response.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
