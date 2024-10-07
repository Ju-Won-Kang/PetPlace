<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 10. 7.
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>
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
