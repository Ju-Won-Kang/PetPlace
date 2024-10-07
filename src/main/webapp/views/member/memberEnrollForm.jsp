<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2024. 10. 7.
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Place - 회원가입</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <!-- register 페이지 전용 스타일 시트를 연결 -->
    <link rel="stylesheet" href="css/member/memberEnrollForm.css">
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
            <form action="enroll.me" id="enrollForm" method="post">
                <div class="form-group">
                    <label for="userId">아이디</label>
                    <input type="text" id="userId" name="userId" placeholder="아이디 입력(이메일)" required>
                    <button type="button" id="checkDuplicate" onclick="idCheck()">중복확인</button>
                </div>
                <div id="checkResult" style="font-size:0.8em; display:none;"></div>
                <div class="form-group">
                    <label for="name">이름</label>
                    <input type="text" id="name" name="userName" placeholder="이름 입력" required>
                </div>
                <div class="form-group">
                    <label>주민등록번호</label>
                    <input type="text" id="ssn1" name="SSN1" placeholder="앞자리" required>
                    <span> - </span>
                    <input type="text" id="ssn2" name="SSN2" placeholder="뒷자리" required>
                </div>

                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="userPwd" placeholder="비밀번호 입력(영문, 숫자 6~16자)" required>
                </div>
                <div id="checkPwdCondition" style="font-size:0.8em; display:none;"></div>

                <div class="form-group">
                    <label for="passwordConfirm">비밀번호 확인</label>
                    <input type="password" id="passwordConfirm" name="passwordConfirm" placeholder="비밀번호 입력(특수문자 제외)" required onfocusout="checkPwd()">
                </div>
                <div id="checkPwdResult" style="font-size:0.8em; display:none;"></div>
                <div class="form-group phone-group">
                    <label >전화번호</label>
                    <select id="phone1" name="phone_1">
                        <option value="010">010</option>
                    </select>
                    <span> - </span>
                    <input type="text" id="phone2" name="phone_2" placeholder="0000" required>
                    <span> - </span>
                    <input type="text" id="phone3" name="phone_3" placeholder="0000" required>
<%--                    <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="전화번호 입력(제외)" required>--%>
                </div>
                <div class="form-group">
                    <label for="address">주소입력</label>
                    <input type="text" id="address" name="address" placeholder="주소 입력" required>
                </div>
                <div class="form-group">
                    <label for="nickname">닉네임</label>
                    <input type="text" id="nickName" name="nickName" placeholder="닉네임 입력(특수문자 제외)" required>
                </div>
                <button type="submit" id="submitRegister" disabled>회원가입</button>
            </form>
        </main>
        <script>
            function idCheck(){
                const idInput = document.querySelector("#userId");
                $.ajax({
                    url : "idCheck.me",
                    data : {
                        checkId : idInput.value
                    },
                    success : function (result){
                        const checkResult = document.querySelector("#checkResult");
                        checkResult.style.display = "block"
                        if(result === "NNNNN"){
                            checkResult.style.color = "red";
                            checkResult.innerText = "이미 사용중인 아이디 입니다."
                            document.querySelector("#userId").className = "check-red";
                            document.querySelector("#enrollForm button[type=submit]").disabled = true;
                            document.querySelector("#userId").focus();
                        }else{
                            checkResult.style.color = "green";
                            document.querySelector("#userId").className = "check-green";
                            checkResult.innerText = "사용가능한 아이디 입니다."
                            document.querySelector("#enrollForm button[type=submit]").disabled = false;
                        }
                    },
                    error : function (){
                        console.log("아아디 중복체크 AJAX 실패")
                    }
                })
            }
            function checkPwd(){
                const pwdEl = document.querySelector("#password");
                const pwdCheckEl = document.querySelector("#passwordConfirm");
                const checkPwdResult = document.querySelector("#checkPwdResult");
                checkPwdResult.style.display = "block"
                if(pwdEl.value !== pwdCheckEl.value){
                    pwdCheckEl.className = "check-red";
                    document.querySelector("#enrollForm button[type=submit]").disabled = true;
                    checkPwdResult.innerText = "비밀번호가 일치하지 않습니다.";
                    checkPwdResult.style.color = "red";
                    // pwdCheckEl.focus();
                }else{
                    pwdCheckEl.className = "check-green";
                    document.querySelector("#enrollForm button[type=submit]").disabled = false;
                    checkPwdResult.innerText = "비밀번호가 일치합니다.";
                    checkPwdResult.style.color = "green";
                }
            }
            $(function (){
                const pwdInputEl = document.querySelector("#password");
                const checkPwdConditionEl = document.querySelector("#checkPwdCondition");
                let eventFlag;
                pwdInputEl.onkeyup = function (ev){
                    clearTimeout(eventFlag);
                    const str = ev.target.value;
                    if(str.length >= 1){
                        eventFlag = setTimeout(function (){
                            checkPwdConditionEl.style.display = "block"
                            const regex = /^[A-Za-z0-9]{6,16}$/;
                            if(regex.test(str)){
                                pwdInputEl.className = "check-green";
                                checkPwdConditionEl.innerText = "비밀번호가 조건에 만족 합니다."
                                checkPwdConditionEl.style.color = "green"
                                document.querySelector("#enrollForm button[type=submit]").disabled = false;
                            }else{
                                pwdInputEl.className = "check-red";
                                checkPwdConditionEl.innerText = "비밀번호가 조건에 만족하지 않습니다."
                                checkPwdConditionEl.style.color = "red"
                                document.querySelector("#enrollForm button[type=submit]").disabled = true;
                            }
                        },500)
                    }
                }
            })
        </script>
    </div>
</body>
</html>
