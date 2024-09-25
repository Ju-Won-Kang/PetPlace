function getLocation() {
    const status = document.getElementById("status");
    console.log(status);
    // Geolocation API 지원 여부 확인
    if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition(
            (position) => {
                const {latitude, longitude, accuracy} = position.coords;
                // status.textContent = `위도: ${latitude}, 경도: ${longitude}, 정확도: ${accuracy}미터`;
                mapLoad(latitude, longitude)
            },
            (error) => {
                status.textContent = `위치 정보를 가져올 수 없습니다: ${error.message}`;
            },
            {
                enableHighAccuracy: true, // 정확도 우선 모드
                timeout: 100000,           // 100초 이내에 응답 없으면 에러 발생
                maximumAge: 0             // 항상 최신 위치 정보 수집
            }
        );
    } else {
        status.textContent = "브라우저가 위치 서비스를 지원하지 않습니다.";
    }
}

function mapLoad(latitude, longitude) {
    // 마커를 담을 배열 생성
    var markers = [];

    var container = document.getElementById('map');
    var options = {
        center: new kakao.maps.LatLng(latitude, longitude),
        level: 5
    };

    // 지도 생성
    var map = new kakao.maps.Map(container, options);

    // 장소 검색 객체 생성
    var ps = new kakao.maps.services.Places();
    const coordinate = new kakao.maps.LatLng(latitude,longitude)

    var options = {
        location: coordinate,
        radius: 10000,
        size:10,
        sort: kakao.maps.services.SortBy.DISTANCE,
    };
    ps.keywordSearch('동물병원', placesSearchCB, options);

    // 키워드 검색 완료 시 호출되는 콜백함수 입니다
    function placesSearchCB(data, status, pagination) {
        if (status === kakao.maps.services.Status.OK) {
            console.log(data)
            var listEl = document.querySelector("#placesList"),
                fragment = document.createDocumentFragment()
            // 키워드 검색한 결과 마커 생성
            for (var i = 0; i < data.length; i++) {
                displayMarker(data[i]);
                var itemEl = getListItem(i,data[i]);
                fragment.appendChild(itemEl);
            }
            // 검색결과 항목들을 검색결과 목록 Element에 추가합니다
            listEl.appendChild(fragment);

            // displayPlaces(data);

        } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

            alert('검색 결과가 존재하지 않습니다.');
            return;

        } else if (status === kakao.maps.services.Status.ERROR) {

            alert('검색 결과 중 오류가 발생했습니다.');
            return;

        }
    }

    // 검색결과 항목을 Element로 반환하는 함수입니다
    function getListItem(index, places) {

        var el = document.createElement('li'),
            itemStr = '<span class="markerbg marker_' + (index + 1) + '"></span>' +
                '<div class="info">' +
                '   <h5>' + places.place_name + '</h5>';

        if (places.road_address_name) {
            itemStr += '    <span>' + places.road_address_name + '</span>' + '<br>' +
                '   <span class="jibun gray">' + places.address_name + '</span>' + '<br>';
        } else {
            itemStr += '    <span>' + places.address_name + '</span>' + '<br>';
        }

        itemStr += '  <span class="tel">' + places.phone + '</span>' + '</div>';

        el.innerHTML = itemStr;
        el.className = 'item';

        return el;
    }
    function displayMarker(place){
        // 마커 생성 및 지도에 표시
        var marker = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(place.y,place.x)
        });

    }


}


