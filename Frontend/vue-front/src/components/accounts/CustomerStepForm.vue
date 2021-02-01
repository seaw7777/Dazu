<template>
  <div>
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <h1>고객님 추가 정보 입력 단계</h1>

          <!-- <v-col cols="12">
            <input type="text" id="sample4_postcode" placeholder="우편번호" />
            <input
              type="button"
              @click="sample4_execDaumPostcode()"
              value="우편번호 찾기"
            /><br />
          </v-col>
          <v-col cols="12">
            <v-text-field
              type="text"
              id="sample4_roadAddress"
              placeholder="도로명주소"
            />
            <v-text-field
              type="text"
              id="sample4_jibunAddress"
              placeholder="지번주소"
            />
            <span id="guide" style="color:#999;display:none"></span>
            <v-text-field
              v-model="detailAddress"
              type="text"
              id="sample4_detailAddress"
              placeholder="상세주소"
            />
            <v-text-field
              type="text"
              id="sample4_extraAddress"
              placeholder="참고항목"
            />
          </v-col> -->
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
    };
  },
  // this.$store.dispatch('ROAD', data.roadAddress);
  methods: {
    execDaumPostcode() {
      const currentScroll = Math.max(
        document.body.scrollTop,
        document.documentElement.scrollTop,
      );
      // eslint-disable-next-line
      new daum.Postcode({
        onComplete: data => {
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
          this.postcode = data.zonecode;
          this.$refs.extraAddress.focus();
          this.searchWindow.display = 'none';
          document.body.scrollTop = currentScroll;
        },
        onResize: size => {
          this.searchWindow.height = `${size.height}px`;
        },
        width: '100%',
        height: '100%',
      }).embed(this.$refs.searchWindow);
      this.searchWindow.display = 'block';
    },

    async submitInfo() {
      try {
        console.log('data3' + this.address);
        const response = await customerInfoAPI({
          // accessToken: this.$store.state.token,
          address: this.address,
          address_detail: this.extraAddress,
          // nickname: '',
          // profileImage: '',
          usercode: '123444',
          usertype: this.usertype,
        });
        this.$router.push('/main');
        console.log(response);
      } catch (error) {
        console.log('error');
      }
    },
  },
};
</script>

<style></style>
