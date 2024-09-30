<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 9. 22.
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/Logo.png"/>
    <link rel="stylesheet" href="css/admin/adminInquiryPage.css">
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
    <script src="js/admin/adminInquiryPage.js"></script>
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
                <th>문의 번호</th>
                <th>상품 코드</th>
                <th>상품명</th>
                <th>문의 제목</th>
                <th>작성자</th>
                <th>게시 날짜</th>
                <th>답변 유무</th>
                <th>답변</th>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${not empty iList}">
                        <c:forEach var="inquiry" items="${iList}">
                            <tr>
                                <td>${inquiry.inquiryNo}</td>
                                <td>${inquiry.productNo}</td>
                                <td>${inquiry.productName}</td>
                                <td>${inquiry.inquiryTitle}</td>
                                <td>${inquiry.memberId}</td>
                                <td>${inquiry.inquiryDate}</td>
                                <c:choose>
                                    <c:when test="${empty inquiry.answer}">
                                        <td class="red">답변 전</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td class="green">답변 완료</td>
                                    </c:otherwise>
                                </c:choose>
                                <td>
                                    <c:choose>
                                        <c:when test="${empty inquiry.answer}">
                                            <button type="button" class="btn btn-secondary btn-sm" data-bs-toggle="modal"
                                                    data-bs-target="#answerInquiryModal"
                                                    onclick="answerInquiry(${inquiry.inquiryNo})">답변
                                            </button>
                                        </c:when>
                                        <c:otherwise>
                                            <button type="button" class="btn btn-secondary btn-sm hide" data-bs-toggle="modal"
                                                    data-bs-target="#answerInquiryModal"
                                                    onclick="answerInquiry(${inquiry.inquiryNo})">수정
                                            </button>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="9">등록된 문의가 없습니다.</td>
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
                                    <a href="${pageContext.request.contextPath}/adminInquiry.in?cpage=${pi.startPage - pi.boardLimit}"
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
                                    <a href="${pageContext.request.contextPath}/adminInquiry.in?cpage=${pi.currentPage - 1}"
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
                                                             href="${pageContext.request.contextPath}/adminInquiry.in?cpage=${page}">${page}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${pi.currentPage < pi.maxPage}">
                                <li class="page-item">
                                    <a href="${pageContext.request.contextPath}/adminInquiry.in?cpage=${pi.currentPage + 1}"
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
                                    <a href="${pageContext.request.contextPath}/adminInquiry.in?cpage=${pi.endPage + 1}"
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
    <div class="modal fade" id="answerInquiryModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">상품 문의 답변</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <form action="answerInquiry.do" method="post">
                    <!-- Modal body -->
                    <div class="modal-body">
                        <div class="spinner-border"></div>
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
