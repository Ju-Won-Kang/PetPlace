<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 9. 20.
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/admin/adminModifyProductPage.css">
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>상품 관리자 페이지</title>
</head>
<body>
    <%@include file="adminPageHeader.jsp" %>
    <script>
        window.onload = function (){
            let nav = "<%=request.getAttribute("nav")%>";
            let navEl = document.querySelector("#label" + nav);
            selectCheck(navEl, nav);
        }
    </script>
    <section>
        <%@include file="adminNav.jsp"%>
        <div id="wrap">
            <table>
                <thead>
                <th>상품코드</th>
                <th>상품명</th>
                <th>가격</th>
                <th>상품 수량</th>
                <th>게시 날짜</th>
                <th>수정</th>
                </thead>
                <tbody>
                    <tr>
                        <td>A001</td>
                        <td>로얄 캐닌 3kg</td>
                        <td>12,900원</td>
                        <td>5개</td>
                        <td>2024.09.21</td>
                        <td>
                            <button type="button" class="btn btn-secondary btn-sm">수정</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </section>

    <%@include file="adminPageFooter.jsp" %>
</body>
</html>
