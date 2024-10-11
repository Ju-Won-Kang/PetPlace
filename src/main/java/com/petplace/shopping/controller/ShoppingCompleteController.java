package com.petplace.shopping.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.petplace.member.model.dto.HashedMember;
import com.petplace.member.model.vo.Member;
import com.petplace.purchase.model.vo.Purchase;
import com.petplace.shopping.model.dto.ShoppingComplete;
import com.petplace.shopping.service.ShoppingService;
import com.petplace.shopping.service.ShoppingServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShoppingCompleteController
 */
@WebServlet(name = "shoppingComplete.do", urlPatterns = { "/shoppingComplete.do" })
public class ShoppingCompleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCompleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// INSERT를 위한 파라미터 받기
		// 구매번호....

		int productNo = Integer.parseInt(request.getParameter("productNo"));
		int productCount = Integer.parseInt(request.getParameter("productCount"));
		int amountPrice = Integer.parseInt(request.getParameter("amountPrice")); //총결제금액
		String payType = request.getParameter("payType");
		String purchaseRequest = request.getParameter("request"); // 이름 중복으로 인해
		String cardNum = request.getParameter("cardNum");
		int totalProductPrice = Integer.parseInt(request.getParameter("totalProductPrice"));
		
		//회원 아이디 session에서 꺼내기
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		String userId = loginUser.getMemberId();
		
		
		System.out.println("아이디 체크: "+userId);
		
		//결제일
		 LocalDateTime now = LocalDateTime.now();
		// 시간 형식 지정 (예: yyyy-MM-dd)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedNow = now.format(formatter);
        
        String purchaseDate = formattedNow;
        
        //구매코드 갖고오기
        ShoppingService sService = new ShoppingServiceImpl();
        
        // 데이터 할당
        Purchase purchase = new Purchase();
        
        //구매코드는 시퀀스.NEXTVAL
//       purchase.setPurchaseNo();
        purchase.setMemberId(userId);
        purchase.setProductNo(productNo);
        purchase.setQuantity(productCount);
        purchase.setAmountPrice(amountPrice);
        purchase.setPayType(payType);
        purchase.setRequest(purchaseRequest);
        purchase.setCardNo(cardNum);
        
       
        sService.insertPurchase(purchase); //시퀀스 생성

        
        
		ShoppingComplete sc = null;
		
		
		sc = sService.selectShoppingCompleteList(productNo, userId);
		//최신 구매 정보만 조회
		//productNo와 memberId 조합의 가장 최근 구매일(PURCHASE_DATE) 조회
		
		System.out.println(sc);
		
		System.out.println(purchase);

		request.setAttribute("list", sc);
		request.setAttribute("purchase", purchase);
		request.setAttribute("totalProductPrice", totalProductPrice);
		
		request.getRequestDispatcher("views/shopping/shoppingComplete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
