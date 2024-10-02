<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.petplace.common.PageInfo, java.util.ArrayList, com.petplace.shopping.model.dto.ShoppingList, com.petplace.review.model.vo.Review" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    PageInfo pi = (PageInfo)request.getAttribute("pi");
    ArrayList<ShoppingList> list = (ArrayList<ShoppingList>)request.getAttribute("list");

    int currentPage = pi.getCurrentPage();
    int startPage = pi.getStartPage();
    int endPage = pi.getEndPage();
    int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"> 
    <title>상품 목록</title>
    <link rel="stylesheet" href="css/shopping/shopping-list.css">
</head>
<body>
    <%@include file="../common/nav.jsp"%>
    <div id="menubar">
        <div id="animal-category">
            <a href="<%=contextPath%>/shopping.do?cpage=1">전체</a>
            <a href="<%=contextPath%>/shopping.do?cpage=1">멍멍이</a>
            <a href="<%=contextPath%>/shopping.do?cpage=1">냥</a>
            <a href="<%=contextPath%>/shopping.do?cpage=1">기타</a>
        </div>
        <div id="search-area">
            <input type="search">
            <input type="button" src="<%=contextPath%>/images/Search.png">
        </div>
       
    </div>
																				
    <div id="products">
        <% if(list.isEmpty()) { %>
            <p id="none-list">존재하는 쇼핑 목록이 없습니다.</p>
        <% } else { %>
            <div id="dogproduct-line1">
                <% for(ShoppingList s : list) { %>
                    <div class="dogFood">
                        <div onclick="location.href='<%=contextPath%>/shoppingdetail.do?productNo=<%=s.getProductNo() %>'" class="dogFood-img">
                            <img class="product_1-img" src="<%=contextPath%>/<%=s.getProductImg()%>" alt="프로베스트 사료">
                        	
                        </div>
                        <!-- 별점은 리뷰를 아직 만들지 않아 추후에 추가할 예정 -->
                        <!-- 리뷰를 아직 만들지 않아 상품평의 개수도 추후에 추가할 예정 -->
                        <div class="dogFood-info">
                            <p class="dogFood-name"><%=s.getProductName() %></p>
                            <p class="dogFood-price"><%=s.getPrice() %> 원</p>
                            <p class="dogFood-etc" id="stars"></p>
                            <p class="dogFood-etc" id="star-after"> 16,610개 상품평</p>
                        </div>
                    </div>
                <% } %>
            </div>
        <% } %>
    </div>

    <br><br>
        <div>
            <div align="center">
                <%if(currentPage > 1) { %>
                    <button onclick="location.href='<%=contextPath%>/shopping.do?cpage=<%=currentPage - 1%>'">&lt;</button>
                <% } %>
                <% for(int p = startPage; p <= endPage; p++) { %>
                    <% if(p == currentPage) { %>
                        <button disabled><%=p%></button>
                    <% } else {%>
                        <button onclick="location.href='<%=contextPath%>/shopping.do?cpage=<%=p%>'"><%=p%></button>
                    <% } %>
                <% } %>
                <%if(currentPage < maxPage) { %>
                    <button onclick="location.href='<%=contextPath%>/shopping.do?cpage=<%=currentPage + 1%>'">&gt;</button>
                <% } %>
            </div>
        </div>

    <%@include file="../common/footer.jsp"%>
</body>
</html>