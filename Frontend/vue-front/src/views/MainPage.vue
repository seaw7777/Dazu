<template>
  <div class="map-container">
    <div id="map" style="width:900px;height:500px;"></div>
  </div>
</template>

<script>
import { fetchStore } from '@/api/store';
import { customerGetInfoAPI } from '@/api/auth';
import { fetchStoreClass } from '@/api/classes';
export default {
  data() {
    return {
      isLoading: false,
      dialogm1: '',
      dialog: false,
    };
  },
  async mounted() {
    this.isLoading = true;
    const houseData = await customerGetInfoAPI('1');
    const storeData = await fetchStore('우이동');
    this.isLoading = false;
    const lat = Number(houseData.data.lat);
    const lng = Number(houseData.data.lng);
    const container = document.getElementById('map');
    const options = {
      center: new window.kakao.maps.LatLng(lng, lat),
      level: 3,
    };
    const map = new window.kakao.maps.Map(container, options);

    var housePosition = new window.kakao.maps.LatLng(lng, lat);

    var marker = new window.kakao.maps.Marker({
      position: housePosition,
    });

    marker.setMap(map);

    const imageSrc =
      'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png';
    const iwRemoveable = true;

    for (var i = 0; i < storeData.data.length; i++) {
      const storeClass = await fetchStoreClass(storeData.data[i].storecode);

      const imageSize = new window.kakao.maps.Size(24, 35);
      const markerImage = new window.kakao.maps.MarkerImage(
        imageSrc,
        imageSize
      );
      const position = new window.kakao.maps.LatLng(
        Number(storeData.data[i].lng),
        Number(storeData.data[i].lat)
      );
      const marker = new window.kakao.maps.Marker({
        map: map,
        position: position,
        title: storeData.data[i].store_name,
        image: markerImage,
      });
      let element = '<div style="padding:5px;">';
      element += storeData.data[i].store_name;
      for (let index = 0; index < storeClass.data.length; index++) {
        const id = storeClass.data[index].classcode;
        element += '<br>';
        element += `<a href="http://i4d104.p.ssafy.io/class/detail/${id}" style="color:blue">${storeClass.data[index].class_name}&emsp;&emsp;&emsp;${storeClass.data[index].class_price}원</a>`;
      }
      element += '</div>';

      const infowindow = new window.kakao.maps.InfoWindow({
        content: element,
        removable: iwRemoveable,
      });

      window.kakao.maps.event.addListener(marker, 'click', function() {
        infowindow.open(map, marker);
      });
    }
  },
};
</script>

<style scoped>
.map-container {
  display: flex;
  justify-content: center;
  margin-top: 50px;
}
</style>
