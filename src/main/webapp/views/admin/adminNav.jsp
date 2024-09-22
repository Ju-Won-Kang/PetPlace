<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 9. 20.
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set  var="nav" value="${param.nav}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/admin/adminNav.css">
    <script src="<c:url value="/js/admin/adminNav.js"/>"></script>
    <title>Title</title>
</head>
<body>
    <script>
        window.onload = function() {
            let nav = "${nav}";
            let navElement = document.querySelector("#label" + nav);  // id 값이 label1, label2 등으로 되어 있다고 가정
                selectCheck(navElement, nav);
        };
    </script>
    <nav>
        <div id="div1" onclick="location.href='<%=request.getContextPath() + "/adminPage?nav=1"%>'">
            <img src="images/image%2065.png">
            <label id="label1" class="none-select">상품 등록</label>
        </div>
        <div id="div2" onclick="location.href='<%=request.getContextPath() + "/adminPage?nav=2"%>'">
            <img src="images/image%2070.png">
            <label id="label2" class="none-select">상품 수정</label>
        </div>
        <div id="div3" onclick="location.href='<%=request.getContextPath() + "/adminPage?nav=3"%>'">
            <img src="images/image%2068.png">
            <label id="label3" class="none-select">상품 삭제</label>
        </div>
        <div id="div4" onclick="location.href='<%=request.getContextPath() + "/adminPage?nav=4"%>'">
            <img src="images/image%2062.png">
            <label id="label4" class="none-select">리뷰 관리</label>
        </div>
        <div id="div5" onclick="location.href='<%=request.getContextPath() + "/adminPage?nav=5"%>'">
            <img src="images/image%2061.png">
            <label id="label5" class="none-select">1:1 문의</label>
        </div>
        <div id="div6" onclick="location.href='<%=request.getContextPath() + "/adminPage?nav=6"%>'">
            <img src="images/image%2072.png">
            <label id="label6" class="none-select">배송 관리</label>
        </div>

    </nav>
</body>
</html>
