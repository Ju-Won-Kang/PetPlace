<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"> 
    <title>결제완료</title>
    <link rel="stylesheet" href="css/shopping/shoppingComplete.css">
</head>
<body>
	<%@include file="../common/nav.jsp"%>
	<div class="complete-page">
		<div id="order-complete">
			<h2>주문 완료</h2>
		</div>
		<div id="complete-message">
			<h3>구매가 완료</h3>
			<p>되었습니다</p>
		</div>
		<div id="product-buy-info">
			<h4>상품결제 정보</h4>
		</div>
		<div class="buy-info-table">
			<table class="left-info-table">
				<thead>
					<tr>
						<th colspan="2" class="info-large-title">받는 사람 정보</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="info-small-title">이름</td>
						<td class="buy-user-info">${list.getMemberName()}</td>
					</tr>
					<tr>
						<td class="info-small-title">전화번호</td>
						<td class="buy-user-info">${list.getPhone()}</td>
					</tr>
					<tr>
						<td class="info-small-title">이메일</td>
						<td class="buy-user-info">${list.getEmail()}</td>
					</tr>
					<tr>
						<td class="info-small-title">배송주소</td>
						<td class="buy-user-info">${list.getAddress()}</td>
					</tr>
					<tr>
						<td class="info-small-title">배송 요청사항</td>
						<td class="buy-user-info">${list.getRequest()}</td>
					</tr>
					<tr>
						<td class="info-small-title"></td>
						<td class="buy-user-info"></td>
					</tr>
					<tr>
						<td class="info-small-title"></td>
						<td class="buy-user-info"></td>
					</tr>
				</tbody>
			</table>

			<table class="right-info-table">
				<thead>
					<tr>
						<th colspan="2" class="info-large-title">결제 정보</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="info-small-title">운송장 번호</td>
						<td class="buy-user-info">${list.getWayBill()}</td>
					</tr>
					<tr>
						<td class="info-small-title">상품명</td>
						<td class="buy-user-info">${list.getProductName()}</td>
					</tr>
					<tr>
						<td class="info-small-title">주문 금액</td>
						<td id="order-money" class="buy-user-info">${list.getAmountPrice()}</td>
					</tr>
					<tr>
						<td class="info-small-title">배송비</td>
						<td class="buy-user-info">3000원</td>
					</tr>
					<tr>
						<td class="info-small-title">총 결제 금액</td>
						<td id="all-buy-money" class="buy-user-info" onload="calc()"></td>
					</tr>
					<tr>
						<td class="info-small-title">결제일</td>
						<td class="buy-user-info">${list.getPurchaseDate()}</td>
					</tr>
					<tr>
						<td class="info-small-title"></td>
						<td class="buy-user-info"></td>
					</tr>
				</tbody>
			</table>
		</div>

		<script>
			function calc(){
				const orderMoney = document.querySelector("#order-moeny").value;
				const money = document.querySelector("#all-buy-money");

				money.innerHTML = orderMoney + 3000 + "원";
			}
		</script>

		<div class="home-continue-button">
			<a href=""><button id="home-button">홈으로</button></a>
			<a href="<%=contextPath%>/shopping.do?cpage=1"><button id="continue-button">쇼핑 계속하기</button></a>
		</div>
	</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>