package com.petplace.purchase.model.controller;

import java.io.IOException;

import com.petplace.purchase.model.vo.Kakao;
import com.petplace.purchase.service.PurchaseService;
import com.petplace.purchase.service.PurchaseServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "kakaoAPI.do", urlPatterns = { "/kakaoAPI.do" })
public class KakaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public KakaoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	// doPost으로
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 이전 페이지 요청에서 꺼내옴(이거 안꺼내진거같은데.. 요청을 다른곳으로 준듯)
				int productNo = Integer.parseInt(request.getParameter("productNo"));
				String userId = request.getParameter("userId");
				String productName = request.getParameter("productName");
				int totalProductPrice = Integer.parseInt(request.getParameter("totalProductPrice"));
				int taxFreeAmount = 0; //비과세 금액
				
				// 나머지 필수데이터 DB에서 꺼내오기 (미완성)
				String partnerOrderId;
				String quantity;
				
				PurchaseService ps = new PurchaseServiceImpl();
//				ps.selectPoQList();
				
				
				// 성공/취소/실패 시 이동할 URL
				String successUrl = "http://localhost:8888/petplace/shoppingComplete.do";
				String cancelUrl = "http://localhost:8888/petplace/shoppingPurchase.do?status=cancel"; //status 줘서 결과 확인
				String failUrl = "http://localhost:8888/petplace/shoppingPurchase.do?status=fail";
				
				
				//필수데이터 할당
				Kakao kakao = new Kakao();
				kakao.setCid("TC0ONETIME"); // 테스트결제용 가맹점코드 
				kakao.setPartnerOrderId("order_id_" + System.currentTimeMillis()); // 고유 주문 ID 생성
				kakao.setPartnerUserId(userId);
				kakao.setItemName(productName);
//				kakao.setQuantity();
				kakao.setTotalAmount(totalProductPrice);
				kakao.setTaxFreeAmount(0);
				kakao.setApprovalUrl(successUrl);
			    kakao.setCancelUrl(cancelUrl);
			    kakao.setFailUrl(failUrl);

				
			    
			    
			    
			    
				String adminKey = "707d8c5bc79d43584184c83e988f6466"; // 모든권한을 가진adminKey
				
				
				
				// 카카오 결제준비요청
//				String redirectUrl = sendPaymentRequest(productName, 등등등등등등);
				
				
				// 리다이렉트 URL을 사용하여 결제 페이지로 이동
//		        if (redirectUrl != null) {
//		            response.sendRedirect(redirectUrl);
//		        } else {
//		            response.getWriter().write("결제 준비 실패");
//		        }
//		    }
				
				
				
				
				
				
				
				
		
		
		doGet(request, response);
	}

}
