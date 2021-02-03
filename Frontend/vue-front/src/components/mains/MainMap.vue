<template>
  <div id="map" style="width:900px;height:600px;"></div>
</template>

<script>
export default {
  name: 'map',
  data() {
    return {
      storeList: [],
      userAdress: '',
      selectedMarker: null,
    };
  },
  mounted() {
    const container = document.getElementById('map');
    const options = {
      center: new window.kakao.maps.LatLng(33.450701, 126.570667),
      level: 3,
    };
    const map = new window.kakao.maps.Map(container, options);
    console.log(map);

    var positions = [
      {
        title: '희은이네 만두가게',
        content: '<div style="padding:5px;color:red;">만두클래스1</div>',
        latlng: new window.kakao.maps.LatLng(33.450705, 126.570677),
      },
      {
        title: '지은이네 만두가게',
        content: '<div style="padding:5px;color:red;">만두클래스2</div>',
        latlng: new window.kakao.maps.LatLng(33.450936, 126.569477),
      },
      {
        title: '예림이네 만두가게',
        content: '<div style="padding:5px;color:red;">만두클래스3</div>',
        latlng: new window.kakao.maps.LatLng(33.450879, 126.56994),
      },
      {
        title: '현철이네 만두가게',
        content: '<div style="padding:5px;color:red;">만두클래스4</div>',
        latlng: new window.kakao.maps.LatLng(33.451393, 126.570738),
      },
    ];

    const imageSrc =
      'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png';
    const iwRemoveable = true;

    for (var i = 0; i < positions.length; i++) {
      const imageSize = new window.kakao.maps.Size(24, 35);
      const markerImage = new window.kakao.maps.MarkerImage(
        imageSrc,
        imageSize,
      );

      const marker = new window.kakao.maps.Marker({
        map: map,
        position: positions[i].latlng,
        title: positions[i].title,
        image: markerImage,
      });
      const infowindow = new window.kakao.maps.InfoWindow({
        content: positions[i].content,
        removable: iwRemoveable,
      });
      window.kakao.maps.event.addListener(marker, 'click', function() {
        infowindow.close(map, this.selectedMarker);
        infowindow.open(map, marker);
        this.selectedMarker = marker;
        console.log(this.selectedMarker);
      });
    }
  },
};
</script>

<style></style>
