<%@ page import="java.util.Properties" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="com.petplace.hospital.controller.searchHospitalServlet" %><%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 9. 12.
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Kakao 지도 시작하기</title>
    <script src="js/Geolocation_API.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        #map {
            position: relative;
        }
        .spinner-border {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
            color: #7A97CC;
        }
    </style>
</head>
<body onload="getLocation()">
    <div id="map" style="width:500px;height:400px;">
        <div class="spinner-border"></div>
    </div>
    <%-- 카카오맵 API 키 가져오기 --%>
    <%
        Properties prop = new Properties();
        String filePath = searchHospitalServlet.class.getResource("/resources/config.properties").getPath();
        prop.load(new FileInputStream(filePath));
        String apiKey = prop.getProperty("KAKAO_MAP_API_KEY");
    %>
    <%-- 카카오맵 API 키 pageScope에 저장 --%>
    <c:set var="apiKey" value="<%=apiKey%>"/>
    <button onclick="getLocation()">위치 찾기</button>
    <p id="status">위치를 찾지 못했습니다.</p>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${apiKey}"></script>

</body>
</html>
