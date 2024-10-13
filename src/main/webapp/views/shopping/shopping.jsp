<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.petplace.common.PageInfo, java.util.ArrayList, com.petplace.shopping.model.dto.ShoppingList, com.petplace.review.model.vo.Review" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    PageInfo pi = (PageInfo)request.getAttribute("pi");
    ArrayList<ShoppingList> list = (ArrayList<ShoppingList>)request.getAttribute("list");

    java.text.NumberFormat numberFormat = java.text.NumberFormat.getInstance();
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
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- jQuery -->
    <script
            src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
    <script
            src="https://code.jquery.com/ui/1.14.0/jquery-ui.min.js"
            integrity="sha256-Fb0zP4jE3JHqu+IBB9YktLcSjI1Zc6J2b6gTjB0LpoM="
            crossorigin="anonymous"></script>
    <script src="js/admin/adminModifyProductPage.js"></script>
</head>
<body>
    <%@include file="../common/nav.jsp"%>
    <div id="menubar">
        <div id="animal-category">
            <a href="<%=contextPath%>/shopping.do?cpage=1">전체</a>
            <a href="<%=contextPath%>/shopping.do?cpage=1&category=강아지">멍멍이</a>
            <a href="<%=contextPath%>/shopping.do?cpage=1&category=고양이">냥</a>
            <a href="<%=contextPath%>/shopping.do?cpage=1&category=기타">기타</a>
        </div>
        <form action="shoppingSearch.do">
	        <div id="search-area">
	        	<c:if test="${category != null}">
				    <input type="hidden" name="category" value="${category}">
				</c:if>
	        	<input type="hidden" name="cpage" value="1">
	            <input type="search" name="keyword" value="${keyword}">
	            <input type="submit" value="검색" src="<%=contextPath%>/images/Search.png">
	        </div>
        </form>
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
                            <p class="dogFood-price"><%=numberFormat.format(s.getPrice()) %>원</p>
							<div id="dogFood-star">
								<c:forEach var="i" begin="1" end="<%=s.getStar() %>" step="1">
									<img class="dogFood-etc" id="stars" src="<%=contextPath%>/images/fullStar.png">
								</c:forEach>
								<c:forEach var="i" begin="<%=s.getStar() + 1 %>" end="5" step="1">
									<img class="dogFood-etc" id="stars" src="<%=contextPath%>/images/emptyStar.png">
								</c:forEach>
								<p class="dogFood-etc" id="star-after"><%=s.getReviewCount() %>개 상품평</p>
							</div>
                        </div>
                    </div>
                <% } %>
            </div>
        <% } %>
    </div>

    <br><br>
    <div id="pagenation">
            <nav>
            <c:if test="${keyword == null}">
                <ul class="pagination">
                    <c:choose>
                        <c:when test="${pi.startPage != 1 || (pi.startPage / pi.boardLimit)  > 1}">
                            <li class="page-item">
                           	<c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.startPage - pi.boardLimit}&category=${category}" class="page-link">
                                     <span aria-hidden="true">&laquo;</span>
                                 </a>
                             </c:when>
                             <c:otherwise>
                             	<a href="shoppingSearch.do?cpage=${pi.startPage - pi.boardLimit}" class="page-link">
                                     <span aria-hidden="true">&laquo;</span>
                                 </a>
                             </c:otherwise>
                         </c:choose>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled">
                            <c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.startPage - pi.boardLimit}&category=${category}" class="page-link">
                                     <span aria-hidden="true">&laquo;</span>
                                 </a>
                             </c:when>
                             <c:otherwise>
                             	<a href="shoppingSearch.do?cpage=${pi.startPage - pi.boardLimit}" class="page-link">
                                     <span aria-hidden="true">&laquo;</span>
                                 </a>
                             </c:otherwise>
                         </c:choose>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${pi.currentPage > 1}">
                            <li class="page-item">
                            <c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.currentPage - 1}&category=${category}" class="page-link">
                                     <span aria-hidden="true">&lt;</span>
                                 </a>
					</c:when>
					<c:otherwise>
						<a href="shoppingSearch.do?cpage=${pi.currentPage - 1}" class="page-link">
                                     <span aria-hidden="true">&lt;</span>
                                 </a>
					</c:otherwise>
				</c:choose>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled">
                            <c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.currentPage - 1}&category=${category}" class="page-link">
                                     <span aria-hidden="true">&lt;</span>
                                 </a>
                                </c:when>
					<c:otherwise>
						<a href="shoppingSearch.do?cpage=${pi.currentPage - 1}" class="page-link">
                                     <span aria-hidden="true">&lt;</span>
                                 </a>
					</c:otherwise>
				</c:choose>
                            </li>
                        </c:otherwise>
                    </c:choose>



                    <c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}" step="1">
                        <c:choose>
                            <c:when test="${page == pi.currentPage}">
                                <li class="page-item active">
                                <c:choose>
         						<c:when test="${category ne null}">
                                		<a class="page-link" href="shoppingSearch.do?cpage=${page}&category=${category}">${page}</a>
                                	</c:when>
                                	<c:otherwise>
                                		<a class="page-link" href="shoppingSearch.do?cpage=${page}">${page}</a>
                                	</c:otherwise>
                               	</c:choose>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item">
                                <c:choose>
         						<c:when test="${category ne null}">
                                		<a class="page-link" href="shoppingSearch.do?cpage=${page}&category=${category}">${page}</a>
                                	</c:when>
                                	<c:otherwise>
                                		<a class="page-link" href="shoppingSearch.do?cpage=${page}">${page}</a>
                                	</c:otherwise>
                                </c:choose>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    
                    
                    
                    <c:choose>
                        <c:when test="${pi.currentPage < pi.maxPage}">
                            <li class="page-item">
                            <c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.currentPage + 1}&category=${category}" class="page-link">
                                     <span aria-hidden="true">&gt;</span>
                                 </a>
                             </c:when>
                             <c:otherwise>
                             	<a href="shoppingSearch.do?cpage=${pi.currentPage + 1}" class="page-link">
                                     <span aria-hidden="true">&gt;</span>
                                 </a>
                             </c:otherwise>
                         </c:choose>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled">
                            <c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.currentPage + 1}&category=${category}" class="page-link">
                                     <span aria-hidden="true">&gt;</span>
                                 </a>
                             </c:when>
                             <c:otherwise>
                             	<a href="shoppingSearch.do?cpage=${pi.currentPage + 1}" class="page-link">
                                     <span aria-hidden="true">&gt;</span>
                                 </a>
                             </c:otherwise>
                         </c:choose>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${(pi.endPage / boardLimit)  < pi.maxPage}">
                            <li class="page-item">
                            <c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.endPage + 1}&category=${category}" class="page-link">
                                     <span aria-hidden="true">&raquo;</span>
                                 </a>
                             </c:when>
                             <c:otherwise>
                             	<a href="shoppingSearch.do?cpage=${pi.endPage + 1}" class="page-link">
                                     <span aria-hidden="true">&raquo;</span>
                                 </a>
                             </c:otherwise>
                         </c:choose>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled">
                            <c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.endPage + 1}&category=${category}" class="page-link">
                                     <span aria-hidden="true">&raquo;</span>
                                 </a>
                             </c:when>
                             <c:otherwise>
                             	<a href="shoppingSearch.do?cpage=${pi.endPage + 1}" class="page-link">
                                     <span aria-hidden="true">&raquo;</span>
                                 </a>
                             </c:otherwise>
                         </c:choose>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </c:if>
            
            <c:if test="${keyword != null}">
                <ul class="pagination">
                    <c:choose>
                        <c:when test="${pi.startPage != 1 || (pi.startPage / pi.boardLimit)  > 1}">
                            <li class="page-item">
                           	<c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.startPage - pi.boardLimit}&category=${category}&keyword=${keyword}" class="page-link">
                                     <span aria-hidden="true">&laquo;</span>
                                 </a>
                             </c:when>
                             <c:otherwise>
                             	<a href="shoppingSearch.do?cpage=${pi.startPage - pi.boardLimit}&keyword=${keyword}" class="page-link">
                                     <span aria-hidden="true">&laquo;</span>
                                 </a>
                             </c:otherwise>
                         </c:choose>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled">
                            <c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.startPage - pi.boardLimit}&category=${category}&keyword=${keyword}" class="page-link">
                                     <span aria-hidden="true">&laquo;</span>
                                 </a>
                             </c:when>
                             <c:otherwise>
                             	<a href="shoppingSearch.do?cpage=${pi.startPage - pi.boardLimit}&keyword=${keyword}" class="page-link">
                                     <span aria-hidden="true">&laquo;</span>
                                 </a>
                             </c:otherwise>
                         </c:choose>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${pi.currentPage > 1}">
                            <li class="page-item">
                            <c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.currentPage - 1}&category=${category}&keyword=${keyword}" class="page-link">
                                     <span aria-hidden="true">&lt;</span>
                                 </a>
					</c:when>
					<c:otherwise>
						<a href="shoppingSearch.do?cpage=${pi.currentPage - 1}&keyword=${keyword}" class="page-link">
                                     <span aria-hidden="true">&lt;</span>
                                 </a>
					</c:otherwise>
				</c:choose>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled">
                            <c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.currentPage - 1}&category=${category}&keyword=${keyword}" class="page-link">
                                     <span aria-hidden="true">&lt;</span>
                                 </a>
                                </c:when>
					<c:otherwise>
						<a href="shoppingSearch.do?cpage=${pi.currentPage - 1}&keyword=${keyword}" class="page-link">
                                     <span aria-hidden="true">&lt;</span>
                                 </a>
					</c:otherwise>
				</c:choose>
                            </li>
                        </c:otherwise>
                    </c:choose>



                    <c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}" step="1">
                        <c:choose>
                            <c:when test="${page == pi.currentPage}">
                                <li class="page-item active">
                                <c:choose>
         						<c:when test="${category ne null}">
                                		<a class="page-link" href="shoppingSearch.do?cpage=${page}&category=${category}&keyword=${keyword}">${page}</a>
                                	</c:when>
                                	<c:otherwise>
                                		<a class="page-link" href="shoppingSearch.do?cpage=${page}&keyword=${keyword}">${page}</a>
                                	</c:otherwise>
                               	</c:choose>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item">
                                <c:choose>
         						<c:when test="${category ne null}">
                                		<a class="page-link" href="shoppingSearch.do?cpage=${page}&category=${category}&keyword=${keyword}">${page}</a>
                                	</c:when>
                                	<c:otherwise>
                                		<a class="page-link" href="shoppingSearch.do?cpage=${page}&keyword=${keyword}">${page}</a>
                                	</c:otherwise>
                                </c:choose>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    
                    
                    
                    <c:choose>
                        <c:when test="${pi.currentPage < pi.maxPage}">
                            <li class="page-item">
                            <c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.currentPage + 1}&category=${category}&keyword=${keyword}" class="page-link">
                                     <span aria-hidden="true">&gt;</span>
                                 </a>
                             </c:when>
                             <c:otherwise>
                             	<a href="shoppingSearch.do?cpage=${pi.currentPage + 1}&keyword=${keyword}" class="page-link">
                                     <span aria-hidden="true">&gt;</span>
                                 </a>
                             </c:otherwise>
                         </c:choose>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled">
                            <c:choose>
             				<c:when test="${category ne null}" >
                                 <a href="shoppingSearch.do?cpage=${pi.currentPage + 1}&category=${category}&keyword=${keyword}" class="page-link">
                                     <span aria-hidden="true">&gt;</span>
                                 </a>
                             </c:when>
                             <c:otherwise>
                             	<a href="shoppingSearch.do?cpage=${pi.currentPage + 1}&keyword=${keyword}" class="page-link">
                                     <span aria-hidden="true">&gt;</span>
                                 </a>
                             </c:otherwise>
                         </c:choose>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${(pi.endPage / boardLimit)  < pi.maxPage}">
                            <li class="page-item">
                            <c:choose>
								<c:when test="${category ne null}" >
									<a href="shoppingSearch.do?cpage=${pi.endPage + 1}&category=${category}&keyword=${keyword}" class="page-link">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</c:when>
								<c:otherwise>
									<a href="shoppingSearch.do?cpage=${pi.endPage + 1}&keyword=${keyword}" class="page-link">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</c:otherwise>
                         	</c:choose>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled">
                            <c:choose>
								<c:when test="${category ne null}" >
									<a href="shoppingSearch.do?cpage=${pi.endPage + 1}&category=${category}&keyword=${keyword}" class="page-link">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</c:when>
								<c:otherwise>
									<a href="shoppingSearch.do?cpage=${pi.endPage + 1}&keyword=${keyword}" class="page-link">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</c:otherwise>
                         	</c:choose>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </c:if>
            </nav>
       </div>

    <%@include file="../common/footer.jsp"%>
</body>
</html>