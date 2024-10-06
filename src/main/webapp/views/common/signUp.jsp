<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 10. 6.
  Time: 23:26
  회원가입 폼 테스트를 위한 임시 제작
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/enroll.me" method="post">
        아이디 : <input type="text" name="userId"> <br>
        비밀번호 : <input type="password" name="userPwd"> <br>
        이름 : <input type="text" name="userName"> <br>
        주민번호 : <input type="text" name="SSN1"> - <input type="text" name="SSN2"> <br>
        전화번호 : <input type="text" name="phone_1"> - <input type="text" name="phone_2"> - <input type="text" name="phone_3"> <br>
        주소 : <input type="text" name="address"> <br>
        닉네임 : <input type="text" name="nickName"> <br>
        <input type="submit" value="회원가입">
    </form>
</body>
</html>
