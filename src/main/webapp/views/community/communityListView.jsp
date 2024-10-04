<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/communityList.css">
<title>커뮤니티</title>
</head>
<body>
	<jsp:include page="../common/nav.jsp" />
	<br>
	<div id="category" class="container mt-3" align="center">
		<div>
			<a href="communityList.do?cpage=1&category=all">전체</a>
		</div>
		<div>
			<a href="communityList.do?cpage=1&category=개">개</a>
		</div>
		<div>
			<a href="communityList.do?cpage=1&category=고양이">고양이</a>
		</div>
		<div>
			<a href="communityList.do?cpage=1&category=기타">기타</a>
		</div>
	</div>
	<br>
	<div class="container mt-3 table-list">
		<a href="" class="list-btn">전체</a>&nbsp;&nbsp;
		<a href="" class="list-btn">인기글</a>&nbsp;&nbsp;
		<a href="" class="list-btn">공지글</a>&nbsp;&nbsp;
		<input type="text" class="search-bar" name="keyword" id="keyword" onkeyup="enterkey()">
		<script>
			function enterkey() {
				if (window.event.keyCode == 13) {
					const keyword = document.getElementById('keyword').value;
            		location.href = "communitySearchList.do?cpage=1&category=all&keyword=" + keyword;
				}
			}
		</script>
		<br><br>
		<table class="table" style="text-align: center;">
			<thead id="table-head">
				<tr>
					<th>번호</th>
					<th>카테고리</th>
					<th width="600px">제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>추천수</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="7">존재하는 게시글이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="c" items="${list }">
							<tr onclick="clickDetailPage(${c.communityNo})">
								<td>${c.communityNo}</td>
								<td>${c.communityCategory}</td>
								<td>${c.communityTitle}</td>
								<td>${c.nickname}</td>
								<td>${c.communityDate}</td>
								<td>${c.communityView}</td>
								<td>${c.communityGood}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<script>
            function clickDetailPage(communityNo){
                location.href = "communityDetail.do?cno=" + communityNo;
            }
       	</script>
		<c:if test="${loginUser ne null }">
			<div id="write" class="container mt-3" align="right">
				<div><a href="communityWrite.do">글쓰기</a></div>
			</div>
		</c:if>
		<br>
        <div align="center">
        	<c:if test="${pi.currentPage ne 1}">
                <a href="communityList.do?cpage=${pi.currentPage - 1}">[이전]</a>
            </c:if>

            <c:forEach var="i" begin="${pi.startPage}" end="${pi.endPage}">
            	<c:choose>
            		<c:when test="${empty condition }">
            			<a href="communityList.do?cpage=${i}">${i}</a>
            		</c:when>
            		<c:otherwise>
            			<a href="search.bo?cpage=${i}&condition=${condition}&keyword=${keyword}">${i}</a>
            		</c:otherwise>
            	</c:choose>
            </c:forEach>

            <c:if test="${pi.currentPage ne pi.maxPage}">
                <a href="communityList.do?cpage=${pi.currentPage + 1}">[다음]</a>
            </c:if>
        </div>
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>