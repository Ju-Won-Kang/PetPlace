<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Place - 회원가입</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <!-- register 페이지 전용 스타일 시트를 연결 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/register/register.css">
</head>
<body>

    <%@include file="../common/nav.jsp" %> 


    <div id="register-page" class="register-container">
       
        <aside>
            <ul>
                <li><a href="#">약관동의</a></li>
                <li><a href="#" class="active">정보입력</a></li>
            </ul>
        </aside>

       
        <main>
            <h2>회원가입</h2>
            <form action="register.do" method="post"> 
                <div class="form-group">
                    <label for="email">이메일/아이디</label>
                    <input type="email" id="email" name="email" placeholder="아이디 입력(이메일)" required>
                    <button type="button" id="checkDuplicate">중복확인</button>
                </div>

                <div class="form-group">
                    <label for="name">이름</label>
                    <input type="text" id="name" name="name" placeholder="이름 입력" required>
                </div>

                <div class="form-group">
                    <label for="residentNumber">주민등록번호</label>
                    <input type="text" id="residentNumber" name="residentNumber" placeholder="주민등록번호(-제외)" required>
                </div>
                
                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="password" placeholder="비밀번호 입력(영문, 숫자 8~16자)" required>
                </div>
                
                <div class="form-group">
                    <label for="passwordConfirm">비밀번호 확인</label>
                    <input type="password" id="passwordConfirm" name="passwordConfirm" placeholder="비밀번호 입력(특수문자 제외)" required>
                </div>

                <div class="form-group phone-group">
                    <label for="phoneNumber">전화번호</label>
                    <select id="phonePrefix" name="phonePrefix">
                        <option value="010">010</option>
                        <option value="011">011</option>
                    </select>
                    <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="전화번호 입력(제외)" required>
                </div>

                <div class="form-group">
                    <label for="address">주소입력</label>
                    <input type="text" id="address" name="address" placeholder="주소 입력" required>
                </div>

                <div class="form-group">
                    <label for="nickname">닉네임</label>
                    <input type="text" id="nickname" name="nickname" placeholder="닉네임 입력(특수문자 제외)" required>
                </div>

                <button type="submit" id="submitRegister">회원가입</button>
            </form>
        </main>
    </div>
</body>
</html>
