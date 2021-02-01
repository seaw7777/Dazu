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
      center: new kakao.maps.LatLng(33.450701, 126.570667),
      level: 3,
    };
    const map = new kakao.maps.Map(container, options);
  },
};
</script>

<style></style>
