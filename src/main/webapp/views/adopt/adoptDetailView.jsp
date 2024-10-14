<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>입양</title>
    <link rel="stylesheet" href="css/adopt/adoptDetail.css">
</head>
<body>
    <%@include file="../common/nav.jsp" %>
    <div class="community-info-content">
        <div class="community-info">
            <div>
                <p id="community-info-title">${a.boardTitle}</p>
            </div>
            <div id="community-info-two">
                <p id="community-info-nick">${a.memberId}</p>
                <p id="community-info-date">${a.boardDate}</p>
                <p id="community-select-count">조회수 ${a.boardViews}</p>
                <c:if test="${loginUser.memberId eq a.memberId}">
                	<button onclick="location.href='adoptDelete.do?bno=${a.boardNo }'">삭제</button>
                </c:if>
            </div>
        </div>
        <div class="community-content">
            
            <div id="community-content-img">
                <img src="<%=contextPath%>/${a.adoptImg}">
            </div>
            <div id="community-content-write">
                <p>${a.boardDetail}</p>
            </div>
        </div>
    </div>
    <%@include file="../common/footer.jsp" %>
</body>
</html>