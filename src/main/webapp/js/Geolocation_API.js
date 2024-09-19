function getLocation() {
    const status = document.getElementById("status");
    console.log(status);
    // Geolocation API 지원 여부 확인
    if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition(
            (position) => {
                const { latitude, longitude, accuracy } = position.coords;
                status.textContent = `위도: ${latitude}, 경도: ${longitude}, 정확도: ${accuracy}미터`;
                mapLoad(latitude, longitude)
            },
            (error) => {
                status.textContent = `위치 정보를 가져올 수 없습니다: ${error.message}`;
            },
            {
                enableHighAccuracy: true, // 정확도 우선 모드
                timeout: 10000,           // 10초 이내에 응답 없으면 에러 발생
                maximumAge: 0             // 항상 최신 위치 정보 수집
            }
        );
    } else {
        status.textContent = "브라우저가 위치 서비스를 지원하지 않습니다.";
    }
}
function mapLoad(latitude, longitude) {
        let container = document.getElementById('map');
        let options = {
        center: new kakao.maps.LatLng(latitude, longitude),
        level: 3
    };
        let map = new kakao.maps.Map(container, options);
}
