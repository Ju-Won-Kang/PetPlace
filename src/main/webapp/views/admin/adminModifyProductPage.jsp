<%@ page import="java.util.ArrayList" %>
<%@ page import="com.petplace.product.model.vo.Product" %><%--
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
    <!-- jQuery -->
    <script
            src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
    <script
            src="https://code.jquery.com/ui/1.14.0/jquery-ui.min.js"
            integrity="sha256-Fb0zP4jE3JHqu+IBB9YktLcSjI1Zc6J2b6gTjB0LpoM="
            crossorigin="anonymous"></script>
    <script src="js/admin/adminModifyProductPage.js"></script>
    <title>상품 관리자 페이지</title>
    <style>
        .spinner-border {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
            color: #7A97CC;
        }
    </style>
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
                <th>카테고리</th>
                <th>상품명</th>
                <th>중량</th>
                <th>가격</th>
                <th>상품 수량</th>
                <th>게시 날짜</th>
                <th>수정</th>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${not empty pList}">
                        <c:forEach var="product" items="${pList}">
                            <tr>
                                <td>${product.productNo}</td>
                                <td>${product.productCategory}</td>
                                <td>${product.productName}</td>
                                <td>${product.productWeight} kg</td>
                                <td>${product.price}원</td>
                                <td>${product.inventory}개</td>
                                <td>${product.enrollDate}</td>
                                <td>
                                    <button type="button" class="btn btn-secondary btn-sm" data-bs-toggle="modal"
                                            data-bs-target="#modifyProductModal"
                                            onclick="modifyProudct(${product.productNo})">수정
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="9">등록된 제품이 없습니다.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
            <div id="pagenation">
                <nav>
                    <ul class="pagination">
                        <c:choose>
                            <c:when test="${pi.startPage != 1 || (pi.startPage / pi.boardLimit)  > 1}">
                                <li class="page-item">
                                    <a href="${pageContext.request.contextPath}/adminModifyProduct.pd?cpage=${pi.startPage - pi.boardLimit}"
                                       class="page-link">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item disabled">
                                    <a href="#" class="page-link">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${pi.currentPage > 1}">
                                <li class="page-item">
                                    <a href="${pageContext.request.contextPath}/adminModifyProduct.pd?cpage=${pi.currentPage - 1}"
                                       class="page-link">
                                        <span aria-hidden="true">&lt;</span>
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item disabled">
                                    <a href="#" class="page-link">
                                        <span aria-hidden="true">&lt;</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                        <c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}" step="1">
                            <c:choose>
                                <c:when test="${page == pi.currentPage}">
                                    <li class="page-item active"><a class="page-link" href="#">${page}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item"><a class="page-link"
                                                             href="${pageContext.request.contextPath}/adminModifyProduct.pd?cpage=${page}">${page}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${pi.currentPage < pi.maxPage}">
                                <li class="page-item">
                                    <a href="${pageContext.request.contextPath}/adminModifyProduct.pd?cpage=${pi.currentPage + 1}"
                                       class="page-link">
                                        <span aria-hidden="true">&gt;</span>
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item disabled">
                                    <a href="#" class="page-link">
                                        <span aria-hidden="true">&gt;</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${(pi.endPage / boardLimit)  < pi.maxPage}">
                                <li class="page-item">
                                    <a href="${pageContext.request.contextPath}/adminModifyProduct.pd?cpage=${pi.endPage + 1}"
                                       class="page-link">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item disabled">
                                    <a href="#" class="page-link">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </nav>
            </div>
        </div>
    </section>
    <div class="modal fade" id="modifyProductModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Modal Heading</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <form action="modifyProduct.pd" method="post" enctype="multipart/form-data">
                    <!-- Modal body -->
                    <div class="modal-body">
                        <div class="spinner-border"></div>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-secondary">상품 수정</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
    <%@include file="adminPageFooter.jsp" %>
</body>
</html>
