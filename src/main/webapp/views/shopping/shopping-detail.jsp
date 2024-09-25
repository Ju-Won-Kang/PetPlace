<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>상품 상세</title>
    <link rel="stylesheet" href="css/shopping-detail.css"> <!-- css연결 -->
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
                    <img id="stars" src="<%=contextPath %>/images/stars.png" alt=""><p id="review">1000개 상품평</p>
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
                        <div>3000원 <div>2만원이상 구매시 무료</div></div>
                    </div>
                </div>
            </div>
            <hr>


            <div>
                <div id="product-info-title"><h4><b>상품 정보</b></h4></div>
                
                <table>
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
                <hr>
            </div>
            <div>
                <h4><b>상품 수량</b></h4>
                <div id="btn-wrap">
                    <input type="button" class="minus" value="-"></input>
                    <input type="text" id="product-count" value="1" >
                    <input type="button" class="plus" value="+"></input>
                </div>
                <div></div>

            </div>
            <div></div>

        </div>

    </div>
    
    
    
</body>
</html>