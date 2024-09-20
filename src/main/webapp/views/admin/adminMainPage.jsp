<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 9. 20.
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/admin/adminMainPage.css">
    <title>상품 관리자 페이지</title>
</head>
<body>
    <%@include file="adminPageHeader.jsp" %>
    <section>
        <nav>
            <div>
                <img src="images/image%2065.png">
                <label>상품 등록</label>
            </div>
            <div>
                <img src="images/image%2070.png">
                <label>상품 수정</label>
            </div>
            <div>
                <img src="images/image%2068.png">
                <label>상품 삭제</label>
            </div>
            <div>
                <img src="images/image%2062.png">
                <label>리뷰 관리</label>
            </div>
            <div>
                <img src="images/image%2061.png">
                <label>1:1 문의</label>
            </div>
            <div>
                <img src="images/image%2072.png">
                <label>배송 관리</label>
            </div>
        </nav>
        <div id="wrap">
            <div id="content-left"></div>
            <div id="content-right"></div>
        </div>
    </section>

    <!-- 관리자 페이지 -> 메인 페이지 로 변경 필요 -->
    <%@include file="../common/footer.jsp" %>
    <script>
        document.querySelector("#adminPage").innerHTML = "<a href="
        <%=request.getContextPath()%>">메인 홈페이지</a>";
    </script>
</body>
</html>
