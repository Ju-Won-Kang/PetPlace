<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetPlace - 입양(실종 게시판)</title>
    <link rel="stylesheet" href="css/adoptMissing.css">
    <script type="text/javascript" src="js/funcCalculator.js"></script>
</head>
<body>
    <%@ include file="/views/common/nav.jsp" %>

    <div class="content">
        <div class="adopt-type-btn">
            <button id="missing-btn">유기 / 실종&nbsp;&nbsp;</button>
            <button id="distribute-btn">&nbsp;&nbsp;분양</button>
        </div>
        <div>
            <div>
                <div></div>
                <div></div>
            </div>
            <form action="">
                <input type="text">
                <input type="submit">
            </form>
        </div>
        <div>
            <table>
                <thead>
                    <tr>
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
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            <a href="">글쓰기</a>
        </div>
        <div>
            <button>&lt;</button>
            <button>1</button>
            <button>2</button>
            <button>3</button>
            <button>4</button>
            <button>5</button>
            <button>6</button>
            <button>7</button>
            <button>8</button>
            <button>9</button>
            <button>10</button>
            <button>&gt;</button>
        </div>
    </div>
    
    <%@ include file="/views/common/footer.jsp" %>
</body>
</html>
