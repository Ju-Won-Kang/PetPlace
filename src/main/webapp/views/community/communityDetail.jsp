<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/community/communityDetail.css">
</head>
<body>
    <%@include file="../common/nav.jsp" %>
    <div class="community-info-content">
        <div class="community-info">
            <div>
                <p id="community-info-title">${c.communityTitle}</p>
            </div>
            <div id="community-info-two">
                <p id="community-info-nick">작성자: ${c.nickname}</p>
                <p id="community-info-date">작성일: ${c.communityDate}</p>
                <p id="community-recommend-count">추천수 ${c.communityGood}</p>
                <p id="community-select-count">조회수 ${c.communityView}</p>
                <c:if test="${loginUser.memberId eq c.memberId }">
                	<button onclick="location.href='communityUpdate.do?cno=${c.communityNo }'">수정</button>
                	<button onclick="location.href='communityDelete.do?cno=${c.communityNo }'">삭제</button>
                </c:if>
            </div>
        </div>
        <div class="community-content">
            <c:if test="${not empty atC.changeName}">
	            <div id="community-content-img">
	                <img src="<%=contextPath%>/${atC.filePath}${atC.changeName}">
	            </div>
	            <br><br>
            </c:if>
            <div id="community-content-write">
                <p>${c.communityDetail}</p>
            </div>
        </div>
        <br><br>
        <div class="community-recommend-type">
            <div id="community-recommend">
                <form action="communityGood.do">
                    <input type="hidden" name="cno" value="${c.communityNo }">
                    <button><img src="<%=contextPath%>/images/catnails1.png"></button>
                    <br>
                    <p>추천 ${c.communityGood}</p>
                </form>
                
            </div>
            <div id="community-none-recommend">
                <form action="communityBad.do">
                    <input type="hidden" name="cno" value="${c.communityNo }">
                    <button><img src="<%=contextPath%>/images/catnails2.png"></button>
                    <br>
                    <p>비추천 ${c.communityBad}</p>
                </form>
            </div>
        </div>
    </div>
    <br><br>
    <div class="community-reply-area">
        <div id="reply-area-etc">
            <div id="reply-count">
                <img src="<%=contextPath%>/images/chat.png" alt="">
                <span>댓글</span>
            </div>
            <button>
                <img src="<%=contextPath%>/images/link.png" alt="">
                <span onclick="copyLink()">공유</span>
            </button>
        </div>

        <!-- 댓글 반복문 돌려주세요!! -->
        <div class="community-reply-list-insert">
            <div id="comment-list">
            </div>
            <div id="community-reply-insert">
                <p>${loginUser.nickName}</p>
                <input type="hidden" name="cno" value="${c.communityNo}">
                <c:choose>
                    <c:when test="${not empty loginUser}">
                        <textarea id="reply-content" class="content-detail" style="resize: none;" name="detail" cols="50" rows="3" placeholder="댓글을 남겨보세요"></textarea>
                        <div id="comment-insert">
                            <button id="reply-content-insert" onclick="insertReply()">등록</button>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <textarea id="reply-content" class="content-detail" style="resize: none;" name="detail" cols="50" rows="3" placeholder="로그인 후 이용해주세요" disabled></textarea>
                        <div id="comment-insert">
                            <button id="reply-content-insert" onclick="insertReply()" disabled>등록</button>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
            <script>
                function copyLink() {
                    // 임시 텍스트 필드를 생성
                    var tempInput = document.createElement("input");
                    tempInput.value = window.location.href;

                    // 텍스트 필드를 body에 추가하고 선택
                    document.body.appendChild(tempInput);
                    tempInput.select();
                    tempInput.setSelectionRange(0, 99999); // 모바일 호환성

                    // URL을 클립보드로 복사
                    document.execCommand("copy");

                    // 텍스트 필드를 삭제
                    document.body.removeChild(tempInput);

                    alert("현재 URL이 복사되었습니다: " + tempInput.value);
                }

                function deleteComment(cmno, cno){
                    location.href="deletecComment.do?cmno=" + cmno + "&cno=" + cno;
                }

                const comno = ${c.communityNo};
                const contentArea = document.querySelector('.content-detail');

                window.onload = function(cno){
                    selectCommentList();
                }

                function selectCommentList(){
                    $.ajax({
                        url : "cCommentList.do",
                        contentType: "application/json",
                        data : {
                            cno : ${c.communityNo}
                        },
                        success : function(res){
                            console.log(res)
                            let str = "";
                            for (let comment of res) {
                            	if(comment.memberId == '${loginUser.memberId}'){
                            		str += "<div id=\"community-reply-list\">\n" +
                                    "<input type=\"hidden\" name=\"cmno\" value=\"" + comment.commentNo + "\">" +
                                    "<div id=\"community-reply-user-img\">\n" +
                                    "<img src=\"\">\n" +
                                    "</div>\n" +
                                    "<div id=\"nick-content-etc\">\n" +
                                    "<p id=\"reply-nick\">" + comment.nickname + "</p>\n" +
                                    "<p id=\"reply-content\">" + comment.commentDetail + "</p>" +
                                    "<div id=\"date-modify-delete\">" +
                                    "<p>" + comment.commentDate + "</p>" +
                                    "<button data-bs-toggle=\"modal\" data-bs-target=\"#modifyCommentModal\"onclick=\"setCommentNo(" + comment.commentNo + ")\">수정</button>" +
                                    "<button onclick=\"deleteComment(" + comment.commentNo + ", ${c.communityNo}" + ")\">삭제</button>" +
                                    "</div>" +
                                    "</div>" +
                                    "</div>";
                            	} else{
                            		str += "<div id=\"community-reply-list\">\n" +
                                    "<div id=\"community-reply-user-img\">\n" +
                                    "<img src=\"\">\n" +
                                    "</div>\n" +
                                    "<div id=\"nick-content-etc\">\n" +
                                    "<p id=\"reply-nick\">" + comment.nickname + "</p>\n" +
                                    "<p id=\"reply-content\">" + comment.commentDetail + "</p>" +
                                    "<div id=\"date-modify-delete\">" +
                                    "<p>" + comment.commentDate + "</p>" +
                                    "</div>" +
                                    "</div>" +
                                    "</div>";
                            	}
                                
                            }
                            const contentBody = document.querySelector("#comment-list");
                            contentBody.innerHTML = str;
                        },
                        error : function(){
                            console.log("AJAX 요청 실패")
                        }
                    })
                }
                
                function setCommentNo(commentNo) {
                    document.querySelector("#modifyCommentModal input[name='cmno']").value = commentNo;
                }

                function insertReply(){



                    $.ajax({
                        url : "commentInsert.do",
                        type : "post",
                        data : {
                            cno : comno,
                            content : contentArea.value
                        },
                        success : function(){
                            contentArea.value = "";
                            selectCommentList();
                        },
                        error : function(){
                            console.log("댓글 작성 중 ajax통신 실패")
                        }
                    })
                }
            </script>
        </div>
    </div>

    <div class="modal fade" id="modifyCommentModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">댓글 수정</h4>
                </div>

                <form action="updatecComment.do" method="post">
                <input type="hidden" name="cmno" value="">
                <input type="hidden" name="cno" value="${c.communityNo }">
                    <!-- Modal body -->
                    <div class="modal-body">
                        <textarea name="detail" id="" cols="60" rows="5" align="center" style="resize: none;"></textarea>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-secondary">댓글 수정</button>
                    </div>
                </form>
            </div>
            <script>


                const comno = ${c.communityNo};
                const contentArea = document.querySelector('.content-detail');

                window.onload = function(cno){
                    selectCommentList();
                }

                function selectCommentList(){
                    $.ajax({
                        url : "cCommentList.do",
                        contentType: "application/json",
                        data : {
                            cno : ${c.communityNo}
                        },
                        success : function(res){
                            console.log(res)
                            let str = "";
                            for (let comment of res) {
                            	if(comment.memberId == '${loginUser.memberId}'){
                            		str += "<div id=\"community-reply-list\">\n" +
                                    "<div id=\"community-reply-user-img\">\n" +
                                    "<img src=\"\">\n" +
                                    "</div>\n" +
                                    "<div id=\"nick-content-etc\">\n" +
                                    "<p id=\"reply-nick\">" + comment.nickname + "</p>\n" +
                                    "<p id=\"reply-content\">" + comment.commentDetail + "</p>" +
                                    "<div id=\"date-modify-delete\">" +
                                    "<p>" + comment.commentDate + "</p>" +
                                    "<button onclick=\"editComment(" + comment.memberNo + ")\">수정</button>" +
                                    "<button onclick=\"deleteComment(" + comment.memberNo + ")\">삭제</button>" +
                                    "</div>" +
                                    "</div>" +
                                    "</div>";
                            	} else{
                            		str += "<div id=\"community-reply-list\">\n" +
                                    "<div id=\"community-reply-user-img\">\n" +
                                    "<img src=\"\">\n" +
                                    "</div>\n" +
                                    "<div id=\"nick-content-etc\">\n" +
                                    "<p id=\"reply-nick\">" + comment.nickname + "</p>\n" +
                                    "<p id=\"reply-content\">" + comment.commentDetail + "</p>" +
                                    "<div id=\"date-modify-delete\">" +
                                    "<p>" + comment.commentDate + "</p>" +
                                    "</div>" +
                                    "</div>" +
                                    "</div>";
                            	}
                                
                            }
                            const contentBody = document.querySelector("#comment-list");
                            contentBody.innerHTML = str;
                        },
                        error : function(){
                            console.log("FUCK YOU AJAX")
                        }
                    })
                }

                function insertReply(){
                    
                    

                    $.ajax({
                        url : "commentInsert.do",
                        type : "post",
                        data : {
                            cno : comno,
                            content : contentArea.value
                        },
                        success : function(){
                            contentArea.value = "";
                            selectCommentList();
                        },
                        error : function(){
                            console.log("댓글 작성 중 ajax통신 실패")
                        }
                    })
                }
            </script>
        </div>
    </div>
    <%@include file="../common/footer.jsp" %>
</body>
</html>