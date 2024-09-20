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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>인근 동물병원 찾기</title>
    <script src="js/hospital/Geolocation_API.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- searchHospital CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/hospital/searchHospital.css">
    <style>

    </style>
</head>
<body onload="getLocation()">
    <%@include file="/views/common/nav.jsp"%>
    <section>

        <div id="map">
            <div class="spinner-border"></div>
        </div>
        <%-- 카카오맵 API 키 가져오기 --%>
        <%
            Properties prop = new Properties();
            String filePath = searchHospitalServlet.class.getResource("/config.properties").getPath();
            prop.load(new FileInputStream(filePath));
            String apiKey = prop.getProperty("KAKAO_MAP_API_KEY");
        %>
        <%-- 카카오맵 API 키 pageScope에 저장 --%>
        <c:set var="apiKey" value="<%=apiKey%>"/>
    <%--    <button onclick="getLocation()">위치 찾기</button>--%>
        <p id="status"></p>
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${apiKey}"></script>
    </section>
<%--    <%@include file="/views/common/footer.jsp"%>--%>
</body>
</html>
