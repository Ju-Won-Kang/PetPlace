<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetPlace - 계산기</title>
    <link rel="stylesheet" href="css/funcCalculator.css">
    <script type="text/javascript" src="js/funcCalculator.js"></script>
</head>
<body>
    <%@ include file="/views/common/nav.jsp" %>

    <div class="wrap">
        <div class="option">
            <button id="weight-btn" onclick="weightBtn()">표준체중&nbsp;&nbsp;</button>
            <button id="calory-btn" onclick="caloryBtn()">&nbsp;&nbsp;권장칼로리&nbsp;&nbsp;</button>
            <button id="feed-btn" onclick="feedBtn()">&nbsp;&nbsp;권장사료량</button>
        </div>

		<!-- ************************** content 계산기 ****************************-->

        <div class="content">

        <!-- ************************** Weight 계산기 ****************************-->
            
            <div id="weight-content" class="weight-content">
                <div class="left-content">
                    <table id="dog-table" class="dog-table">
                        <tr>
                            <td colspan="2"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Body condition Score for Dogs</b><br><br></td>
                        </tr>
                        <tr>
                            <th>1</th>
                            <td>
                                갈비뼈, 요추, 골반 뼈 그리고 모든 뼈 융기가 드러나며 체지방이 보이지 않으며 명백한 근육 손실이 보이는 상태
                            </td>
                        </tr>
                        <tr>
                            <th>2</th>
                            <td>
                                갈비뼈, 요추, 골반 뼈가 쉽게 보이며 지방이 만져지지 않으며 몇몇 뼈 융기가 보이고 근육량의 적은 감소가 보이는 상태
                            </td>
                        </tr>
                        <tr>
                            <th>3</th>
                            <td>
                                갈비뼈가 쉽게 만져지며 만져지는 지방이 적고 요추의 끝이 보이며 골반 뼈 융기가 나타나고 허리와 복부가 홀쭉한 상태.
                            </td>
                        </tr>
                        <tr>
                            <th>4</th>
                            <td>
                                적당한 지방이 덮힌 갈비뼈가 쉽게 촉진되고 허리가 쉽게 구분되며 옆에서 봤을 때 배가 들어간 상태.
                            </td>
                        </tr>
                        <tr>
                            <th>5</th>
                            <td>
                                과도한 지방 없이 갈비뼈가 만져지며 위에서 봤을 때 갈비뼈 뒤에서 허리가 보이며 옆에서 봤을 때 배가 들어간 상태.
                            </td>
                        </tr>
                        <tr>
                            <th>6</th>
                            <td>
                                경미하게 지방이 덮힌 갈비뼈가 만져지며 허리가 구분되지 않으나 튀어나오지는 않았고 복부가 들어가 있어 구분이 되는 상태.
                            </td>
                        </tr>
                        <tr>
                            <th>7</th>
                            <td>
                                지방에 덮혀있어 갈비뼈를 만지기 힘들며 요추와 몸 쪽 꼬리 부분에 지방의 축적이 보이고 허리를 구분하기 힘들며 배는 아직 들어가있는 상태.
                            </td>
                        </tr>
                        <tr>
                            <th>8</th>
                            <td>
                                많은 지방이 덮고 있어 갈비뼈가 만져지지 않으며 요추와 몸 쪽 꼬리 부분에 많은 지방이 축적되어 살이 접히고 허리와 배가 구분이 안되며 명백한 복부의 팽창이 보이는 상태.
                            </td>
                        </tr>
                        <tr>
                            <th>9</th>
                            <td>
                                매우 많은 양의 지방이 목, 척추, 몸 쪽 꼬리에 축적되어 살이 접히며 허리, 배가 구분이 안되고 사지에도 지방이 축적되며 복부 팽창이 있는 상태.
                            </td>
                        </tr>
                    </table>


                    <table id="cat-table" class="cat-table">
                        <tr>
                            <td colspan="2"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Body condition Score for Cats</b><br><br></td>
                        </tr>
                        <tr>
                            <th>1</th>
                            <td>
                                갈비뼈가 쉽게 보이며 지방은 만져지지 않고 복부가 홀쭉하며 엉덩이뼈 뼈날개가 쉽게 만져지는 상태
                            </td>
                        </tr>
                        <tr>
                            <th>2</th>
                            <td>
                                갈비뼈가 쉽게 보이며 요추가 주변 근육 위축과 함께 확실히 보이고 복부가 홀쭉하며 지방이 만져지지 않는 상태
                            </td>
                        </tr>
                        <tr>
                            <th>3</th>
                            <td>
                                약간의 지방과 함께 갈비뼈가 만져지며 요추가 보이고 갈비뼈 뒤에 허리가 구분되며 최소한의 복부 지방이 있는 상태
                            </td>
                        </tr>
                        <tr>
                            <th>4</th>
                            <td>
                                약간의 지방과 함께 갈비뼈가 만져지며 갈비뼈 뒤에 허리가 구분되며 복부가 조금 홀쭉하고 복부 지방이 얇게 있는 상태
                            </td>
                        </tr>
                        <tr>
                            <th>5</th>
                            <td>
                                갈비뼈 뒤에 허리가 보이며 약간 지방이 덮인 갈비뼈가 만져지고 최소한의 복부 지방이 있는 균형잡힌 상태
                            </td>
                        </tr>
                        <tr>
                            <th>6</th>
                            <td>
                                조금 많은 지방이 덮여 있고 갈비뼈가 만져지며 허리와 복부가 구분이 되나 명확하지 않은 상태
                            </td>
                        </tr>
                        <tr>
                            <th>7</th>
                            <td>
                                조금 많은 지방이 덮여 있고 갈비뼈가 쉽게 만져지지 않으며 허리가 쉽게 구분되지 않으며, 복부가 동그랗게 보이며 복부 지방체가 커진 상태
                            </td>
                        </tr>
                        <tr>
                            <th>8</th>
                            <td>
                                많은 지방으로 인해 갈비뼈가 만져지지 않으며 복부 지방이 많아 동그랗게 보이며, 요추 주변에도 지방이 축적된 상태
                            </td>
                        </tr>
                        <tr>
                            <th>9</th>
                            <td>
                                심각한 지방으로 인해 갈비뼈가 만져지지 않으며 요추, 얼굴, 사지에 지방이 축적되어 복부팽만으로 허리가 보이지 않고 복부 지방이 과도하게 축적된 상태
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="right-content">
                    <div class="calc">
                        <div class="pet-type-btn">
                            <div id="dog-btn">
                                <button id="dog-type-weight-btn" onclick="calcWeightDogBtn()">강아지</button>
                            </div>
                            <div id="cat-btn">
                                <button id="cat-type-weight-btn" onclick="calcWeightCatBtn()">고양이</button>
                            </div>
                        </div>
                        <table class="pet-value">
                            <tr id="weight">
                                <th>현재 몸무게</th>
                                <td><input type="text" id="now-weight" name="weight" value="0">&nbsp;kg</td>
                            </tr>
                            <tr id="bcs">
                                <th>BCS</th>
                                <td><input type="number" id="pet-bcs" name="bcs" value="0" min="1" max="9" step="1"></td>
                            </tr>
                        </table>
                        <div id="result-btn">
                            <button onclick="weightCalcBtn()">측정하기</button>
                        </div>
                    </div>
                </div> 
            </div>
           
        
        <!-- ************************** Calory 계산기 ****************************-->
            
            <div id="calory-content" class="calory-content">
                <div class="left-content">
                    <div id="left-dog-content" class="left-dog-content">
                        <div id="dog1-img"></div>
                        <table class="dog-calory-table">
                            <tr class="calory-table-title">
                                <th>강아지의 상황</th>
                                <th>수치</th>
                            </tr>
                            <tr class="dog-age">
                                <th>이유식 ~ 4개월</th>
                                <th>3</th>
                            </tr>
                            <tr class="dog-age">
                                <th>4개월 ~ 성견</th>
                                <th>2</th>
                            </tr>
                            <tr class="dog-neuter">
                                <th>중성화하지 않은 경우</th>
                                <th>1.8</th>
                            </tr>
                            <tr class="dog-neuter">
                                <th>중성화한 경우</th>
                                <th>1.6</th>
                            </tr>
                            <tr class="dog-weight">
                                <th>과체중</th>
                                <th>1.4</th>
                            </tr>
                            <tr class="dog-weight">
                                <th>비만</th>
                                <th>1</th>
                            </tr>
                            <tr class="dog-preg">
                                <th>임신 전반 24일간</th>
                                <th>1.8</th>
                            </tr>
                            <tr class="dog-preg">
                                <th>임신 후반 21일간</th>
                                <th>3</th>
                            </tr>
                            <tr class="dog-age">
                                <th>노령견</th>
                                <th>1.4</th>
                            </tr>
                        </table>    
                    </div>
                
                    <div id="left-cat-content" class="left-cat-content">
                        <div id="cat1-img"></div>
                        <table class="cat-calory-table">
                            <tr class="calory-table-title">
                                <th>고양이의 상황</th>
                                <th>수치</th>
                            </tr>
                            <tr class="cat-age">
                                <th>이유식 ~ 4개월</th>
                                <th>3</th>
                            </tr>
                            <tr class="cat-age">
                                <th>4개월 ~ 6개월</th>
                                <th>2.5</th>
                            </tr>
                            <tr class="cat-age">
                                <th>6개월 ~ 성묘</th>
                                <th>2</th>
                            </tr>
                            <tr class="cat-neuter">
                                <th>중성화하지 않은 경우</th>
                                <th>1.4</th>
                            </tr>
                            <tr class="cat-neuter">
                                <th>중성화한 경우</th>
                                <th>1.2</th>
                            </tr>
                            <tr class="cat-weight">
                                <th>과체중</th>
                                <th>0.8</th>
                            </tr>
                            <tr class="cat-weight">
                                <th>비만</th>
                                <th>1</th>
                            </tr>
                            <tr class="cat-preg">
                                <th>임신묘</th>
                                <th>3</th>
                            </tr>
                            <tr class="cat-age">
                                <th>노묘</th>
                                <th>0.7</th>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="right-content">
                    <div class="calc">
                        <div class="pet-type-btn">
                            <div id="dog-btn">
                                <button id="dog-type-calory-btn" onclick="calcCaloryDogBtn()">강아지</button>
                            </div>
                            <div id="cat-btn">
                                <button id="cat-type-calory-btn" onclick="calcCaloryCatBtn()">고양이</button>
                            </div>
                        </div>
                        <table class="pet-value">
                            <tr id="weight">
                                <th>현재 몸무게</th>
                                <td><input type="text" id="calory-weight" name="calory-weight" value="0">&nbsp;kg</td>
                            </tr>
                            <tr id="bcs">
                                <th>수치</th>
                                <td><input type="text" id="figure" name="figure" value="0"></td>
                            </tr>
                        </table>
                        <div id="result-btn">
                            <button onclick="caloryCalcBtn()">측정하기</button>
                        </div>
                    </div>
                </div> 
            </div>
           
    	
    	<!-- ************************** Feed 계산기 ****************************-->
            
            <div id="feed-content" class="feed-content">
                <div class="left-content">
                    <div class="left-pet-img">
                        <div id="dog2-img"></div>
                        <div id="cat2-img"></div>
                    </div>
                </div>
                <div class="right-content">
                    <div class="calc">
                        <div class="pet-type-btn">
                            <div id="dog-btn">
                                <button id="dog-type-feed-btn" onclick="calcFeedDogBtn()">강아지</button>
                            </div>
                            <div id="cat-btn">
                                <button id="cat-type-feed-btn" onclick="calcFeedCatBtn()">고양이</button>
                            </div>
                        </div>
                        <table class="pet-value">
                            <tr id="weight">
                                <th>권장 칼로리</th>
                                <td><input type="text" id="pet-day-calory" name="pet-day-calory" value="0">&nbsp;kcal</td>
                            </tr>
                            <tr id="bcs">
                                <th>사료 칼로리</th>
                                <td><input type="text" id="feed-day-calory" name="feed-calory" value="0">&nbsp;kcal/kg</td>
                            </tr>
                        </table>
                        <div id="result-btn">
                            <button onclick="feedCalcBtn()">측정하기</button>
                        </div>
                    </div>
                </div>
            </div>
           
        </div> 
    <!-- ************************** 계산기 결과 ****************************-->
        <div id="result"></div>
    </div>
    <%@include file="/views/common/footer.jsp"%>
</body>
</html>