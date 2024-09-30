<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.petplace.common.PageInfo, java.util.ArrayList, com.petplace.community.model.vo.Community" %>
<%
    PageInfo pi = (PageInfo)request.getAttribute("pi");
    ArrayList<Community> list = (ArrayList<Community>)request.getAttribute("list");

    int currentPage = pi.getCurrentPage();
    int startPage = pi.getStartPage();
    int endPage = pi.getEndPage();
    int maxPage = pi.getMaxPage();
%>
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
	<%@include file="../common/nav.jsp" %>
	<br>
	<div id="category" class="container mt-3" align="center">
		<div>
			<a href="">전체</a>
		</div>
		<div>
			<a href="">개</a>
		</div>
		<div>
			<a href="">고양이</a>
		</div>
		<div>
			<a href="">기타</a>
		</div>
	</div>
	<br>
	<div class="container mt-3 table-list">
		<a href="" class="list-btn">전체</a>&nbsp;&nbsp;
		<a href="" class="list-btn">인기글</a>&nbsp;&nbsp;
		<a href="" class="list-btn">공지글</a>&nbsp;&nbsp;
		<a href="" class="list-btn">Q&A</a>
		<input type="text" class="search-bar">
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
				<% if(list.isEmpty()) { %>
					<tr>
						<td colspan="7">존재하는 게시글이 없습니다.</td>
					</tr>
				<% } else { %>
					<% for(Community c : list) {%>
						<tr>
							<td><%=c.getCummunity_no() %></td>
							<td><%=c.getCommunity_category() %></td>
							<td><%=c.getCommunity_title() %></td>
							<td><%=c.getNickname() %></td>
							<td><%=c.getCommunity_date() %></td>
							<td><%=c.getCommunity_views() %></td>
							<td><%=c.getCommunity_good() %></td>
						</tr>
					<% } %>
				<% } %>
			</tbody>
		</table>
		<c:if test="${loginUser ne null }">
			<div id="write" class="container mt-3" align="right">
				<div><a href="<%=contextPath%>/communityWrite.do">글쓰기</a></div>
			</div>
		</c:if>
		<br>
        <div align="center">
        	<%if(currentPage > 1) { %>
            	<button onclick="location.href='<%=contextPath%>/communityList.do?cpage=<%=currentPage - 1%>'">&lt;</button>
            <% } %>
            <% for(int p = startPage; p <= endPage; p++) { %>
                <% if(p == currentPage) { %>
                    <button disabled><%=p%></button>
                <% } else {%>
                    <button onclick="location.href='<%=contextPath%>/communityList.do?cpage=<%=p%>'"><%=p%></button>
                <% } %>
            <% } %>
            <%if(currentPage < maxPage) { %>
            	<button onclick="location.href='<%=contextPath%>/communityList.do?cpage=<%=currentPage + 1%>'">&gt;</button>
        	<% } %>
        </div>
	</div>
	<%@include file="../common/footer.jsp" %>
</body>
</html>