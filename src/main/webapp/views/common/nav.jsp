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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
</head>
<body>
    <header>
        <div id="header-wrap">
            <a href="<%=contextPath%>">
                <img src="images/Logo.png">
                <%System.out.println();%>
            </a>

            <a href="#">커뮤니티</a>
            <a href="">쇼핑</a>
            <a href="">입양</a>
            <a href="<%=contextPath%>/searchHospital.do">동물병원찾기</a>
            <a href="">기능</a>
            <a href="">
                <img src="images/user.png">
            </a>
            <script>
                function searchHospital() {
                    console.log(location.href);
                    location.href = 'searchHospital.do';
                }
            </script>
        </div>
    </header>
<%--    <div class="line"></div>--%>
</body>
</html>