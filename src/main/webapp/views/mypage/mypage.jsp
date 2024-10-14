<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>My Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mypage/mypage.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mypage/sidebar.css">
</head>
<body>
    <%@include file="../common/nav.jsp" %>

    <div class="mypage-container">
        <div class="sidebar">
            <%@include file="sidebar.jsp" %>
        </div>
        
        <div class="main-content">
            <div class="profile-header">
                <div class="profile-info">
                    <img src="${pageContext.request.contextPath}/images/profile-image.png" alt="프로필 이미지">
                    <h2>웅이님</h2>
                </div>
                <div class="mypage-actions">
                    <a href="editUserInfo.jsp">내 정보 수정</a>
                    <a href="logout.jsp" style="color: red;">로그아웃</a>
                </div>
            </div>

            <div class="profile-section">
                <h3>프로필</h3>
                <div class="profile-info-details">
                    <p>이름: ${petInfo.petName}</p>
                    <p>나이: ${petInfo.petBirth}</p>
                    <p>성별: ${petInfo.petGender}</p>
                    <p>품종: ${petInfo.petType}</p>
                </div>
                <div class="mypage-actions">
                    <a href="editPetInfo.jsp">펫 정보 수정</a>
                    <a href="addPet.jsp">추가 등록</a>
                </div>
            </div>

            <div class="delete-account">
                <a href="deleteAccount.jsp" class="button">회원탈퇴</a>
            </div>
        </div>
    </div>
</body>
</html>
