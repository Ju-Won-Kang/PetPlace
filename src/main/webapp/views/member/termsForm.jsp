<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 10. 7.
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Place - 약관동의</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/member/termsForm.css">
    <script>
        // 약관 체크박스 상태 확인 후 버튼 활성화 여부 결정
        function checkAgreements() {
            var termsAgree = document.getElementById('termsAgree').checked;
            var privacyAgree = document.getElementById('privacyAgree').checked;
            var nextButton = document.getElementById('nextPage-info');


            if (termsAgree && privacyAgree) {
                nextButton.disabled = false;
                document.getElementById('nextPage-info').style.backgroundColor = "#7A97CC";
            } else {
                nextButton.disabled = true;
                document.getElementById('nextPage-info').style.backgroundColor = "#b8c9de";
            }
        }

        window.onload = function() {
            document.getElementById('nextPage-info').disabled = true;
            document.getElementById('nextPage-info').style.backgroundColor = "#b8c9de";
        };
    </script>
</head>
<body>
    <%@include file="../common/nav.jsp" %>
    <div class="container">
        <aside>
            <ul>
                <li><a href="#" class="active">약관동의</a></li>
                <li><a href="#">정보입력</a></li>
            </ul>
        </aside>
        <main>
            <h2>약관동의</h2>
            <form action="enrollForm.me"> <!-- register.do 서블릿으로 전송 -->
                <div class="agreement">
                    <label class="checkbox">
                        <input type="checkbox" id="termsAgree" name="termsAgree" onclick="checkAgreements()" required>
                        <span>이용약관 동의(필수)</span>
                    </label>
                    <textarea readonly>온라인 기본서비스 제공을 위한 동의가 필요합니다.</textarea>
                    <span class="details"></span>
                </div>
                <div class="agreement">
                    <label class="checkbox">
                        <input type="checkbox" id="privacyAgree" name="privacyAgree" onclick="checkAgreements()" required>
                        <span>개인정보 수집 및 동의(필수)</span>
                    </label>
                    <textarea readonly>필수서비스 이용목적으로 개인정보 수집에 동의가 필요합니다.</textarea>
                    <span class="details">필수 항목 2023년부터 유효한 약관입니다.</span>
                </div>
                <button type="submit" id="nextPage-info">다음</button> <!-- 초기에는 비활성화 -->
            </form>
        </main>
    </div>
</body>
</html>
