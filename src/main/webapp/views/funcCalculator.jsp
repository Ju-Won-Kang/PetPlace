<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetPlace - 계산기</title>
    <link rel="stylesheet" href="">
    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
</head>
<body>
    <%@include file="views/common/nav.jsp" %>

    <div class="wrap">
        <div class="option">
            <button>표준체중</button> |
            <button>권장칼로리</button> |
            <button>권장사료량</button>
        </div>
		
		<!-- ************************** Weight 계산기 ****************************-->
        <div>
            <table border="1" class="dog-table">
                <caption>Body condition Score for Dogs</caption>
                <tr>
                    <td>갈비뼈, 요추, 골반 뼈 그리고 모든 뼈 융기가 드러나며 체지방이<br>
                        보이지 않으며 명백한 근육 손실이 보인다.
                    </td>
                </tr>
                <tr>
                    <td>갈비뼈, 요추, 골반 뼈가 쉽게 보이며 지방이 만져지지 않으며 몇<br>
                        몇 뼈 융기가 보이고 근육량의 적은 감소가 보인다.
                    </td>
                </tr>
                <tr>
                    <td>갈비뼈가 쉽게 만져지며 만져지는 지방이 적다. 요추의 끝이 보이<br>
                        며 골반 뼈 융기가 나타나고 허리와 복부가 홀쭉해진다.
                    </td>
                </tr>
                <tr>
                    <td>적당한 지방이 덮힌 갈비뼈가 쉽게 촉진되고 허리가 쉽게 구분되며<br>
                        옆에서 봤을 때 배가 들어가 있다.
                    </td>
                </tr>
                <tr>
                    <td>과도한 지방 없이 갈비뼈가 만져지며 위에서 봤을 때 갈비뼈 뒤에<br>
                        서 허리가 보이며 옆에서 봤을 때 배가 들어가 있다.
                    </td>
                </tr>
                <tr>
                    <td>경미하게 지방이 덮힌 갈비뼈가 만져지며 허리가 구분되지 않으나<br>
                        튀어나오지는 않았다. 복부가 들어가 있어 구분이 된다.
                    </td>
                </tr>
                <tr>
                    <td>지방에 덮혀있어 갈비뼈를 만지기 힘들다. 요추와 몸 쪽 꼬리 부<br>
                        분에 지방의 축적이 보인다. 허리를 구분하기 힘들다. 배는 아직<br>
                        들어가있다.
                    </td>
                </tr>
                <tr>
                    <td>많은 지방이 덮고 있어 갈비뼈가 만져지지 않으며 요추와 몸 쪽<br>
                        꼬리 부분에 많은 지방이 축적되어 살이 접힌다. 허리와 배가 <br>
                        구분이 안된다. 명백한 복부의 팽창이 보인다.
                    </td>
                </tr>
                <tr>
                    <td>매우 많은 양의 지방이 목, 척추, 몸 쪽 꼬리에 축적되어 살이<br>
                        접히며 허리, 배가 구분이 안된다. 사지에도 지방이 축적되며<br>
                        복부 팽창이 있다.
                    </td>
                </tr>
            </table>

            <table border="1" class="cat-table"></table>
                <caption>Body condition Score for Cats</caption>
                <tr>
                    <td>갈비뼈가 쉽게 보이며 지방은 만져지지 않고 복부가 홀쭉하며<br>
                        엉덩이뼈 뼈날개가 쉽게 만져지는 상태
                    </td>
                </tr>
                <tr>
                    <td>갈비뼈가 쉽게 보이며 요추가 주변 근육 위축과 함께 확실히 보<br>
                        이고 복부가 홀쭉하며 지방이 만져지지 않는 상태
                    </td>
                </tr>
                <tr>
                    <td>약간의 지방과 함께 갈비뼈가 만져지며 요추가 보이고 갈비뼈<br>
                        뒤에 허리가 구분되며 최소한의 복부 지방이 있는 상태
                    </td>
                </tr>
                <tr>
                    <td>약간의 지방과 함께 갈비뼈가 만져지며 갈비뼈 뒤에 허리가 구<br>
                        분되며 복부가 조금 홀쭉하고 복부 지방이 얇게 있는 상태
                    </td>
                </tr>
                <tr>
                    <td>갈비뼈 뒤에 허리가 보이며 약간 지방이 덮인 갈비뼈가 만져지<br>
                        고 최소한의 복부 지방이 있는 균형잡힌 상태
                    </td>
                </tr>
                <tr>
                    <td>조금 많은 지방이 덮여 있고 갈비뼈가 만져지며 허리와 복부가<br>
                        구분이 되나 명확하지 않은 상태
                    </td>
                </tr>
                <tr>
                    <td>조금 많은 지방이 덮여 있고 갈비뼈가 쉽게 만져지지 않으며<br>
                        허리가 쉽게 구분되지 않으며, 복부가 동그랗게 보이며 복부<br>
                        지방체가 커진 상태
                    </td>
                </tr>
                <tr>
                    <td>많은 지방으로 인해 갈비뼈가 만져지지 않으며 복부 지방이<br>
                        많아 동그랗게 보이며, 요추 주변에도 지방이 축적된 상태<br>
                    </td>
                </tr>
                <tr>
                    <td>심각한 지방으로 인해 갈비뼈가 만져지지 않으며 요추, 얼굴,<br>
                        사지에 지방이 축적되어 복부팽만으로 허리가 보이지 않고 복<br>
                        부 지방이 과도하게 축적된 상태
                    </td>
                </tr>
            </table>

            <div>
                <div>
                    <div>
                        <button>강아지</button>
                    </div>
                    <div>
                        <button>고양이</button>
                    </div>
                </div>
                <table class="pet-value">
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
                <div>
                    <button>측정하기</button>
                </div>
            </div>
        </div>
        
        <!-- ************************** Calory 계산기 ****************************-->
		<div id="dog1-img"></div>
        <div id="cat1-img"></div>

        <div>
            <div>
                <table>
                    <tr>
                        <th>강아지의 상황</th>
                        <th>수치</th>
                    </tr>
                    <tr class="pet-age">
                        <td>이유식 ~ 4개월령</td>
                        <td>3</td>
                    </tr>
                    <tr class="pet-age">
                        <td>4개월령 ~ 성견</td>
                        <td>2</td>
                    </tr>
                    <tr class="pet-age">
                        <td>노령견</td>
                        <td>1.4</td>
                    </tr>
                    <tr class="pet-neuter">
                        <td>중성화하지 않은 경우</td>
                        <td>1.8</td>
                    </tr>
                    <tr class="pet-neuter">
                        <td>중성화한 경우</td>
                        <td>1.6</td>
                    </tr>
                    <tr class="pet-weight">
                        <td>과체중</td>
                        <td>1.4</td>
                    </tr>
                    <tr class="pet-weight">
                        <td>비만</td>
                        <td>1</td>
                    </tr>
                    <tr class="pet-preg">
                        <td>임신 전반 24일간</td>
                        <td>1.8</td>
                    </tr>
                    <tr class="pet-preg">
                        <td>임신 후반 21일간</td>
                        <td>3</td>
                    </tr>
                </table>    
            </div>

            <div>
                <div>
                    <div>
                        <button>강아지</button>
                    </div>
                    <div>
                        <button>고양이</button>
                    </div>
                </div>
                <table class="pet-value">
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
                <div>
                    <button>측정하기</button>
                </div>
            </div>
        </div>

    </div>
    
    <!-- ************************** Calory 계산기 ****************************-->
    
    
    <!-- ************************** 계산기 결과 ****************************-->
    <div id="result"></div>
    
    <%@include file="views/common/footer.jsp"%>
</body>
</html>