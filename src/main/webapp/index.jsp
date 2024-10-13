<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/Logo.png"/>
    <title>PetPlace - 펫플레이스(반려동물 종합 플랫폼)</title>
    <link rel="stylesheet" href="css/common/index.css">
    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
</head>
<body>
    <%@include file="views/common/nav.jsp" %>



    <div class="wrap">
        <!-- content -->
        <div class="content">
            <div class="left-content">
                <div id="adopt">
                    <div id="adopt-info">
                        <p>입양 정보</p>
                        <a href="<%=contextPath%>/adoptList.do?cpage=1&boardType=B">더보기+</a>
                    </div>
                    <div id="adopt-img">
                        <!-- swiper js -->
                        <div class="swiper adoption-swiper">
                            <div class="swiper-wrapper" id="distribute-area">
								<div class="spinner-border"></div>
                            </div>
                            <div class="swiper-pagination"></div>
                        </div>
                        <!-- Swiper JS -->
                        <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

                        <!-- Initialize Swiper -->
                        <script>
                            function selectDistributeList(){
                                $.ajax({
                                    url : "adoptDistributeMainList.do",
                                    contentType: "application/json",
                                    data : {
                                    },
                                    success : function(res){
                                    	console.log("성공!");
                                        console.log(res);
                                        const distributeList = document.querySelector('#distribute-area');
                                        const contextPath = '<%= request.getContextPath() %>';
                                        let str = "";
                                        for (let a of res) {
                                        	console.log(a);
                                            str += "<div class='swiper-slide'>"
                                                + "<a href=\"" + contextPath + "/adoptDetail.do?bno=" + a.boardNo + "&bType=" + a.boardType + "\">"
                                                + "<div class='test3'>"
                                                + "<img src=\"" + contextPath + "/" + a.adoptImg + "\">" // contextPath 사용
                                                + "</div>"
                                                + "<div class='test3-text'>"
                                                + "<p>"
                                                + a.boardDetail 
                                                + "</p>"
                                                + "</div>"
                                                + "</a>"
                                                + "</div>";
                                        }
                                        
                                        distributeList.innerHTML = str;
                                        
                                        var adoptSwiper = new Swiper(".adoption-swiper", {
                                            slidesPerView: 3,
                                            spaceBetween: 30,
                                            pagination: {
                                                el: ".swiper-pagination",
                                                clickable: true,
                                            },
                                        });
                                    },
                                    error : function(){
                                        console.log('실패')
                                    }
                                    
                                })
                            }
                        </script>
                    </div>
                </div>
				
                <div id="community">
                    <div id="notice">
                        <div id="notice-info">
                            <p>공지사항</p>
                            <a href="">더보기+</a>
                        </div>
                        <div id="notice-text">
                            <p>[필독] 공지사항 입니다.</p>
                            <p>[필독] 공지사항 입니다.</p>
                        </div>
                    </div>

                    <div class="hot-community">
                        <div id="day-hot">
                            <div id="day-hot-info">
                                <p>일간 인기글</p>
                                <a href="communityList.do?cpage=1&category=all&array=2">더보기+</a>
                            </div>
                            <div id="day-hot-text">

                            </div>
                        </div>
                        <div id="week-hot">
                            <div id="week-hot-info">
                                <p>주간 인기글</p>
                                <a href="communityList.do?cpage=1&category=all&array=2">더보기+</a>
                            </div>
                            <div id="week-hot-text">
                            </div>
                        </div>
                    </div>
                    <script>
                        window.onload = function(){
                            selectCommunityDay();
                            selectCommunityWeek();
                            selectProduct();
                            selectMissingList();
                            selectDistributeList();
                        }

                        function selectCommunityDay(){
                            $.ajax({
                                url : "communityListDay.do",
                                contentType: "application/json",
                                data : {
                                },
                                success : function(res){
                                    console.log(res)
                                    const dayCommu = document.querySelector('#day-hot-text');
                                    let str = "";
                                    for(let d of res){
                                        console.log(d.communityNo);
                                        console.log(d.communityTitle);
                                        str += "<p><a href=\"communityDetail.do?cno=" + d.communityNo + "\">" + d.communityTitle + "</a></p>";
                                    }
                                    dayCommu.innerHTML = str;
                                },
                                error : function(){
                                    console.log('실패')
                                }

                            })
                        }

                        function selectCommunityWeek(){
                            $.ajax({
                                url : "selectCommunityWeek.do",
                                contentType: "application/json",
                                data : {
                                },
                                success : function(res){
                                    console.log(res)
                                    const weekCommu = document.querySelector('#week-hot-text');
                                    let str = "";
                                    for(let w of res){
                                        str += "<p><a href=\"communityDetail.do?cno=" + w.communityNo + "\">" + w.communityTitle + "</a></p>";
                                    }
                                    weekCommu.innerHTML = str;
                                },
                                error : function(){
                                    console.log('실패')
                                }

                            })
                        }
                        function selectProduct() {
                            $.ajax({
                                url: "selectProduct.do",
                                contentType: "application/json",
                                success: function (productData) {
                                    console.log("확인용" + productData);

                                    const productEl = document.querySelector("#product");
                                    let str = "";

                                    // productData 배열을 순회하며 HTML 문자열 생성
                                    for (let product of productData) {
                                        console.log(product);
                                        console.log(product.productNo);
                                        str += '<div class="swiper-slide">' +
                                            '<a href="shoppingdetail.do?productNo=' + product.productNo + '">' +
                                            '<div class="test2">' +
                                            '<img src="' + product.productImg + '" alt="' + product.productName + '">' +
                                            '</div>' +
                                            '<div class="test2-text"></div>' +
                                            '<p>' +
                                            product.productName + ' <br>' +
                                            product.price + '원' +
                                            '</p>' +
                                            '</a>' +
                                            '</div>';
                                    }

                                    // HTML을 DOM에 추가
                                    productEl.innerHTML = str;

                                    // Swiper 재초기화 (pagination 클래스 수정)
                                    new Swiper(".product-swiper", {
                                        slidesPerView: 2,
                                        spaceBetween: 30,
                                        pagination: {
                                            el: ".swiper-pagination",  // 여기를 수정
                                            clickable: true,
                                        },
                                    });
                                },
                                error: function () {
                                    console.log('상품 요청 실패');
                                }
                            });
                        }




                    </script>
                </div>
            </div>

            <div class="right-content">
                <div class="missing">
                    <div id="missing-info">
                        <p>실종 정보</p>
                        <a href="<%=contextPath%>/adoptList.do?cpage=1&boardType=A">더보기+</a>
                    </div>
                    <div id="missing-img-text">
                        <!-- swiper js -->
                        <div class="swiper missing-swiper">
                            <div class="swiper-wrapper" id="missing-area">
								<div class="spinner-border"></div>
                            </div>
                            <div class="swiper-pagination"></div>
                        </div>
                        <!-- Swiper JS -->
                        <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

                        <!-- Initialize Swiper -->
                        <script>
                            function selectMissingList(){
                                $.ajax({
                                    url : "adoptMissingMainList.do",
                                    contentType: "application/json",
                                    data : {
                                    },
                                    success : function(res){
                                    	console.log("성공!");
                                        console.log(res);
                                        const missingList = document.querySelector('#missing-area');
                                        const contextPath = '<%= request.getContextPath() %>';
                                        let str = "";
                                        for (let a of res) {
                                        	console.log(a);
                                            str += "<div class='swiper-slide'>"
                                                + "<a href=\"" + contextPath + "/adoptDetail.do?bno=" + a.boardNo + "&bType=" + a.boardType + "\">"
                                                + "<div class='test'>"
                                                + "<img src=\"" + contextPath + "/" + a.adoptImg + "\">" // contextPath 사용
                                                + "</div>"
                                                + "<div class='test-text'>"
                                                + "<p>"
                                                + a.boardDetail 
                                                + "</p>"
                                                + "</div>"
                                                + "</a>"
                                                + "</div>";
                                        }
                                        
                                        missingList.innerHTML = str;
                                        
                                        var adoptdistributeSwiper = new Swiper(".missing-swiper", {
                                            slidesPerView: 1,
                                            spaceBetween: 30,
                                            pagination: {
                                                el: ".swiper-pagination",
                                                clickable: true,
                                            },
                                        });
                                    },
                                    error : function(){
                                        console.log('실패')
                                    }
                                    
                                })
                            }
                        </script>
                    </div>
                </div>

                <div class="hot-product">
                    <div id="product-info">
                        <p>인기 상품</p>
                        <a href="">더보기+</a>
                    </div>
                    <div id="product-img">
                        <!-- swiper js -->
                        <div class="swiper product-swiper">
                            <div class="swiper-wrapper" id="product">
                                <div class="spinner-border"></div>

                            </div>
                            <div class="swiper-pagination"></div>
                        </div>
                        <!-- Swiper JS -->
                        <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

                        <!-- Initialize Swiper -->
                        <script>
                            var swiper = new Swiper(".product-swiper", {
                                slidesPerView: 2,
                                spaceBetween: 30,
                                pagination: {
                                    el: ".swiper-pagination",
                                    clickable: true,
                                },
                            });
                        </script>
                    </div>
                </div>
            </div>

        </div>
    </div>
        <%@include file="views/common/footer.jsp"%>


</body>
</html>