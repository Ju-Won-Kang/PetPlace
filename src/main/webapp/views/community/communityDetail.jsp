<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/communityDetail.css">
</head>
<body>
    <%@include file="../common/nav.jsp" %>
    <div class="community-info-content">
        <div class="community-info">
            <div>
                <p id="community-info-title">${c.communityTitle}</p>
            </div>
            <div id="community-info-two">
                <p id="community-info-nick">${c.nickname}</p>
                <p id="community-info-date">${c.communityDate}</p>
                <p id="community-recommend-count">추천수 ${c.communityGood}</p>
                <p id="community-select-count">조회수 ${c.communityView}</p>
                <c:if test="${loginUser.memberId eq c.memberId }">
                <form action="communityUpdate.do">
                	<input type="hidden" name="cno" value="${c.communityNo }">
                	<button>수정</button>
                </form>
                <form action="communityDelete.do">
                	<input type="hidden" name="cno" value="${c.communityNo }">
                	<button>삭제</button>
                </form>
                </c:if>
            </div>
        </div>
        <div class="community-content">
            
            <div id="community-content-img">
                <img src="<%=contextPath%>/${atC.filePath}${atC.changeName}">
            </div>
            <div id="community-content-write">
                <p>${c.communityDetail}</p>
            </div>
        </div>
        <div class="community-recommend-type">
            <div id="community-recommend">
                <button><img src="<%=contextPath%>/images/catnails1.png"></button>
                <p>추천</p>
            </div>
            <div id="community-none-recommend">
                <button><img src="<%=contextPath%>/images/catnails2.png"></button>
                <p>비추천</p>
            </div>
        </div>
    </div>
    <div class="community-reply-area">
        <div id="reply-area-etc">
            <div id="reply-count">
                <img src="<%=contextPath%>/images/chat.png" alt="">
                <span>댓글 count</span>
            </div>
            <button>
                <img src="<%=contextPath%>/images/link.png" alt="">
                <span>공유</span>
            </button>
        </div>

        <!-- 댓글 반복문 돌려주세요!! -->
        <div class="community-reply-list-insert">
            <div id="community-reply-list">
                <div id="community-reply-user-img"><img src="<%=contextPath%>/images/cat1_img.png"></div>
                <div id="nick-content-etc">
                    <p id="reply-nick">닉네임</p>
                    <p id="reply-content">오.. 고양이 귀여워요</p>
                    <div id="date-modify-delete">
                        <p>등록일 시간</p>
                        <button>수정</button>
                        <button>삭제</button>
                    </div>
                </div>
            </div>

            <div id="community-reply-insert">
                <p>닉네임</p>
                <textarea id="reply-content" style="resize: none;" cols="50" rows="3" placeholder="댓글을 남겨보세요"></textarea>
                <div>
                    <button><img src="<%=contextPath%>/images/Camera.png"></button>
                    <button id="reply-content-insert" onclick="insertReply()">등록</button>
                </div>
                
            </div>
        </div>

    </div>
    <%@include file="../common/footer.jsp" %>
</body>
</html>