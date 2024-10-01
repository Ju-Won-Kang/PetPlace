<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.petplace.purchase.model.dto.PurchaseList" %><%--
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
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/Logo.png"/>
    <link rel="stylesheet" href="css/admin/adminDeliveryManagementPage.css">
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/admin/adminDeliveryManagementPage.js"></script>
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
                <th>배송 상태</th>
                <th>구매번호</th>
                <th>상품명</th>
                <th>구매 수량</th>
                <th>주문자 ID</th>
                <th>결제 수단</th>
                <th>결제 금액</th>
                <th>요청 사항</th>
                <th>구매 날짜</th>
                <th>운송장 번호</th>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${not empty pList}">
                        <c:forEach var="purchase" items="${pList}">
                            <tr>
                                <c:choose>
                                    <c:when test="${not empty purchase.wayBill}">
                                        <td class="blue">배송중</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td class="red">배송전</td>
                                    </c:otherwise>
                                </c:choose>
                                <td>${purchase.purchaseNo}</td>
                                <c:choose>
                                    <c:when test="${not empty purchase.multiDetail}">
                                        <td>${purchase.multiDetail}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>${purchase.productName}</td>
                                    </c:otherwise>
                                </c:choose>
                                <td>${purchase.quantity}</td>
                                <td>${purchase.memberId}</td>
                                <td>${purchase.payType}</td>
                                <td>${purchase.amountPrice}</td>
                                <td>${purchase.request}</td>
                                <td>${purchase.purchaseDate}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${not empty purchase.wayBill}">
                                            ${purchase.wayBill}
                                        </c:when>
                                        <c:otherwise>
                                            <button type="button" class="btn btn-secondary btn-sm" data-bs-toggle="modal"
                                                    data-bs-target="#insertWayBillModal"
                                                    onclick="inputWayBill(${purchase.purchaseNo});">운송장 번호 등록
                                            </button>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="10">구매된 상품이 없습니다.</td>
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
                                    <a href="${pageContext.request.contextPath}/adminDeliveryManagement.pd?cpage=${pi.startPage - pi.boardLimit}"
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
                                    <a href="${pageContext.request.contextPath}/adminDeliveryManagement.pd?cpage=${pi.currentPage - 1}"
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
                                                             href="${pageContext.request.contextPath}/adminDeliveryManagement.pd?cpage=${page}">${page}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${pi.currentPage < pi.maxPage}">
                                <li class="page-item">
                                    <a href="${pageContext.request.contextPath}/adminDeliveryManagement.pd?cpage=${pi.currentPage + 1}"
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
                                    <a href="${pageContext.request.contextPath}/adminDeliveryManagement.pd?cpage=${pi.endPage + 1}"
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
    <div class="modal fade" id="insertWayBillModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">송장 번호 입력</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <form action="insertWayBill.do" method="post">
                    <!-- Modal body -->
                    <div class="modal-body">
                        <input type="text">
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-secondary">문의 답변</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%@include file="adminPageFooter.jsp" %>
</body>
</html>
