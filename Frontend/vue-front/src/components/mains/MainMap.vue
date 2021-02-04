<template>
  <div id="map" style="width:500px;height:400px;"></div>
</template>

<script>
export default {
  name: 'map',
  props: {
    storeItems: {
      type: Object,
      required: true,
    },
    houseItem: Object,
  },
  data() {
    return {
      a: '',
    };
  },
  computed() {
    this.a = this.houseItem.lat;
  },
  mounted() {
    const container = document.getElementById('map');
    // var parseobj = JSON.parse(JSON.stringify(this.houseItem));
    // console.log(parseobj);
    console.log(this.a);
    // console.log(this.houseLat);
    const options = {
      center: new window.kakao.maps.LatLng(this.a, 126.855),
      level: 3,
    };
    const map = new window.kakao.maps.Map(container, options);
    console.log(map);
  },
};
</script>

<style></style>
