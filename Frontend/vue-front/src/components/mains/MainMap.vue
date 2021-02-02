<template>
  <div id="map" style="width:500px;height:400px;"></div>
</template>

<script>
export default {
  name: 'map',
  data() {
    return {
      msg: '맵테스트',
    };
  },
  mounted() {
    const container = document.getElementById('map');
    const options = {
      center: new window.kakao.maps.LatLng(35.450701, 126.570667),
      level: 3,
    };
    const map = new window.kakao.maps.Map(container, options);
    console.log(map);

    // const geocoder = new window.kakao.maps.services.Geocoder();

    // geocoder.addressSearch('부산광역시 연제구 반송로 80', function(
    //   result,
    //   status,
    // ) {
    //   if (status === window.kakao.maps.services.Status.OK) {
    //     const coords = new window.kakao.maps.LatLng(result[0].y, result[0].x);
    //     console.log('뭐지?' + coords);

    //     const marker = new window.kakao.maps.Marker({
    //       map: map,
    //       position: coords,
    //     });

    //     const infowindow = new window.kakao.maps.InfoWindow({
    //       content:
    //         '<div style="width:150px;text-align:center;padding:6px 0;">우리집</div>',
    //     });
    //     infowindow.open(map, marker);

    //     map.setCenter(coords);
    //   }
    // });
  },
};
</script>

<style></style>
