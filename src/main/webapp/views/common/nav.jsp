<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 9. 19.
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetPlace - 펫플레이스(반려동물 종합 플랫폼)</title>
    <link rel="stylesheet" href="css/nav.css">
    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
    <script src="js/index.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <header>
        <div id="header-wrap">
            <a href="<%=contextPath%>">
                <img src="images/Logo.png">
                <%System.out.println();%>
            </a>
            
            <a href="<%=contextPath%>/communityList.do">커뮤니티</a>
            <a href="<%=contextPath%>/shopping.do">쇼핑</a>
            <a href="">입양</a>
            <a href="<%=contextPath%>/searchHospital.do">동물병원찾기</a>
            <a href="<%=contextPath%>/funcCalculator.do">기능</a>

			<c:choose>
				<%-- 로그인 전 --%>
				<c:when test="${empty loginUser }">
		            <button type="button" id="user" onclick="userBtn()">
		                <img src="images/user.png">
		            </button>
		            <div id="user-info">
		                <p>USER</p>
		                <div id="user-img"></div>
		                <div id="login-form">
		                    <form action="<%=contextPath%>/login.me" method="post">
		                        <input type="text" name="userId" placeholder="아이디" required>
		                        <input type="password" name="userPwd" placeholder="비밀번호" required> <br> <br>
		                        <button type="submit">로그인</button>
		                        <button type="button">회원가입</button>
		                    </form>
		                </div>
		            </div>
		    	</c:when>
		    	<%-- 로그인 후 --%>
		    	<c:otherwise>
		    		<button type="button" id="user">
		                <img src="images/user.png">
		            </button>
		    	</c:otherwise>
            </c:choose>
            <script>
                function searchHospital() {
                    console.log(location.href);
                    location.href = 'searchHospital.do';
                }
            </script>
        </div>
    </header>
    <%--    <div class="line"></div> --%>
</body>
</html>