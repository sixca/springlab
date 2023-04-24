<%--각각의 버튼을 눌러서 지도를 이동시켜보자--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    #map02 > #map{
        width:400px;
        height:400px;
        border: 2px solid red;
    }
</style>
<script>
    let map02 = {
      map:null,
      init:function(){
          this.display();
          $('#s_btn').click(function (){
              map02.go(37.579617, 126.977041);
          });
          $('#b_btn').click(function (){
              map02.go(35.1585914837981, 129.16037219970022);
          });
          $('#j_btn').click(function (){
              map02.go(33.2446141, 126.4059696);
          });
      },
      display:function (){
          var mapContainer = document.querySelector('#map02 > #map');
          var mapOption = {
              center: new kakao.maps.LatLng(37.5447889, 127.056768), // 알파코 좌표 찍음
              level: 5 // 지도의 확대 레벨
          };
          map =  new kakao.maps.Map(mapContainer, mapOption) //지도 뿌리기

          // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
          var mapTypeControl = new kakao.maps.MapTypeControl();
          // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
          // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
          map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
          // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
          var zoomControl = new kakao.maps.ZoomControl();
          map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

          // 마커가 표시될 위치입니다
          var markerPosition  = new kakao.maps.LatLng(37.5447889, 127.056768);
          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
              position: markerPosition
          });
          // 마커가 지도 위에 표시되도록 설정합니다
          marker.setMap(map);
      },
      go:function (lat, lng){  //위도, 경도
          var moveLatLon = new kakao.maps.LatLng(lat, lng);
          map.panTo(moveLatLon);  //지도이동

          var markerPosition  = new kakao.maps.LatLng(lat, lng);
          var marker = new kakao.maps.Marker({
              position: markerPosition   //이동된 위치에 마커 뿌리기
          });
          marker.setMap(map);
      }
    };
    $(function (){
        map02.init();
    })

</script>

<%-- Main Center Start --%>
<div class="col-sm-8 text-left">
    <div class="container" id="map02">
      <h3>Map02</h3>
        <button id="s_btn" type="button" class="btn btn-primary">Seoul</button>
        <button id="b_btn" type="button" class="btn btn-primary">Busan</button>
        <button id="j_btn" type="button" class="btn btn-primary">Jeju</button>
        <div id="map"></div>

    </div>
</div>
<%-- Main Center End --%>