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
                <p id="community-info-title">제목</p>
            </div>
            <div id="community-info-two">
                <p id="community-info-nick">닉네임</p>
                <p id="community-info-date">작성일</p>
                <p id="community-recommend-count">추천수</p>
                <p id="community-select-count">조회수</p>
                <button>수정</button>
                <button>삭제</button>
            </div>
        </div>
        <div class="community-content">
            <div id="community-content-img">
                <img src="<%=contextPath%>/images/cat1_img.png">
            </div>
            <div id="community-content-write">
                <p>우리집 고양이 두마리! 귀엽지?</p>
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
    <div class="community-comment-area">
        <div id="comment-area-etc">
            <div id="comment-count">
                <img src="<%=contextPath%>/images/chat.png" alt="">
                <span>댓글 count</span>
            </div>
            <button>
                <img src="<%=contextPath%>/images/link.png" alt="">
                <span>공유</span>
            </button>
        </div>

        <!-- 댓글 반복문 돌려주세요!! -->
        <div class="community-comment-list-insert">
            <div id="community-comment-list">
                <div id="community-comment-user-img"><img src="<%=contextPath%>/images/cat1_img.png"></div>
                <div>
                    <p>닉네임</p>
                    <p>오.. 고양이 귀여워요</p>
                    <div>
                        <p>등록일 시간</p>
                        <button>수정</button>
                        <button>삭제</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../common/footer.jsp" %>
</body>
</html>