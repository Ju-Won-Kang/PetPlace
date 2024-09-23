<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"> 
    <title>상품 목록</title>
    <link rel="stylesheet" href="css/shopping-list.css">
</head>
<body>
    <%@include file="../common/nav.jsp"%>
    <div id="menubar">
        <div id="animal-category">
            <a href="">전체</a>
            <a href="">멍멍이</a>
            <a href="">냥</a>
            <a href="">기타</a>
        </div>
        <div id="search-area">
            <input type="search">
            <input type="button" src="<%=contextPath%>/images/Search.png">
        </div>
       
    </div>
    
    <div id="menu-bottom-bar"></div>

    <div id="products">
        <div id="dogproduct-line1">

            <div class="dogFood">
               
                <div onclick="location.href='<%=contextPath%>/shoppingdetail.do'" class="dogFood-img">
    			<img class="product_1-img" src="<%=contextPath%>/images/dogproduct1.jpg" alt="프로베스트 사료"></div>

                <a href="<%=contextPath%>/shopping.do">쇼핑</a>
                <div href="<%=contextPath%>/shopping.do">쇼핑</a>
                
                </div>
                <div class="dogFood-info">
                    <p class="dogFood-name">프로베스트 독 5kg</p>
                    <p class="dogFood-price">28,000원</p>
                    <p class="dogFood-etc" id="stars">★★★★★</p>
                    <p class="dogFood-etc" id="star-after"> 16,610개 상품평</p>
                </div>
            </div>
            <div class="dogFood">
                <div class="dogFood-img"><img class="product_1-img" src="<%=contextPath%>/images/dogproduct2.jpg" alt="프로베스트 사료"></div>
                <div class="dogFood-info">
                    <p class="dogFood-name">소프트 밥 1kg</p>
                    <p class="dogFood-price">9,800원</p>
                    <p class="dogFood-etc" id="stars">★★★★★</p>
                    <p class="dogFood-etc" id="star-after"> 16,610개 상품평</p>
                </div>
            </div>
            <div class="dogFood">
                <div class="dogFood-img"><img class="product_1-img" src="<%=contextPath%>/images/dogproduct3.png" alt="프로베스트 사료"></div>
                <div class="dogFood-info">
                    <p class="dogFood-name">로얄 캐넌 3kg</p>
                    <p class="dogFood-price">15,000원</p>
                    <p class="dogFood-etc" id="stars">★★★★★</p>
                    <p class="dogFood-etc" id="star-after"> 16,610개 상품평</p>
                </div>
            </div>
            <div class="dogFood">
                <div class="dogFood-img"><img class="product_1-img" src="<%=contextPath%>/images/dogproduct4.png" alt="프로베스트 사료"></div>
                <div class="dogFood-info">
                    <p class="dogFood-name">필드스타 3kg</p>
                    <p class="dogFood-price">17,000원</p>
                    <p class="dogFood-etc" id="stars">★★★★★</p>
                    <p class="dogFood-etc" id="star-after"> 16,610개 상품평</p>
                </div>
            </div>
        </div>
        <br><br>
        <div>
        <!-- 2번째 줄 이미지들은 height가 더 길어서 css에서 height 100%으로 -->
            <div id="dogproduct-line2">
                <div class="dogFood">
                    <div class="dogFood-img"><img class="product_1-img" src="<%=contextPath%>/images/dogproduct5.png" alt="프로베스트 사료"></div>
                    <div class="dogFood-info">
                        <p class="dogFood-name">닥터도비 장 건강 2kg</p>
                        <p class="dogFood-price">28,000원</p>
                        <p class="dogFood-etc" id="stars">★★★★★</p>
                        <p class="dogFood-etc" id="star-after"> 16,610개 상품평</p>
                    </div>
                </div>
                <div class="dogFood">
                    <div class="dogFood-img"><img class="product_1-img" src="<%=contextPath%>/images/dogproduct6.png" alt="프로베스트 사료"></div>
                    <div class="dogFood-info">
                        <p class="dogFood-name">닥터도비 장 건강 2kg</p>
                        <p class="dogFood-price">12,000원</p>
                        <p class="dogFood-etc" id="stars">★★★★★</p>
                        <p class="dogFood-etc" id="star-after"> 16,610개 상품평</p>
                    </div>
                </div>
                <div class="dogFood">
                    <div class="dogFood-img"><img class="product_1-img" src="<%=contextPath%>/images/dogproduct7.png" alt="프로베스트 사료"></div>
                    <div class="dogFood-info">
                        <p class="dogFood-name">닥터도비 피부 건강 2kg</p>
                        <p class="dogFood-price">12,000원</p>
                        <p class="dogFood-etc" id="stars">★★★★★</p>
                        <p class="dogFood-etc" id="star-after"> 16,610개 상품평</p>
                    </div>
                </div>
                <div class="dogFood">
                    <div class="dogFood-img"><img class="product_1-img" src="<%=contextPath%>/images/dogproduct8.png" alt="프로베스트 사료"></div>
                    <div class="dogFood-info">
                        <p class="dogFood-name">닥터도비 관절 건강 2kg</p>
                        <p class="dogFood-price">12,000원</p>
                        <p class="dogFood-etc" id="stars">★★★★★</p>
                        <p class="dogFood-etc" id="star-after"> 16,610개 상품평</p>
                    </div>
                </div>
            </div>

            <br>
            <br><br>
            <div id="buttons" align="center">
                <button onclick="">&Lt;</button>
                <button onclick="">1</button>
                <button onclick="">2</button>
                <button onclick="">3</button>
                <button onclick="">4</button>
                <button onclick="">5</button>
                <button onclick="">6</button>
                <button onclick="">7</button>
                <button onclick="">8</button>
                <button onclick="">9</button>
                <button onclick="">10</button>
                <button onclick="">&gt;</button>



            </div>

        </div>
    </div>

    <%@include file="../common/footer.jsp"%>
</body>
</html>