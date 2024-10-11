<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sidebar</title>
<!-- sidebar.css 파일 연결 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/mypage/sidebar.css">
</head>
<body>
	<nav>
		<div id="div1"
			onclick="location.href='<%=request.getContextPath() + "/mypage.me"%>'">
			<img src="<c:url value='/images/22.png'/>">
			<label id="label1" class="none-select">내 정보</label>
		</div>

		<div id="div2"
			onclick="location.href='<%=request.getContextPath() + "/order.me"%>'">
			<img src="<c:url value='/images/33.png'/>">
			<label id="label2" class="none-select">주문 / 배송</label>
		</div>

		<div id="div3"
			onclick="location.href='<%=request.getContextPath() + "/orderhistory.me"%>'">
			<img src="<c:url value='/images/44.png'/>">
			<label id="label3" class="none-select">구매내역</label>
		</div>

		
	</nav>
</body>
</html>
