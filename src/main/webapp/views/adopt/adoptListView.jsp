<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.petplace.common.PageInfo, java.util.ArrayList, com.petplace.adopt.model.vo.Adopt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetPlace - 입양(실종 게시판)</title>
    <link rel="stylesheet" href="css/adopt/adoptListView.css">
    
    <script type="text/javascript" src="js/adopt/adoptListView.js"></script>
</head>
<body>
    <%@ include file="/views/common/nav.jsp" %>

    <div class="content">
        <div class="adopt-type-btn">
            <button id="missing-btn" onclick="adoptMissingBtn()">유기 / 실종&nbsp;&nbsp;</button>
            <p>|</p>
            <button id="distribute-btn" onclick="adoptDistributeBtn()">&nbsp;&nbsp;분양</button>
        </div>
        <form class="find-pet-option" action="adoptSearch.do">
            <div class="select-pet-place">
            	<input type="hidden" name="boardType" value="${boardType}">
                <select id="select-pet-type" name="category">
                    <option value="all">동물종류</option>
                    <option value="cat">고양이</option>
                    <option value="dog">강아지</option>
                    <option value="etc">기타</option>
                </select>

                <!-- 반복으로 위치 받아야함 -->
                <select id="select-find-place" name="place">
                    <option value="all">위치</option>
                    <option value="suwon">수원시</option>
                </select>
            </div>
            <div id="find-pet-area">
                <input type="text" placeholder="검색">
                <button type="submit"><img src="<%=contextPath%>/images/Search.png"></button>
            </div>
        </form>
        <div class="missing-distribute-pet-table">
            <table id="missing-pet-table" class="missing-pet-table">
                <thead>
                    <tr class="table-line">
                        <th>번호</th>
                        <th>사진</th>
                        <th>동물정보</th>
                        <th>발견장소</th>
                        <th>발견날짜</th>
                        <th>글쓴이</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                	<c:choose>
                		<c:when test="${empty list}">
                			<tr>
                            	<td colspan="7">등록된 유기/실종 게시물이 존재하지 않습니다.</td>
                        	</tr>
                		</c:when>
                		<c:otherwise>
                			<c:forEach var="a" items="${list}">
			                    <tr class="table-line" onclick="detailPage(${a.boardNo}, '${a.boardType}')">
			                        <td>${a.boardNo}</td>
			                        <td><img src="<%= request.getContextPath() %>/${a.adoptImg}"></td>
			                        <td class="table-title">
			                            <p>${a.boardTitle}</p>
			                            <span id="reply-content">${a.boardDetail}</span>
			                        </td>                       
			                        <td>${a.place}</td>
			                        <td>${a.findDate}</td>
			                        <td>${a.memberId}</td>
			                        <td>${a.boardViews}</td>
			                    </tr>
			                </c:forEach>    
		                </c:otherwise>
	                </c:choose>
                </tbody>
            </table>
            

            <table id="distribute-pet-table" class="distribute-pet-table">
                <thead>
                    <tr class="table-line">
                        <th>번호</th>
                        <th>사진</th>
                        <th>동물정보</th>
                        <th>분양장소</th>
                        <th>글쓴이</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${empty list}">
                			<tr>
                            	<td colspan="6">등록된 분양 게시물이 존재하지 않습니다.</td>
                        	</tr>
                		</c:when>
                		<c:otherwise>
                		    <c:forEach var="a" items="${list}">
			                    <tr class="table-line"  onclick="detailPage(${a.boardNo}, '${a.boardType}')">
			                        <td>${a.boardNo}</td>
			                        <td><img src="<%= request.getContextPath() %>/${a.adoptImg}"></td>
			                        <td class="table-title">
			                            <p>${a.boardTitle}</p>
			                            <span id="reply-content">${a.boardDetail}</span>
			                        </td>                       
			                        <td>${a.place}</td>
			                        <td>${a.memberId}</td>
			                        <td>${a.boardViews}</td>
			                    </tr>
			                </c:forEach>
		                </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
            <div id="missing-write-btn-area">
               	<a href="<%=contextPath%>/adoptEnrollForm.do">글쓰기</a>
            </div>
        </div>
        <div id="search-img">
        <script>
            function detailPage(boardNo, boardType){
            	console.log(boardNo);
            	console.log(boardType);
                location.href="<%=contextPath%>/adoptDetail.do?bno="  +boardNo + "&bType=" + boardType;
            }
        </script>
        
        
        <script>
		    // 페이지 로드 시 boardType 파라미터 확인 후 버튼 색상과 테이블 상태 설정
		    window.onload = function() {
		        const urlParams = new URLSearchParams(window.location.search);
		        const boardType = urlParams.get('boardType');
		
		        const missingBtn = document.getElementById("missing-btn");
		        const distributeBtn = document.getElementById("distribute-btn");
		        const missingTable = document.getElementById("missing-pet-table");
		        const distributeTable = document.getElementById("distribute-pet-table");
		
		        if (boardType === "A" || !boardType) { // 유기/실종 버튼 상태
		            missingBtn.style.color = "rgb(152, 184, 219)";
		            distributeBtn.style.color = "black";
		            missingTable.style.display = "table";
		            distributeTable.style.display = "none";
		        } else if (boardType === "B") { // 분양 버튼 상태
		            missingBtn.style.color = "black";
		            distributeBtn.style.color = "rgb(152, 184, 219)";
		            missingTable.style.display = "none";
		            distributeTable.style.display = "table";
		        }
		    }
		
		    function adoptMissingBtn(){
		        location.href="<%=contextPath%>/adoptList.do?cpage=1&boardType=A";
		    }
		
		    function adoptDistributeBtn(){
		        location.href="<%=contextPath%>/adoptList.do?cpage=1&boardType=B";
		    }    
		</script>


        </div>
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
    </div>

    
    
    <%@ include file="/views/common/footer.jsp" %>
</body>
</html>
