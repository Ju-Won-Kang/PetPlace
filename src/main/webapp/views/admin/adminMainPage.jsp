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
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>상품 관리자 페이지</title>
    <style>
        .input-group > input {
            flex-grow: 0;
            flex-basis: 100px;
            width: 30%;
        }
    </style>
</head>
<body>
    <%@include file="adminPageHeader.jsp" %>
    <section>
        <%@include file="adminNav.jsp"%>
        <div id="wrap">
            <div id="content-left">
                <form action="">
                    <div class="input-group input-group-lg mb-3 w-50">
                        <span class="input-group-text">상품 코드</span>
                        <input type="text" class="form-control">
                    </div>
                    <div class="input-group input-group-lg mb-3 w-50">
                        <span class="input-group-text">카테고리</span>
                        <select class="form-select form-select-lg">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </div>
                    <div class="input-group input-group-lg mb-3 w-50">
                        <span class="input-group-text">상품명</span>
                        <input type="text" class="form-control">
                    </div>
                    <div class="input-group input-group-lg mb-3 w-50">
                        <span class="input-group-text">제조사</span>
                        <input type="text" class="form-control">
                    </div>
                    <div class="input-group input-group-lg mb-3 w-50">
                        <span class="input-group-text">상품 가격</span>
                        <input type="text" class="form-control">
                    </div>
                    <div class="input-group input-group-lg mb-3 w-50">
                        <span class="input-group-text">상품 수량</span>
                        <input type="number" class="form-control">
                    </div>
                    <div class="input-group input-group-lg mb-3 w-75">
                        <span class="input-group-text">상품 상세페이지</span>
                        <input type="file" class="form-control">
                    </div>

                    <button type="submit" class="btn btn-secondary">상품 등록</button>

                </form>
            </div>
            <div id="content-right">
            </div>
        </div>
    </section>

    <!-- 관리자 페이지 -> 메인 페이지 로 변경 필요 -->
    <%@include file="adminPageFooter.jsp" %>
</body>
</html>
