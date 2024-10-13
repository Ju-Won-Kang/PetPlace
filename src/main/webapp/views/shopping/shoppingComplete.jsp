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
						<td class="buy-user-info">${list.memberName}</td>
					</tr>
					<tr>
						<td class="info-small-title">전화번호</td>
						<td class="buy-user-info">${list.phone}</td>
					</tr>
					<tr>
						<td class="info-small-title">이메일</td>
						<td class="buy-user-info">${list.email}</td>
					</tr>
					<tr>
						<td class="info-small-title">배송주소</td>
						<td class="buy-user-info">${list.address}</td>
					</tr>
					<tr>
						<td class="info-small-title">배송 요청사항</td>
						<td class="buy-user-info">${list.request}</td>
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
						<td class="info-small-title">상품명</td>
						<td class="buy-user-info">${list.productName}</td>
					</tr>
					<tr>
						<td class="info-small-title">주문 금액</td>
						<td id="order-money" class="buy-user-info">${totalProductPrice}원</td>
					</tr>
					<tr>
						<td class="info-small-title">배송비</td>
						<td class="buy-user-info">3000원</td>
					</tr>
					<tr>
						<td class="info-small-title">총 결제 금액</td>
						<td id="all-buy-money" class="buy-user-info">${list.amountPrice}원</td>
					</tr>
					<tr>
						<td class="info-small-title">결제일</td>
						<td class="buy-user-info">${list.purchaseDate}</td>
					</tr>
					<tr>
						<td class="info-small-title"></td>
						<td class="buy-user-info"></td>
					</tr>
				</tbody>
			</table>
		</div>

		<script>
			
		</script>

		<div class="home-continue-button">
			<a href="<%=contextPath%>/"><button id="home-button">홈으로</button></a>
			<a href="<%=contextPath%>/shopping.do?cpage=1"><button id="continue-button">쇼핑 계속하기</button></a>
		</div>
	</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>