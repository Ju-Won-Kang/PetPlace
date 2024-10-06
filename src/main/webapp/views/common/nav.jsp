<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<<<<<<< HEAD
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PetPlace - 펫플레이스(반려동물 종합 플랫폼)</title>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.14.0/jquery-ui.min.js"
	integrity="sha256-Fb0zP4jE3JHqu+IBB9YktLcSjI1Zc6J2b6gTjB0LpoM="
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="css/common/nav.css">
<!-- Link Swiper's CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<script src="js/index.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
=======
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PetPlace - 펫플레이스(반려동물 종합 플랫폼)</title>
<link rel="stylesheet" href="css/common/nav.css">
<!-- Swiper's CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<script src="js/index.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
>>>>>>> e2ab6db (feat. 회원가입)
</head>
<body>
	<c:if test="${not empty sessionScope.alertMsg}">
		<script>alert("${sessionScope.alertMsg}")</script>
        ${sessionScope.remove("alertMsg")}
    </c:if>
	<<<<<<< HEAD
	<header>
		<div id="header-wrap">
			<a href="<%=contextPath%>"> <img src="images/Logo.png"> <%System.out.println();%>
			</a> <a href="<%=contextPath%>/communityList.do?cpage=1">커뮤니티</a> <a
				href="<%=contextPath%>/shopping.do?cpage=1">쇼핑</a> <a
				href="<%=contextPath%>/adoptList.do">입양</a> <a
				href="<%=contextPath%>/searchHospital.do">동물병원찾기</a> <a
				href="<%=contextPath%>/funcCalculator.do">기능</a> =======
			<header>
				<div id="header-wrap">
					<a href="<%=contextPath%>"> <img src="images/Logo.png"
						alt="Logo">
					</a> <a href="<%=contextPath%>/communityList.do?cpage=1">커뮤니티</a> <a
						href="<%=contextPath%>/shopping.do">쇼핑</a> <a
						href="<%=contextPath%>/adoptList.do">입양</a> <a
						href="<%=contextPath%>/searchHospital.do">동물병원찾기</a> <a
						href="<%=contextPath%>/funcCalculator.do">기능</a> >>>>>>> e2ab6db
					(feat. 회원가입) <<<<<<< HEAD
					<c:choose>
						<%-- 로그인 전 --%>
						<c:when test="${empty loginUser }">
							<button type="button" id="user" onclick="userBtn()">
								<img src="images/user.png">
							</button>
							<div id="user-info" class="hide">
								<p>USER</p>
								<div id="user-img"></div>
								<div id="login-form">
									<form action="<%=contextPath%>/login.me" method="post">
										<input type="text" name="userId" placeholder="아이디" required>
										<input type="password" name="userPwd" placeholder="비밀번호"
											required> <br> <br>
										<button type="submit">로그인</button>
										<button type="button"
											onclick="location.href = '${pageContext.request.contextPath}/views/common/signUp.jsp'">회원가입</button>
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
			=======
			<c:choose>
				<c:when test="${empty loginUser }">
					<button type="button" id="user" onclick="userBtn()">
						<img src="images/user.png" alt="User">
					</button>
					<div id="user-info">
						<p>USER</p>
						<div class="profile-image">
							<img src="images/usericon.png" alt="Profile Image">
						</div>
						<div id="login-form">
							<form action="<%=contextPath%>/login.me" method="post">
								<input type="text" name="userId" placeholder="아이디" required>
								<input type="password" name="userPwd" placeholder="비밀번호"
									required><br>
								<br>
								<button type="submit">로그인</button>
								<button type="button"
									onclick="location.href='<%=contextPath%>/termsAgree.do'">회원가입</button>
							</form>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<button type="button" id="user">
						<img src="images/user.png" alt="User">
					</button>
					<div class="profile-card">
						<div class="nickname">닉네임</div>
						<div class="profile-image">
							<img src="images/usericon.png" alt="Profile Image">
						</div>
						<div class="link">
							<span>마이페이지</span> <a href="#">로그아웃</a>
						</div>
						<ul class="menu-list">
							<li>찜목록</li>
							<li>구매목록</li>
							<li>예약정보</li>
							<li>내가 쓴 글</li>
						</ul>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</header>

</body>
</html>
