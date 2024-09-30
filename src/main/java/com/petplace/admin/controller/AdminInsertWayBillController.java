package com.petplace.admin.controller;/**
 * packageName    : com.petplace.admin.controller
 * fileName       : AdminInsertWayBillController
 * author         : jun
 * date           : 2024. 9. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 30.        jun       최초 생성
 */

import com.petplace.purchase.service.PurchaseServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "insertWayBill.do", value = "/insertWayBill.do")
public class AdminInsertWayBillController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String purchaseNo = request.getParameter("purchaseNo");
        String wayBill = request.getParameter("wayBill");
        int result = new PurchaseServiceImpl().insertWayBill(purchaseNo, wayBill);
        HttpSession session = request.getSession();
        if (result > 0) { // 성공
            session.setAttribute("alertMsg", "운송장 번호 등록에 성공했습니다.");
            response.sendRedirect(request.getContextPath() + "/adminDeliveryManagement.pd?cpage=1");
        } else { // 실패
            session.setAttribute("alertMsg", "운송장 번호 등록에 실패하였습니다.");
            response.sendRedirect(request.getContextPath() + "/adminDeliveryManagement.pd?cpage=1");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
