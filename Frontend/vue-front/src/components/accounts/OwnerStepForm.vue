<template>
  <div>
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <h1>사장님 추가 정보 입력 단계</h1>
          <v-col cols="12">
            <v-text-field
              type="text"
              v-model="storename"
              placeholder="가게명"
            />
            <br />
          </v-col>

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
            <v-text-field type="text" v-model="dong" placeholder="동" />
            <v-text-field
              type="text"
              v-model="extraAddress"
              ref="extraAddress"
              placeholder="상세주소"
            />
          </v-col>
          <v-col cols="12">
            <v-file-input
              v-model="file"
              truncate-length="15"
              label="가게 정보 사진"
            ></v-file-input>
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
import { ownerInfoPost, customerInfoAPI } from '@/api/auth';

export default {
  data() {
    return {
      searchWindow: {
        display: 'none',
        height: '300px',
      },
      file: '',
      postcode: '',
      address: '',
      extraAddress: '',
      dong: '',
      usertype: '0',
      storename: '',
    };
  },

  methods: {
    execDaumPostcode() {
      const currentScroll = Math.max(
        document.body.scrollTop,
        document.documentElement.scrollTop,
      );

      new daum.Postcode({
        onComplete: data => {
          if (data.userSelectedType === 'R') {
            this.address = data.roadAddress;
          } else {
            this.address = data.jibunAddress;
          }
          if (data.userSelectedType === 'R') {
            if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
              this.dong += data.bname;
            }
            if (data.buildingName !== '' && data.apartment === 'Y') {
              this.dong +=
                this.dong !== '' ? `, ${data.buildingName}` : data.buildingName;
            }
            if (this.dong !== '') {
              this.dong = ` ${this.dong}`;
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
      var fd = new FormData();
      try {
        console.log('data3' + this.dong);
        const response = await ownerInfoPost({
          file: this.file,
          dong: this.dong,
          lat: '',
          lng: '',
          member_usercode: this.$store.state.usercode,
          store_describe: '',
          store_grade: 0,
          store_grade_cnt: 0,
          store_location: this.address,
          store_name: this.storename,
          storecode: '',
        });
        console.log(response);
        const res = await customerInfoAPI({
          accessToken: '',
          address: this.address,
          address_detail: this.extraAddress,
          usercode: this.$store.state.usercode,
          create_date: '',
          lat: '',
          lng: '',
          dong: this.dong,
          nickname: this.$store.state.username,
          usertype: this.usertype,
        });
        console.log(res);
        this.$store.dispatch('USERTYPE', this.usertype);
        this.$router.push('/main');
      } catch (error) {
        console.log('error');
      }
    },
  },
};
</script>

<style></style>
