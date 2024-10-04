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
                        <a href="">더보기+</a>
                    </div>
                    <div id="adopt-img">
                        <!-- swiper js -->
                        <div class="swiper adoption-swiper">
                            <div class="swiper-wrapper">
                                <div class="swiper-slide">
                                    <a href="">
                                        <div class="test3">
                                            <img src="images/image%207.png">
                                        </div>
                                        <div class="test3-text">
                                            <p>
                                                품종 : 푸들 <br>
                                                나이 : 7살 <br>
                                                성별 : 수컷
                                            </p>
                                        </div>
                                    </a>
                                </div>
                                <div class="swiper-slide">
                                    <a href="">
                                        <div class="test3">
                                            <img src="images/image%208.png">
                                        </div>
                                        <div class="test3-text">
                                            <p>
                                                품종 : 푸들 <br>
                                                나이 : 7살 <br>
                                                성별 : 수컷
                                            </p>
                                        </div>
                                    </a>
                                </div>
                                <div class="swiper-slide">
                                    <a href="">
                                        <div class="test3">
                                            <img src="images/image%209.png">
                                        </div>
                                        <div class="test3-text">
                                            <p>
                                                품종 : 턱시도 <br>
                                                나이 : 7살 <br>
                                                성별 : 수컷
                                            </p>
                                        </div>
                                    </a>
                                </div>
                                <div class="swiper-slide">
                                    <a href="">
                                        <div class="test3">
                                            <img src="images/image%2010.png">
                                        </div>
                                        <div class="test3-text">
                                            <p>
                                                품종 : 고등어 <br>
                                                나이 : 7살 <br>
                                                성별 : 수컷
                                            </p>
                                        </div>
                                    </a>
                                </div>
                                <div class="swiper-slide">Slide 5</div>
                                <div class="swiper-slide">Slide 6</div>
                                <div class="swiper-slide">Slide 7</div>
                                <div class="swiper-slide">Slide 8</div>
                                <div class="swiper-slide">Slide 9</div>
                            </div>
                            <div class="swiper-pagination"></div>
                        </div>
                        <!-- Swiper JS -->
                        <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

                        <!-- Initialize Swiper -->
                        <script>
                            var swiper = new Swiper(".adoption-swiper", {
                                slidesPerView: 3,
                                spaceBetween: 30,
                                pagination: {
                                    el: ".swiper-pagination",
                                    clickable: true,
                                },
                            });
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
                                <a href="">더보기+</a>
                            </div>
                            <div id="day-hot-text">
                                <p>1등글</p>
                                <p>2등글</p>
                                <p>3등글</p>
                                <p>4등글</p>
                                <p>5등글</p>
                            </div>
                        </div>
                        <div id="week-hot">
                            <div id="week-hot-info">
                                <p>주간 인기글</p>
                                <a href="">더보기+</a>
                            </div>
                            <div id="week-hot-text">
                                <p>1등글</p>
                                <p>2등글</p>
                                <p>3등글</p>
                                <p>4등글</p>
                                <p>5등글</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="right-content">
                <div class="missing">
                    <div id="missing-info">
                        <p>실종 정보</p>
                        <a href="">더보기+</a>
                    </div>
                    <div id="missing-img-text">
                        <!-- swiper js -->
                        <div class="swiper missing-swiper">
                            <div class="swiper-wrapper">
                                <div class="swiper-slide">
                                    <div id="test">
                                        <a href=""><img src="images/image%207.png"></a>
                                    </div>
                                    <div id="test-text">
                                        <p>
                                            이름 : 세바스찬<br>
                                            나이 : 7살<br>
                                            성별 : 수컷<br>
                                            특징 1. 목도리 사용중<br>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. 사람을 잘 피함<br>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. 머리 중간에 땜빵있음
                                        </p>
                                    </div>
                                </div>
                                <div class="swiper-slide"><img src="images/image%208.png"></div>
                                <div class="swiper-slide"><img src="images/image%209.png"></div>
                                <div class="swiper-slide"><img src="images/image%2010.png"></div>
                                <div class="swiper-slide">Slide 5</div>
                                <div class="swiper-slide">Slide 6</div>
                                <div class="swiper-slide">Slide 7</div>
                                <div class="swiper-slide">Slide 8</div>
                                <div class="swiper-slide">Slide 9</div>
                            </div>
                            <div class="swiper-pagination"></div>
                        </div>
                        <!-- Swiper JS -->
                        <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

                        <!-- Initialize Swiper -->
                        <script>
                            var swiper = new Swiper(".missing-swiper", {
                                slidesPerView: 1,
                                spaceBetween: 30,
                                pagination: {
                                    el: ".swiper-pagination",
                                    clickable: true,
                                },
                            });
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
                            <div class="swiper-wrapper">
                                <div class="swiper-slide">
                                    <a href="">
                                        <div class="test2">
                                            <img src="images/product1.png">
                                        </div>
                                        <div class="test2-text"></div>
                                        <p>
                                            Soft밥(소고기/3kg) <br>
                                            22,000원
                                        </p>
                                    </a>
                                </div>
                                <div class="swiper-slide">
                                    <a href="">
                                        <div class="test2">
                                            <img src="images/product2.png">
                                        </div>
                                        <div class="test2-text">
                                            <p>
                                                프로베스트 독 5kg <br>
                                                28,000원
                                            </p>
                                        </div>
                                    </a>
                                </div>
                                <div class="swiper-slide"><img src="images/image%209.png"><label>고양이</label></div>
                                <div class="swiper-slide"><img src="images/image%2010.png"><label>고양이</label></div>
                                <div class="swiper-slide">Slide 5</div>
                                <div class="swiper-slide">Slide 6</div>
                                <div class="swiper-slide">Slide 7</div>
                                <div class="swiper-slide">Slide 8</div>
                                <div class="swiper-slide">Slide 9</div>
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