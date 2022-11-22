$(document).ready(function(){

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(33.2465421, 126.5702671579), // 지도의 중심좌표
        level: 8 // 지도의 확대 레벨
    };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


    var positions=[];
    $.ajax({
        type: "GET",
        url: "https://open.jejudatahub.net/api/proxy/atDab6t8218btaa122b26DDtbatD86t1/o4eo6b7r31416er4je41oo7pj73676tp",
        data:{'limit':100},
        dataType: "json",
        error: function() {
          console.log('통신실패!!');
        },
        success: function(data) {
          for(var i = 0; i < data.data.length; i++){
              positions.push({content: '<div>'+data.data[i].chargingPlace+'</div>', latlng: new kakao.maps.LatLng(data.data[i].latitude, data.data[i].longitude)});
          }
          console.log(positions)
          makeMap(positions);
        }
    });

    function makeMap(positions){
        // 마커 이미지의 이미지 주소입니다
        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
        for (var i = 0; i < positions.length; i ++) {
            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                map: map, // 마커를 표시할 지도
                position: positions[i].latlng // 마커의 위치
            });

            // 마커에 표시할 인포윈도우를 생성합니다
            var infowindow = new kakao.maps.InfoWindow({
                content: positions[i].content // 인포윈도우에 표시할 내용
            });

            // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
            // 이벤트 리스너로는 클로저를 만들어 등록합니다
            // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
            kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
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


});