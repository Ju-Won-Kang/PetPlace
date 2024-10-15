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
	<link rel="stylesheet" href="css/community/communityList.css">
	<title>커뮤니티</title>
</head>
<body>
	<jsp:include page="../common/nav.jsp" />
	<br>
	<div id="category" class="container mt-3" align="center">
		<div>
			<a href="javascript:categoryL('all')">전체</a>
		</div>
		<div>
			<a href="javascript:categoryL('개')">개</a>
		</div>
		<div>
			<a href="javascript:categoryL('고양이')">고양이</a>
		</div>
		<div>
			<a href="javascript:categoryL('기타')">기타</a>
		</div>
	</div>
	<br>
	<div class="container mt-3 table-list">
		<a href="javascript:arrL('1')" class="list-btn">시간순</a>&nbsp;&nbsp;
		<a href="javascript:arrL('2')" class="list-btn">추천순</a>
		<input type="text" class="search-bar" name="keyword" id="keyword" onkeyup="enterkey()">
		<script>



			// 현재 URL의 쿼리스트링을 가져옴
			const params = new URLSearchParams(window.location.search);

			// 특정 파라미터 값을 가져옴 (예: 'id'라는 파라미터가 있을 경우)
			const category = params.get('category');
			const array = params.get('array');
			const keyword = params.get('keyword');

			if (window.location.pathname.includes('communitySearchList.do')) {
				document.getElementById('keyword').value = keyword;
			}
			// 현재 URL의 pathname 가져오기
			const pathname = window.location.pathname;

			// 마지막 경로 부분 가져오기
			const lastSegment = pathname.split('/').pop();

			console.log(lastSegment);

			console.log(category);

			console.log(keyword);

			function categoryL(c){
				if(lastSegment === 'communityList.do'){
					location.href = lastSegment + "?cpage=1&category=" + c + "&array=" + array;
				} else{
					location.href = lastSegment + "?cpage=1&category=" + c + "&keyword=" + keyword + "&array=" + array;
				}

			}

			function arrL(a){
				if(lastSegment === 'communityList.do'){
					location.href = lastSegment + "?cpage=1&category=" + category + "&array=" + a;
				} else{
					location.href = lastSegment + "?cpage=1&category=" + category + "&keyword=" + keyword + "&array=" + a;
				}
			}
			function enterkey() {
				if (window.event.keyCode == 13) {
					const keyword = document.getElementById('keyword').value;
					location.href = "communitySearchList.do?cpage=1&category=" + category + "&keyword=" + keyword + "&array=" + array;
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
		<div id="pagenation" class="container mt-3">
			<nav class="pagination d-flex justify-content-center">
				<ul class="pagination">
					<c:choose>
						<c:when test="${pi.currentPage != 1 || (pi.startPage / pi.boardLimit)  > 1}">
							<li class="page-item">
								<a href="javascript:pageL(1)"
								   class="page-link">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item disabled">
								<a href="#" class="page-link">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${pi.currentPage > 1}">
							<li class="page-item">
								<a href="javascript:pageL('${pi.currentPage - 1}')"
								   class="page-link">
									<span aria-hidden="true">&lt;</span>
								</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item disabled">
								<a href="#" class="page-link">
									<span aria-hidden="true">&lt;</span>
								</a>
							</li>
						</c:otherwise>
					</c:choose>

					<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}" step="1">
						<c:choose>
							<c:when test="${page == pi.currentPage}">
								<li class="page-item active"><a class="page-link" href="#">${page}</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item">
									<a class="page-link" href="javascript:pageL('${page}')">${page}</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${pi.currentPage < pi.maxPage}">
							<li class="page-item">
								<a href="javascript:pageL('${pi.currentPage + 1}')"
								   class="page-link">
									<span aria-hidden="true">&gt;</span>
								</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item disabled">
								<a href="#" class="page-link">
									<span aria-hidden="true">&gt;</span>
								</a>
							</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${pi.currentPage eq pi.maxPage}">
							<li class="page-item disabled">
								<a href="#" class="page-link">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</c:when>
						<c:when test="${(pi.endPage / pi.boardLimit)  < pi.maxPage and (pi.endPage eq pi.maxPage)}">
							<li class="page-item">
								<a href="javascript:pageL('${pi.endPage}')"
								   class="page-link">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</c:when>
						<c:when test="${(pi.endPage / boardLimit)  < pi.maxPage}">
							<li class="page-item">
								<a href="javascript:pageL('${pi.endPage + 1}')"
								   class="page-link">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item disabled">
								<a href="#" class="page-link">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</div>
		<script>
			function pageL(p){
				console.log(p);
				if(lastSegment === 'communityList.do'){
					location.href = lastSegment + "?cpage=" + p +"&category=" + category + "&array=" + array;
				} else{
					location.href = lastSegment + "?cpage=" + p + "&category=" + category + "&keyword=" + keyword + "&array=" + array;
				}
			}
		</script>
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>