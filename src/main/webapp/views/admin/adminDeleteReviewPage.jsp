<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 9. 22.
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/Logo.png"/>
    <link rel="stylesheet" href="css/admin/adminDeleteReviewPage.css">
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>상품 관리자 페이지</title>
</head>
<body>
    <%@include file="adminPageHeader.jsp" %>
    <script>
        window.onload = function () {
            let nav = "<%=request.getAttribute("nav")%>";
            let navEl = document.querySelector("#label" + nav);
            selectCheck(navEl, nav);
        }
    </script>
    <section>
        <%@include file="adminNav.jsp" %>
        <div id="wrap">
            <table>
                <thead>
                <th>상품코드</th>
                <th>상품명</th>
                <th>별점</th>
                <th>리뷰 내용</th>
                <th>게시 날짜</th>
                <th>삭제</th>
                </thead>
                <tbody>
                <tr>
                    <td>A001</td>
                    <td>로얄 캐닌 3kg</td>
                    <td>
                        <%-- 별점 관련 로직 필요 .5 별점이 필요한가? --%>
                        <img src="images/star1.png" alt="">
                        <img src="images/star1.png" alt="">
                        <img src="images/star1.png" alt="">
                        <img src="images/star1.png" alt="">
                        <img src="images/star1.png" alt="">
                    </td>
                    <td>배송도 빠르고 포장 상태도 너무 좋아요!</td>
                    <td>2024.09.21</td>
                    <td>
                        <button type="button" class="btn btn-secondary btn-sm">삭제</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </section>

    <%@include file="adminPageFooter.jsp" %>
</body>
</html>
