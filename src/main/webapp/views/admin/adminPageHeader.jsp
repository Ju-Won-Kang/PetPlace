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
    <title>Title</title>
</head>
<body>
    <header>
        <div id="header-wrap">
            <a href="<%=contextPath%>/adminPage">
                <img src="images/Logo.png">
                <%System.out.println();%>
            </a>
            <a href="#" class="hide">커뮤니티</a>
            <a href="" class="hide">쇼핑</a>
            <a href="" class="hide">입양</a>
            <a href="" class="hide">동물병원찾기</a>
            <a href="" class="hide">기능</a>
            <button type="button" id="user" onclick="userBtn()">
                <img src="images/user.png">
            </button>
            <div id="user-info">
                <p>USER</p>
                <div id="user-img"></div>
                <div id="login-form">
                    <form action="">
                        <input type="text" name="userId" placeholder="아이디" required>
                        <input type="password" name="userPwd" placeholder="비밀번호" required> <br> <br>
                        <button type="submit">로그인</button>
                        <button type="button">회원가입</button>
                    </form>
                </div>

            </div>
            <script>
                function searchHospital() {
                    console.log(location.href);
                    location.href = 'searchHospital.do';
                }
            </script>
        </div>
    </header>
</body>
</html>
