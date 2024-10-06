
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Place - 약관동의</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/agree.css">
</head>
<body>
    <!-- 공통 네비게이션 바를 JSP로 include -->
   
    
    <div class="container">
        <header>
            <div class="logo">
                <h1>Pet Place</h1>
            </div>
            <nav>
                <ul>
                    <li><a href="#">커뮤니티</a></li>
                    <li><a href="#">쇼핑</a></li>
                    <li><a href="#">일양</a></li>
                    <li><a href="#">병원예약</a></li>
                    <li><a href="#">기능</a></li>
                </ul>
            </nav>
            <div class="user-icon">
                <img src="user-icon.png" alt="User Icon">
            </div>
        </header>
        <div class="content">
            <aside>
                <ul>
                    <li><a href="#" class="active">약관동의</a></li>
                    <li><a href="#">정보입력</a></li>
                    <li><a href="#">반려등록</a></li>
                </ul>
            </aside>
            <main>
                <h2>약관동의</h2>
                <form action="#" method="post">
                    <div class="agreement">
                        <label class="checkbox">
                            <input type="checkbox" required>
                            <span>이용약관 동의(필수)</span>
                        </label>
                        <textarea readonly>온라인 기본서비스 제공을 위한 동의가 필요합니다.</textarea>
                        <span class="details"></span>
                    </div>
                    <div class="agreement">
                        <label class="checkbox">
                            <input type="checkbox" required>
                            <span>개인정보 수집 및 동의(필수)</span>
                        </label>
                        <textarea readonly>필수서비스 이용목적으로 개인정보 수집에 동의가 필요합니다.</textarea>
                        <span class="details">필수 항목 2023년부터 유효한 약관입니다.</span>
                    </div>
                    <button type="submit">다음</button>
                </form>
            </main>
        </div>
    </div>
</body>
</html>
