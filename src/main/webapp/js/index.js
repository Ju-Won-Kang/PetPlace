function userBtn(){
    const userInfo = document.getElementById("user-info");
    if (userInfo.classList.contains('hide')){
        // 클래스가 'hide'인 경우
        userInfo.classList.remove('hide');
        userInfo.classList.add('expose');
    } else {
        // 클래스가 'hide'가 아닌 경우
        userInfo.classList.remove('expose');
        userInfo.classList.add('hide');
    }
}
