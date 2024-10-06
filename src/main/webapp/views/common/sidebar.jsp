<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <div id="div1" onclick="location.href='<%=request.getContextPath() + "/adminCreateProduct.pd"%>'">
        <img src="<c:url value='/images/22.png'/>">
        <label id="label1" class="none-select">내 정보</label>
    </div>
    <div id="div2" onclick="location.href='<%=request.getContextPath() + "/adminModifyProduct.pd?cpage=1"%>'">
        <img src="<c:url value='/images/33.png'/>">
        <label id="label2" class="none-select">주문 / 배송</label>
    </div>
    <div id="div3" onclick="location.href='<%=request.getContextPath() + "/adminDeleteProduct.pd?cpage=1"%>'">
        <img src="<c:url value='/images/44.png'/>">
        <label id="label3" class="none-select">구매내역</label>
    </div>
    <div id="div4" onclick="location.href='<%=request.getContextPath() + "/adminDeleteReview.re?cpage=1"%>'">
        <img src="<c:url value='/images/55.png'/>">
        <label id="label4" class="none-select">MY병원</label>
    </div>
</nav>


</body>
</html> 