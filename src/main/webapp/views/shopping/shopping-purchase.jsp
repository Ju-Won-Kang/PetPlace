<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>


    <link rel="stylesheet" href="css/shopping/shopping-purchase.css"> <!-- css연결 -->
</head>
<body>
    <%@include file="../common/nav.jsp"%>
    <div id="body-wrap">
        <h1>주문/결제</h1>
        <br>
        <h2>구매자 정보</h2>
        <table id="purchaser-table">
            <tr>
                <td>이름</td>
                <td>김철수</td>
            </tr>
            <tr>
                <td>이메일</td>
                <td>asdasd@naver.com</td>
            </tr>
            <tr>
                <td>연락처</td>
                <td>010-1234-5678</td>
            </tr>
            <tr>
                <td>배송주소</td>
                <td>서울시 강남구 구구구</td>
            </tr>
            <tr>
                <td>배송 요청사항</td>
                <td>배송 전 문자 바랍니다</td>
            </tr>
        </table>

        <table id="payInfo-table">
            <tr>
                <td>총 상품가격</td>
                <td>21500원</td>
            </tr>
            <tr>
                <td>배송비</td>
                <td>3000원</td>
            </tr>
            <tr>
                <td>총 결제금액</td>
                <td>24500원</td>
            </tr>
            <tr>
                <td>결제수단</td>
                <td>카드결제</td>
                <td>카카오페이</td>
            </tr>
        </table>

        <table>
            <tr>
                <td>카드 결제</td>
                <td><button>카드사</button></td>
            </tr>
            <tr>
                <td>카드번호</td>
                <td><input type="text" placeholder="카드번호 입력"></td>
            </tr>
            <tr>
                <td>카드 비밀번호</td>
                <td><input type="text" placeholder="비밀번호 입력"></td>
            </tr>
        </table>

        <button>결제하기</button>

    </div>
</body>
</html>