<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetPlace - 입양(실종 게시판)</title>
    <link rel="stylesheet" href="css/adopt/adoptListView.css">
    
    <script type="text/javascript" src="js/adopt/adoptListView.js"></script>
</head>
<body>
    <%@ include file="/views/common/nav.jsp" %>

    <div class="content">
        <div class="adopt-type-btn">
            <button id="missing-btn" onclick="adoptMissingBtn()">유기 / 실종&nbsp;&nbsp;</button>
            <p>|</p>
            <button id="distribute-btn" onclick="adoptDistributeBtn()">&nbsp;&nbsp;분양</button>
        </div>
        <div class="find-pet-option">
            <div class="select-pet-place">
                <select id="select-pet-type" name="pet-type">
                    <option value="동물종류">동물종류</option>
                    <option value="동물종류">고양이</option>
                </select>

                <select id="select-find-place" name="place">
                    <option value="위치">위치</option>
                    <option value="위치">수원시</option>
                </select>
            </div>
            <form action="">
                <input type="text" placeholder="검색">
                <button type="submit"><img src="<%=contextPath%>/images/Search.png"></button>
                <!-- <input type="submit" value=" " src="images/Search.png"> -->
            </form>
        </div>
        <div class="missing-distribute-pet-table">
            <table id="missing-pet-table" class="missing-pet-table">
                <thead>
                    <tr class="table-line">
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
                    <tr class="table-line" onclick="detailMissingPage()">
                        <td>1</td>
                        <td><img src="<%=contextPath%>/images/image 10.png"></td>
                        <td class="table-title">
                            <p>고양이 잃어버리신 분 뱅갈 고양이</p>
                            <span>고양이 잃어버리신 분 뱅갈 고양이</span>
                        </td>                       
                        <td>경기 김포시 양촌읍</td>
                        <td>09 - 06</td>
                        <td>서유라</td>
                        <td>192</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 잃어버리신 분 찾아요</p>
                            <span>검정색 강아지 잃어버리신 분 찾아요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>04 - 12</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 잃어버리신 분 찾아요</p>
                            <span>검정색 강아지 잃어버리신 분 찾아요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>04 - 12</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 잃어버리신 분 찾아요</p>
                            <span>검정색 강아지 잃어버리신 분 찾아요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>04 - 12</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 잃어버리신 분 찾아요</p>
                            <span>검정색 강아지 잃어버리신 분 찾아요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>04 - 12</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 잃어버리신 분 찾아요</p>
                            <span>검정색 강아지 잃어버리신 분 찾아요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>04 - 12</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 잃어버리신 분 찾아요</p>
                            <span>검정색 강아지 잃어버리신 분 찾아요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>04 - 12</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 잃어버리신 분 찾아요</p>
                            <span>검정색 강아지 잃어버리신 분 찾아요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>04 - 12</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 잃어버리신 분 찾아요</p>
                            <span>검정색 강아지 잃어버리신 분 찾아요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>04 - 12</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 잃어버리신 분 찾아요</p>
                            <span>검정색 강아지 잃어버리신 분 찾아요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>04 - 12</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                </tbody>
            </table>
            <script>
                function detailMissingPage(){
                    console.log("????")
                    location.href="<%=contextPath%>/missingDetail.do";
                }
            </script>

            <table id="distribute-pet-table" class="distribute-pet-table">
                <thead>
                    <tr class="table-line">
                        <th>번호</th>
                        <th>사진</th>
                        <th>동물정보</th>
                        <th>분양장소</th>
                        <th>글쓴이</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="table-line" onclick="detailDistributePage()">
                        <td>1</td>
                        <td><img src="<%=contextPath%>/images/image 10.png"></td>
                        <td class="table-title">
                            <p>뱅갈 고양이 분양합니다~</p>
                            <span>진짜 잘생겼어요~~ 수컷이고요. 생후 10개월 된 아이에요</span>
                        </td>                       
                        <td>경기 김포시 양촌읍</td>
                        <td>서유라</td>
                        <td>192</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 분양 받아가세요~</p>
                            <span>진짜 잘생겼어요~~ 수컷이고요. 생후 10개월 된 아이에요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 분양 받아가세요~</p>
                            <span>진짜 잘생겼어요~~ 수컷이고요. 생후 10개월 된 아이에요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 분양 받아가세요~</p>
                            <span>진짜 잘생겼어요~~ 수컷이고요. 생후 10개월 된 아이에요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 분양 받아가세요~</p>
                            <span>진짜 잘생겼어요~~ 수컷이고요. 생후 10개월 된 아이에요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 분양 받아가세요~</p>
                            <span>진짜 잘생겼어요~~ 수컷이고요. 생후 10개월 된 아이에요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 분양 받아가세요~</p>
                            <span>진짜 잘생겼어요~~ 수컷이고요. 생후 10개월 된 아이에요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 분양 받아가세요~</p>
                            <span>진짜 잘생겼어요~~ 수컷이고요. 생후 10개월 된 아이에요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 분양 받아가세요~</p>
                            <span>진짜 잘생겼어요~~ 수컷이고요. 생후 10개월 된 아이에요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                    <tr class="table-line">
                        <td>2</td>
                        <td><img src="<%=contextPath%>/images/image 7.png"></td>
                        <td class="table-title">
                            <p>검정색 강아지 분양 받아가세요~</p>
                            <span>진짜 잘생겼어요~~ 수컷이고요. 생후 10개월 된 아이에요</span>
                        </td>  
                        <td>경기도 수원시 팔달구<br>
                            xx동</td>
                        <td>김지석</td>
                        <td>23</td>
                    </tr>
                </tbody>
            </table>
            <div id="missing-write-btn-area">
                <a href="">글쓰기</a>
            </div>
        </div>
        <div id="search-img">

        </div>
        <div class="page-btn">
            <button>&lt;</button>
            <button class="page-num-btn">1</button>
            <button class="page-num-btn">2</button>
            <button class="page-num-btn">3</button>
            <button class="page-num-btn">4</button>
            <button class="page-num-btn">5</button>
            <button class="page-num-btn">6</button>
            <button class="page-num-btn">7</button>
            <button class="page-num-btn">8</button>
            <button class="page-num-btn">9</button>
            <button class="page-num-btn">10</button>
            <button>&gt;</button>
        </div>
    </div>

    
    
    <%@ include file="/views/common/footer.jsp" %>
</body>
</html>
