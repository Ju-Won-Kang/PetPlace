<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page import="com.petplace.shopping.model.dto.UserInfo" %>
<% 
    UserInfo userInfo = (UserInfo)(request.getAttribute("userInfo"));
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="css/shopping/shopping-purchase.css">
</head>
<body>
    <%@include file="../common/nav.jsp"%>
    <div id="body-wrap">
        <br><br>
        <h1 id="headTitle">주문/결제</h1>
        <hr id="headHr"> <br>
        <h4>구매자 정보</h4>
        <table id="purchaser-table">
            <tr>
                <td>이름</td>
                <td>${userInfo.userName}</td>
            </tr>
            <tr>
                <td>이메일</td>
                <td></td>
            </tr>
            <tr>
                <td>연락처</td>
                <td>${userInfo.phone}</td>
            </tr>
            <tr>
                <td>배송주소</td>
                <td>${userInfo.address}</td>
            </tr>
            <tr>
                <td>배송 요청사항</td>
                <td><input type="text" name="request"></td>
            </tr>
        </table>
        <br>
        
        <h4>결제 정보</h4>
        <table id="payInfo-table">
            <tr>
                <td>총 상품가격</td>
                <td><fmt:formatNumber value="${totalProductPrice}" pattern="#,###"/>원</td>
            </tr>
            <tr>
                <td>배송비</td>
                <td>3,000원</td>
            </tr>
            <tr>
                <td>총 결제금액</td>
                <td><fmt:formatNumber value="${amountPrice}" pattern="#,###"/>원</td>
            </tr>
        </table>

        <br>
        <h4>결제 수단</h4>
        <form action="shoppingComplete.do?pno=${productNo}">
            <input type="hidden" name="productCount" value="${productCount}">  <!--변수명 체크필요-->
            <table id="pay-method">
                <tr>
                    <td>은행사</td>
                    <td>
                        <select>
                            <option value="카카오">카카오</option>
                            <option value="국민">국민</option>
                            <option value="신한">신한</option>
                            <option value="하나">하나</option>
                            <option value="우리">우리</option>
                            <option value="농협">농협</option>
                            <option value="기업">기업</option> 
                        </select>
                    </td>
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
            <br><br>
            <input id="payment-btn" type="submit" value="결제하기">
        </form>
    </div>
</body>
</html>