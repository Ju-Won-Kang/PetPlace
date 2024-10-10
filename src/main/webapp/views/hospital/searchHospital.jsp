<%@ page import="java.util.Properties" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="com.petplace.hospital.controller.searchHospitalController" %><%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 9. 12.
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>인근 동물병원 찾기</title>
    <script src="js/hospital/Geolocation_API.js"></script>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/Logo.png"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- searchHospital CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/hospital/searchHospital.css">
    <%-- 키워드 검색용 서비스 라이브러리--%>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${apiKey}&libraries=services"></script>
</head>
<body onload="getLocation()">
    <%@include file="../common/nav.jsp" %>
    <section>
        <div class="inner-left">
            <div class="spinner-border"></div>
            <div id="list">
                <ul id="placesList"></ul>
                <div id="pagination"></div>
            </div>
        </div>
        <div id="map">
            <div id="map-load-wrap">
                <img src="${pageContext.request.contextPath}/images/Map_loading.gif" id="map-load">
            </div>
        </div>
        <p id="status"></p>

    </section>
</body>
</html>
