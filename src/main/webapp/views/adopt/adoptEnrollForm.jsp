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
<link rel="stylesheet" href="css/adopt/adoptEnrollForm.css">
<title>입양</title>
</head>
<body>
	<%@include file="../common/nav.jsp" %>
  <br>
  <form action="<%=contextPath%>/adoptInsert.do" method="post" enctype="multipart/form-data">
    <input type="hidden" name="memberId" value="${loginUser.memberId }">
    <div id="title-form">
      <select name="boardType" required onchange="handleOptionChange(this)">
        <option value="" selected disabled hidden>게시판 종류</option>
        <option value="A" onclick="missingOption()">유기/실종</option>
        <option value="B" onclick="distributeOption()">분양</option>
      </select>
      <select name="category" required>
        <option value="" selected disabled hidden>카테고리</option>
        <option value="개">개</option>
        <option value="고양이">고양이</option>
        <option value="기타">기타</option>
      </select>
      &nbsp;&nbsp;&nbsp;
      <div class="place-title">
        <label>
          <b>제목</b>&nbsp;
          <input type="text" name="title" size="110" required>
        </label>
        <label>
          <b>위치</b>&nbsp;
          <input type="text" name="place" size="48" placeholder="(도/시/구)" required>
        </label>
        <label>
          <b>발견날짜</b>&nbsp;
          <input type="text" name="findDate" size="47" disabled>
        </label>
      </div>
    </div>
    <br>
    <div id="content-form">
      <div>
        <textarea name="detail" id=""></textarea>
        <br>
        <input type="file" name="aimg">
      </div>
      
    </div>
    <br>
    <div id="content-btn">
      <div id="submit-btn"><input type="submit" value="작성"></div>
      <div id="reset-btn"><input type="reset" value="취소"></div>
    </div>
    </form>
    
    <script>
	    function handleOptionChange(selectElement) {
	        const findDate = document.querySelector("input[name='findDate']");
	        if (selectElement.value === "A") {
	            findDate.disabled = false; // '실종/유기' 선택 시 활성화
	        } else if (selectElement.value === "B") {
	            findDate.disabled = true; // '분양' 선택 시 비활성화
	        }
	    }
    </script>
    
	<%@include file="../common/footer.jsp" %>
</body>
</html>