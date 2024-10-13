<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 9. 20.
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/admin/adminPageHeader.css">
    <script src="js/admin/adminPageHeader.js"></script>
    <title>Title</title>
</head>
<body>
    <header>
        <div id="header-wrap">
            <a href="<%=contextPath%>/adminCreateProduct.pd">
                <img src="images/Logo.png">
                <%System.out.println();%>
            </a>
            <a href="#" class="hidden">커뮤니티</a>
            <a href="" class="hidden">쇼핑</a>
            <a href="" class="hidden">입양</a>
            <a href="" class="hidden">동물병원찾기</a>
            <a href="" class="hidden">기능</a>
            <button type="button" id="user" onclick="userBtn_2()">
                <img src="images/user.png" alt="User">
            </button>
            <div id="profile-card" class="hide">
                <p>프로필</p>
                <div class="profile-image" style="text-align: center;">
                    <img src="images/usericon.png" alt="Profile Image"
                         style="display: block; margin: 0 auto;">
                </div>
                <div class="nickname"
                     style="text-align: center; margin-top: 10px;">${loginUser.nickName}</div>
                <div id="profile-links"
                     style="text-align: center; margin-top: 10px;">
                    <!-- 마이페이지와 로그아웃 링크 -->
                    <span><a href="${pageContext.request.contextPath}/mypage.me">마이페이지</a></span> | <span><a
                        href="${pageContext.request.contextPath}/logout.me"
                        style="color: red;">로그아웃</a></span>
                </div>
                <div class="menu-list"
                     style="text-align: center; margin-top: 20px;">

                </div>
            </div>
        </div>
    </header>
</body>
</html>
