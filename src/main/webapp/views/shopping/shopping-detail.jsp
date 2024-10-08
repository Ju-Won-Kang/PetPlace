<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <img src="<%=contextPath%>/images/dogproduct1.jpg" alt="상품 이미지">

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
                    <div id="main-info-top-title"><b>Soft밥(소고기3kg)</b></div>
                    <div><img id="jjim" src="<%=contextPath %>/images/jjim.png" alt="찜"></div>

                </div>
                <div id="main-info-bottom">
                    <img id="stars" src="<%=contextPath %>/images/stars.jpg" alt=""><p id="review">1000개 상품평</p>
                </div>
            </div>
            <hr>
            <div id="priceInfo">
                <div id="price">
                    <div id="bigPrice">22,000원</div>
                    <div id="smallPrice">(100g 220원)</div>
                </div>
                <div id="delivery-info">
                    <div id="delivery-company">
                        <div>택배사</div>
                        <div>택배사 명</div>
                    </div>
                    <div id="delivery-price">
                        <div>배송비</div>
                        <div>3000원 <div id="free-del-price">2만원이상 구매시 무료</div></div>
                    </div>
                </div>
            </div>
            <hr>


            <div>
                <div id="product-info-title"><h4><b>상품 정보</b></h4></div>
                
                <table id="product-table">
                    <tr class="product-info">
                        <td>주 원료</td>
                        <td>소고기</td>
                    </tr>
                    <tr class="product-info">
                        <td>원산지</td>
                        <td>호주</td>
                    </tr>
                    <tr class="product-info">
                        <td>중량</td>
                        <td>3kg</td>
                    </tr>
                    <tr class="product-info">
                        <td>칼로리</td>
                        <td>xx kcal</td>
                    </tr>
                </table>
                <hr>
            </div>
            <div>
                <table>
                    <h4><b>상품 중량</b></h4>
                    <tr>
                        <div id="product-btr">
                            <button>1 kg</button>
                            <button>3 kg</button>
                            <button>5 kg</button>
                        </div>
                    </tr>
                </table>
            </div>
            
            <hr>

            <div id="prouduct-count-wrap">
                <h4><b>상품 수량</b></h4>
                <div id="btn-wrap">
                    <input type="number" id="product-count" value="1" width="50px" >
                    <div>22,000원</div>
                </div>
            </div>
            <div id="shopping-buttons">
                <button id="shopping-cart">장바구니</button>
                <button id="buy-btn">구매하기</button>
            </div>
        </div>
    </div>

    <div id="bottom-body">
        <div id="bottom-body-1Line">
            <div id="pro-detail-review-QNA">
                <div>상품상세</div>
                <div>리뷰</div>
                <div>Q & A</div>
            </div>
        </div>
        <div></div>
        <div></div>

    </div>
    <div id="ddd"> <!-- 스티키헤더 만들기 -->

    </div>
    
    <img id="stars" src="<%=contextPath %>/images/test.jpg" alt="">
    
</body>
</html>