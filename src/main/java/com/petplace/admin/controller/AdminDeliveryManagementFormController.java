package com.petplace.admin.controller;/**
 * packageName    : com.petplace.admin.controller
 * fileName       : AdminDeliveryManagementController
 * author         : jun
 * date           : 2024. 9. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 24.        jun       최초 생성
 */

import com.petplace.common.PageInfo;
import com.petplace.purchase.model.dto.PurchaseList;
import com.petplace.purchase.service.PurchaseService;
import com.petplace.purchase.service.PurchaseServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "adminDeliveryManagement.pd", value = "/adminDeliveryManagement.pd")
public class AdminDeliveryManagementFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PurchaseService pService = new PurchaseServiceImpl();
        int listCount = pService.selectPurchaseListCount();
        int currentPage = Integer.parseInt(request.getParameter("cpage"));
        PageInfo pi = PageInfo.getPageInfo(listCount, currentPage, 10, 10);
        ArrayList<PurchaseList> pList = pService.selectPurchaseList(pi);

        System.out.println("포워딩 전 리스트값 : " + pList);
        request.setAttribute("pList", pList);
        request.setAttribute("pi", pi);
        request.setAttribute("nav", 6);
        request.getRequestDispatcher("views/admin/adminDeliveryManagementPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
