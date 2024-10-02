const shPageValue = {

}
// var map;

function getLocation() {
    const status = document.getElementById("status");
    console.log(status);
    // Geolocation API 지원 여부 확인
    if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition(
            (position) => {
                const {latitude, longitude, accuracy} = position.coords;
                // status.textContent = `위도: ${latitude}, 경도: ${longitude}, 정확도: ${accuracy}미터`;
                la=latitude;
                lo=longitude;
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
    map = new kakao.maps.Map(container, options);
    shPageValue.map = map;
    // 장소 검색 객체 생성
    var ps = new kakao.maps.services.Places();
    const coordinate = new kakao.maps.LatLng(latitude,longitude)

    var options = {
        location: coordinate,
        radius: 10000,
        size:15,
        sort: kakao.maps.services.SortBy.DISTANCE,
    };
    ps.keywordSearch('동물병원', placesSearchCB, options);

    // 키워드 검색 완료 시 호출되는 콜백함수 입니다
    function placesSearchCB(data, status, pagination) {
        if (status === kakao.maps.services.Status.OK) {
            console.log(data)
            console.log(typeof data)

            var listEl = document.querySelector("#placesList"),
                fragment = document.createDocumentFragment()
            var bounds = new kakao.maps.LatLngBounds();
            // 키워드 검색한 결과 마커 생성
            for (var i = 0; i < data.length; i++) {
                // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
                // LatLngBounds 객체에 좌표를 추가합니다
                bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
                // 마커 생성
                displayMarker(data[i], data.length);
                // 목록에 추가
                var itemEl = getListItem(i,data[i]);
                fragment.appendChild(itemEl);
            }
            // 검색된 장소 위치 기준으로 지도 범위 재설정
            shPageValue.map.setBounds(bounds);
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
            itemStr += '    <span>' + places.road_address_name + '</span>' + '<br>' + '   <span class="jibun gray">' + places.address_name + '</span>' + '<br>';
        } else {
            itemStr += '    <span>' + places.address_name + '</span>' + '<br>';
        }

        itemStr += '  <span class="tel">' + places.phone + '</span>' + '</div>';

        el.innerHTML = itemStr;
        el.className = 'item';

        // 장소의 좌표 정보를 data 속성에 저장
        el.setAttribute('data-lat', places.y);
        el.setAttribute('data-lng', places.x);
        el.setAttribute('data-pName', places.place_name);

        var lat = parseFloat(el.getAttribute('data-lat'));
        var lng = parseFloat(el.getAttribute('data-lng'));
        var pName = el.getAttribute('data-pName');
        var moveLatLon = new kakao.maps.LatLng(lat, lng);

        // 클릭, 마우스오버,아웃을 위한 마커 생성
        var clickMarker = new kakao.maps.Marker({
            map: shPageValue.map,
            position: moveLatLon
        });

        var clickInfowindow = new kakao.maps.InfoWindow({
            content: `<div>${pName}</div>`
        });

        // 클릭 이벤트를 추가하여 해당 장소로 지도 이동, 확대
        el.onclick = function() {
            shPageValue.map.setLevel(3);
            shPageValue.map.panTo(moveLatLon);
            clickInfowindow.open(shPageValue.map, clickMarker);  // Open infowindow on click
        };

        el.onmouseover = function () {
            clickInfowindow.open(shPageValue.map, clickMarker);  // Open infowindow on mouseover
        };
        el.onmouseout = function (){
            clickInfowindow.close();  // Close infowindow on mouseout
        };

        return el;
    }
    function displayMarker(place, length){
        // 마커 생성 및 지도에 표시
        var marker = new kakao.maps.Marker({
            map: shPageValue.map,
            position: new kakao.maps.LatLng(place.y,place.x)
        });
        var content = {
            content: `<span>${place.place_name}</span>`
        };
        var infowindow = new kakao.maps.InfoWindow({
            content: content.content
        });

        kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(shPageValue.map, marker, infowindow));
        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));

    }
// 인포윈도우를 표시하는 클로저를 만드는 함수입니다
    function makeOverListener(map, marker, infowindow) {
        return function() {
            infowindow.open(map, marker);
        };
    }

// 인포윈도우를 닫는 클로저를 만드는 함수입니다
    function makeOutListener(infowindow) {
        return function() {
            infowindow.close();
        };
    }


}
