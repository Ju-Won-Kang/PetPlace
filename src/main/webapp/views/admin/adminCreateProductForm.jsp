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
    <link rel="stylesheet" href="css/admin/adminCreateProductForm.css">
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

        .hide {
            display: none;
        }

    </style>
</head>
<body>
    <%@include file="adminPageHeader.jsp" %>
    <script>
        window.onload = function () {
            let nav = "<%=request.getAttribute("nav")%>";
            console.log(<%=request.getAttribute("nav")%>)
            let navElement = document.querySelector("#label" + nav);  // id 값이 label1, label2 등으로 되어 있다고 가정
            selectCheck(navElement, nav);
        };

        function CheckOther() {
            let selectEl = document.querySelector("#select-category");
            let inputEl = document.querySelector("#select-input");
            if (selectEl.value === "30") {
                inputEl.className = "input-group input-group-3m mb-3 w-35 expose";
            } else {
                inputEl.className = "input-group input-group-3m mb-3 w-25 hide";
            }
        }
    </script>
    <section>
        <%@include file="adminNav.jsp" %>
        <div id="wrap">
            <div id="content-left">
                <form action="${pageContext.request.contextPath}/productInsert.do" method="post" enctype="multipart/form-data">
                    <div id="category">
                        <div class="input-group input-group-lg mb-3 w-50">
                            <span class="input-group-text">카테고리</span>
                            <select id="select-category" class="form-select form-select-lg" name="categoryNo"
                                    onchange="CheckOther();">
                                <c:forEach var="c" items="${category}">
                                    <option value="${c.categoryNo}">${c.categoryName}</option>
                                </c:forEach>
                                <option value="30">기타</option>
                            </select>
                        </div>
                        <div id="select-input" class="input-group input-group-3m mb-3 w-25 hide">
                            <span class="input-group-text">기타 카테고리</span>
                            <input type="text" class="form-control" name="categoryName">
                        </div>
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
                        <span class="input-group-text">상품 재고 수량</span>
                        <input type="number" class="form-control">
                    </div>
                    <div class="input-group input-group-lg mb-3 w-50">
                        <span class="input-group-text">주원료</span>
                        <input type="text" class="form-control">
                    </div>
                    <div class="input-group input-group-lg mb-3 w-50">
                        <span class="input-group-text">원산지</span>
                        <input type="text" class="form-control">
                    </div>
                    <div class="input-group input-group-lg mb-3 w-50">
                        <span class="input-group-text">중량</span>
                        <input type="text" class="form-control">
                    </div>
                    <div class="input-group input-group-lg mb-3 w-50">
                        <span class="input-group-text">칼로리</span>
                        <input type="text" class="form-control">
                    </div>
                    <div class="input-group input-group-lg mb-3 w-75">
                        <span class="input-group-text">상품 상세페이지</span>
                        <input type="file" class="form-control">
                    </div>

                    <button type="submit" class="btn btn-secondary">상품 등록</button>

                </form>
            </div>
            <%--            <div id="content-right">--%>
        </div>
        </div>
    </section>

    <!-- 관리자 페이지 -> 메인 페이지 로 변경 필요 -->
    <%@include file="adminPageFooter.jsp" %>
</body>
</html>
