<template>
  <div>
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <h1>고객님 추가 정보 입력 단계</h1>

          <div
            ref="searchWindow"
            :style="searchWindow"
            style="border:1px solid;width:500px;margin:5px 0;position:relative"
          >
            <img
              src="//t1.daumcdn.net/postcode/resource/images/close.png"
              id="btnFoldWrap"
              style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1"
              @click="searchWindow.display = 'none'"
              alt="close"
            />
          </div>
          <v-col cols="12">
            <input type="text" placeholder="우편번호" v-model="postcode"/>
            <v-btn
              class="ma-2"
              outlined
              color="indigo"
              value="우편번호 찾기"
              @click="execDaumPostcode"
              >우편번호 찾기</v-btn
            >
            <br
          /></v-col>
          <v-col cols="12">
            <v-text-field type="text" v-model="address" placeholder="주소" />
            <br />
          </v-col>
          <v-col cols="12">
            <v-text-field
              type="text"
              v-model="extraAddress"
              ref="extraAddress"
              placeholder="상세주소"
            />
          </v-col>
          <v-col>
            <v-text-field v-model="lat" placeholder="lat"></v-text-field>
          </v-col>
          <v-btn class="ma-2" outlined color="indigo" @click="changeMap">
            좌표변환
          </v-btn>
          <v-btn class="ma-2" outlined color="indigo" @click="submitInfo">
            NEXT
          </v-btn>
        </v-row>
      </v-container>
    </v-form>
  </div>
</template>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>
import { customerInfoAPI } from '@/api/auth';

export default {
  data() {
    return {
      searchWindow: {
        display: 'none',
        height: '300px',
      },
      postcode: '',
      address: '',
      extraAddress: '',
      usertype: 1,
      latAdress: '',
      lngAdress: '',
    };
  },
  created() {
    this.latAdress = '12.3333';
  },
  methods: {
    execDaumPostcode: function() {
      const currentScroll = Math.max(
        document.body.scrollTop,
        document.documentElement.scrollTop
      );

      new daum.Postcode({
        onComplete: function(data) {
          if (data.userSelectedType === 'R') {
            this.address = data.roadAddress;
          } else {
            this.address = data.jibunAddress;
          }
          if (data.userSelectedType === 'R') {
            if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
              this.extraAddress += data.bname;
            }
            if (data.buildingName !== '' && data.apartment === 'Y') {
              this.extraAddress +=
                this.extraAddress !== ''
                  ? `, ${data.buildingName}`
                  : data.buildingName;
            }
            if (this.extraAddress !== '') {
              this.extraAddress = ` (${this.extraAddress})`;
            }
          } else {
            this.extraAddress = '';
          }
          console.log(this.extraAddress);
          console.log(this.address);
          var geocoder = new kakao.maps.services.Geocoder();
          geocoder.addressSearch(this.address, function(result, status) {
            if (status === kakao.maps.services.Status.OK) {
              var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
              var lat = coords.getLat();
              console.log('vue lng : ' + coords.getLng());
              console.log('vue lat : ' + lat);
              console.log(this.address);
              this.latAdress = lat;
              console.log('this lat : ' + this.lat);
            }
          });
          this.postcode = data.zonecode;
          // this.$refs.extraAddress.focus();
          // this.searchWindow.display = 'none';
          document.body.scrollTop = currentScroll;
        },
        // onResize: function(size) {
        //   this.searchWindow.height = `${size.height}px`;
        // },
        width: '100%',
        height: '100%',
      }).open();
      // this.searchWindow.display = 'block';
    },
    changeMap() {
      const geocoder = new kakao.maps.services.Geocoder();
      geocoder.addressSearch(this.address, function(result, status) {
        if (status === kakao.maps.services.Status.OK) {
          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
          var lat = coords.getLat();
          this.lat = coords.getLat();
          console.log('this lat : ' + this.lat);
          console.log('vue lng : ' + coords.getLng());
          console.log('vue lat : ' + lat);
        }
      });
    },

    async submitInfo() {
      try {
        console.log('data3' + this.lat);
        const response = await customerInfoAPI({
          address: this.address,
          address_detail: this.extraAddress,
          lat: this.lat,
          lng: this.lng,
          usercode: '123444',
          usertype: this.usertype,
        });
        this.$router.push('/main');
        console.log(response);
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style></style>
