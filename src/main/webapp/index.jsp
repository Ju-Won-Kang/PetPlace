<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PetPlace - 펫플레이스(반려동물 종합 플랫폼)</title>
</head>
<body>
    <button onclick="searchHospital();">동물 병원 찾기</button>
    <script>
        function searchHospital(){
            console.log(location.href);
            location.href = 'searchHospital.do';
        }
    </script>
</body>
</html>