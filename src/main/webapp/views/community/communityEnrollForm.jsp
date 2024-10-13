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
<link rel="stylesheet" href="css/community/communityEnrollForm.css">
<title>커뮤니티</title>
</head>
<body>
	<%@include file="../common/nav.jsp" %>
  <br>
  <form action="<%=contextPath%>/communityInsert.do" method="post" enctype="multipart/form-data">
    <input type="hidden" name="memberId" value="${loginUser.memberId }">
    <div id="title-form">
      <select name="category" required>
        <option value="" selected disabled hidden>카테고리</option>
        <option value="개">개</option>
        <option value="고양이">고양이</option>
        <option value="기타">기타</option>
      </select>
      &nbsp;&nbsp;&nbsp;
      <label>
        <b>제목</b>&nbsp;
        <input type="text" name="title" size="130" required>
      </label>
    </div>
    <br>
    <div id="content-form">
      <div>
        <textarea name="detail" id="" required></textarea>
        <br>
        <input type="file" name="cimg" vlaue="">
      </div>
      
    </div>
    <br>
    <div id="content-btn">
      <div id="submit-btn"><input type="submit" value="작성" style="border: none; background-color: white;"></div>
      <div id="reset-btn"><input type="reset" value="취소" style="border: none; background-color: white;"></div>
    </div>
    </form>
    
	<%@include file="../common/footer.jsp" %>
</body>
</html>