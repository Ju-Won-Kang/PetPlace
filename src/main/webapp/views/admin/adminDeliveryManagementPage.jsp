<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 9. 22.
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/admin/adminDeliveryManagementPage.css">
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>상품 관리자 페이지</title>
</head>
<body>
    <%@include file="adminPageHeader.jsp" %>
    <section>
        <%@include file="adminNav.jsp"%>
        <div id="wrap">
            <table>
                <thead>
                <th>배송 상태</th>
                <th>구매번호</th>
                <th>상품 코드</th>
                <th>상품명</th>
                <th>구매 수량</th>
                <th>주문자 ID</th>
                <th>결제 수단</th>
                <th>요청 사항</th>
                <th>구매 날짜</th>
                <th>운송장 번호</th>
                </thead>
                <tbody>
                <tr>
                    <td>배송전</td>
                    <td>4123112</td>
                    <td>A001</td>
                    <td>로얄 캐닌 3kg</td>
                    <td>3개</td>
                    <td>fjafdsvh32</td>
                    <td>카드 결제</td>
                    <td>빠른 배송 부탁드립니다.</td>
                    <td>2024.09.21</td>
                    <td>
                        <button type="button" class="btn btn-secondary btn-sm">운송장 번호 등록</button>
                    </td>
                </tr>
                <tr>
                    <td>배송중</td>
                    <td>4123112</td>
                    <td>A001</td>
                    <td>로얄 캐닌 3kg</td>
                    <td>3개</td>
                    <td>fjafdsvh32</td>
                    <td>카드 결제</td>
                    <td>빠른 배송 부탁드립니다.</td>
                    <td>2024.09.21</td>
                    <td>592241414823</td>
                </tr>
                </tbody>
            </table>
        </div>
    </section>

    <%@include file="adminPageFooter.jsp" %>
</body>
</html>
