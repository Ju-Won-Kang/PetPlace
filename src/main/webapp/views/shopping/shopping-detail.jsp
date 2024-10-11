<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
  
 <%@ page import="java.sql.*" %>
 <%@ page import="java.util.ArrayList, com.petplace.shopping.model.dto.ShoppingDetailList" %>
<%
    ArrayList<ShoppingDetailList> list = (ArrayList<ShoppingDetailList>)(request.getAttribute("product"));
    for(ShoppingDetailList item : list){
        System.out.println(item.getFileLevel());
    }
    int fileL = list.get(0).getFileLevel();
%>
<%
    
    int starRating = 0; 
    if (list != null && list.size() > 0) {
        starRating = list.get(0).getFileLevel(); // 예시로 첫 번째 항목의 fileLevel 값을 사용
    }
%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>상품 상세</title>
    <link rel="stylesheet" href="css/shopping/shopping-detail.css"> <!-- css연결 -->
</head>
<body>
    <%@include file="../common/nav.jsp"%>

    <div id="body-wrap">
        <div id="left-body">
            <div id="mainFood"> 
                <c:forEach var="i" begin="0" end="${product.size()}" step="1">
                    <c:if test="${product[i].fileLevel == 1}">
                        <img src="${product[i].productImg}" alt="">
                    </c:if>
                </c:forEach>
            </div>
            <div id="subFoods">
                <div class="subFood-img"></div>
                <div class="subFood-img"></div>
                <div class="subFood-img"></div>
                <div class="subFood-img"></div>
            </div>
        </div>
        <div id="right-body">
            <div id="main-info">
                <div id="main-info-top">
                    <div id="main-info-top-title"><b>${product[0].productName}</b></div>
                    <div><img id="jjim" src="<%=contextPath %>/images/jjim.png" alt="찜"></div>
                </div>
                <div id="main-info-bottom-star">
                    <!-------------- 별점 출력  ----------->
                    <div id="starDiv"></div><p id="review">&nbsp${product[0].reviewCount}개 상품평</p>
                </div>

            </div>
            <hr>
            <div id="priceInfo">
                <div id="price">
                    <div id="bigPrice">${product[0].price}원</div>
                    <div id="smallPrice"><p id="100gPrice"></p></div>     <!--스크립트 상품가격/(중량*10)-->
                </div>
                <div id="delivery-info">
                    <div id="delivery-company">
                        <div class="firstTd">택배사</div>
                        <div>대한통운</div>
                    </div>
                    <div id="delivery-price">
                        <div class="firstTd">배송비</div>
                        <div>3000원 <div id="free-del-price"></div></div>
                    </div>
                </div>
            </div>
            <hr>
            <div>
                <div id="product-info-title"><h4><b>상품 정보</b></h4></div>
                <table id="product-table">
                    <tr class="product-info">
                        <td>주 원료</td>
                        <td>${product[0].ingredient}</td>
                    </tr>
                    <tr class="product-info">
                        <td>원산지</td>
                        <td>${product[0].origin}</td>
                    </tr>
                    <tr class="product-info">
                        <td>중량</td>
                        <td id="productWeight">${product[0].productWeight}kg  </td>
                    </tr>
                    <tr class="product-info">
                        <td>칼로리</td>
                        <td>${product[0].kcal}kcal</td>
                    </tr>
                </table>
                <hr>
            </div>
            <form action="<%=contextPath%>/shoppingPurchase.do">
                <div id="prouduct-count-wrap">
                    <h4><b>상품 수량</b></h4>
                    <div id="btn-wrap">
                        <input type="number" id="productCount" name="productCount" value="1" min="1" max="10" width="50px" >
                        <div id="totalPrice" class="price" >${product[0].price}원</div>  <!--"원"까지 들어갈 것 같아서 hidden으로 전송-->
                    </div>
                </div>
                <!-- 숨겨진 필드로 상품정보 전송 -->
                <input type="hidden" name="productNo" value="${product[0].productNo}">
                <input type="hidden" name="productName" value="${product[0].productName}">
                <input type="hidden" name="productPrice" value="${product[0].price}">

                <div id="shopping-buttons">
                    <button id="buy-btn">구매하기</button>
                </div>
            </form>
        </div>
    </div>

    <div id="bottom-body">
        <div id="bottom-body-1Line">
            <div id="pro-detail-review-QNA">
                <div>상품상세</div>
                <div>리뷰</div>
<%--                <div onclick="">Q & A</div>--%>
                <c:choose>
                    <c:when test="${empty loginUser}">
                        <button type="button" class="btn btn-secondary btn-sm" data-bs-toggle="modal"
                                data-bs-target="#inquiryModal" disabled>Q & A
                        </button>
                    </c:when>
                    <c:otherwise>
                        <button type="button" class="btn btn-secondary btn-sm" data-bs-toggle="modal"
                                data-bs-target="#inquiryModal">Q & A
                        </button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <div id="detailInfoImg">
            <c:forEach var="i" begin="0" end="${product.size()}" step="1">
                <c:if test="${product[i].fileLevel == 2}">
                    <img src="${product[i].productImg}" alt="">
                </c:if>
            </c:forEach>
        </div>

    </div>

    <a href="<%=contextPath%>/shopping.do?cpage=1">기타</a>

   
    <script> 
    // <!-----------------------별 출력 ------------------------>
        let contextPath = '<%= request.getContextPath() %>';
        let review_Count = parseInt(document.getElementById("review").textContent);


        let starRating = 3; // 임시로 별점3점 넣어둠
        if(review_Count==0){    //리뷰가 0개면 빈 별
            starRating = 0;
        }

        const maxRating = 5;
        const starRatingDiv = document.getElementById("starDiv");
        starRatingDiv.innerHTML = ''; // 이전에 추가된 별 이미지가 있으면 삭제

        for (let i = 0; i < starRating; i++) {
           // 별 이미지를 위한 img 요소 생성
           const starImg = document.createElement("img");
            starImg.src = contextPath + "/images/fullStar.png";
            starImg.alt = "star";
            starImg.classList.add("star");

            // starDiv에 별 이미지 추가
            starRatingDiv.appendChild(starImg);
        }

        // 빈 별 출력
        for (let i = Math.floor(starRating); i < maxRating; i++) {
            const emptyStarImg = document.createElement("img");
            emptyStarImg.src = contextPath + "/images/emptyStar.png"; // 빈 별 이미지 경로
            emptyStarImg.alt = "빈 별";
            emptyStarImg.classList.add("star");
            starRatingDiv.appendChild(emptyStarImg);
        }
        
        // -----------------------------------상품 수량 가격-----------------------------------
        const productPrice = parseInt(document.getElementById("bigPrice").textContent.trim(), 10);


        const shippingCost = 3000; // 기본 배송비
        const freeShippingThreshold = 20000; // 무료 배송 기준 금액

        const productCountInput = document.getElementById("productCount");
        const totalPriceElement = document.getElementById("totalPrice");

        function updatePrice() {
            const productCount = parseInt(productCountInput.value); 
            const totalProductPrice = productPrice * productCount;
            let finalPrice = totalProductPrice;
            totalPriceElement.textContent = finalPrice.toLocaleString() + "원";
        }

        productCountInput.addEventListener("input", updatePrice);

        window.onload = function() {
            updatePrice();
        };
// -----------------------------------1000단위 , 삽입---------------------------------
        const priceElement = document.getElementById("bigPrice");

        // 텍스트 내용을 가져와 숫자만 추출 (숫자 아닌 부분은 제거)
        const priceValue = parseInt(priceElement.textContent,10);

        // 숫자로 변환된 가격에 toLocaleString() 적용 후 다시 출력
        priceElement.textContent = priceValue.toLocaleString() + "원";

// -----------------------------------100g당 가격-----------------------------------
        window.onload = function() {
        // 상품 가격 추출
        const productPriceText = document.getElementById("bigPrice").textContent.trim();
        const productPrice = parseInt(productPriceText.replace(/,/g, ''), 10);

        document.getElementById("bigPrice").textContent = productPrice.toLocaleString() + "원";

        const productWeightText = document.getElementById("productWeight").textContent;
        const productWeightToKg = parseFloat(productWeightText);
        const productWeightInGrams = productWeightToKg * 1000;

        // 100g당 가격 계산
        const pricePer100g = Math.floor((productPrice / productWeightInGrams) * 100);

        document.getElementById("100gPrice").innerHTML = "&nbsp;100당 " + pricePer100g.toLocaleString() + "원";
}
    </script>

    <div class="modal fade" id="inquiryModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">상품 문의</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <form action="insertInquiry.in" method="post">
                    <!-- Modal body -->
                    <div class="modal-body">
                        <input type="hidden" name="productNo" value="${product[0].productNo}">
                        <input type="hidden" name="memberId" value="${loginUser.memberId}">
                        <h4>상품명 : ${product[0].productName}</h4>
                        <div class="input-group input-group-sm mb-3 w-75">
                            <span class="input-group-text">문의 제목</span>
                            <input type="text" class="form-control" name="inquiryTitle">
                        </div>
                        <div class="input-group input-group-sm mb-3 w-75">
                            <span class="input-group-text">문의 내용</span>
<%--                            <input type="text" class="form-control" name="inquiryTitle">--%>
                            <textarea name="inquiryDetail" class="form-control" cols="50" rows="6"></textarea>
                        </div>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-secondary">상품 수정</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>