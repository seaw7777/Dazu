<template>
  <div>
    <v-card width="600px">
      <v-card-title>가게 주소</v-card-title>
      <v-card-text>{{ this.storeData.store_location }}</v-card-text>
      <v-row justify="center">
        <v-dialog v-model="dialog" persistent max-width="600">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="primary" dark v-bind="attrs" v-on="on">
              편집
            </v-btn>
          </template>
          <v-card>
            <v-card-title>
              <span class="headline">주소변경</span>
            </v-card-title>
            <v-card-text>
              <v-container>
                <v-row>
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
                    <input
                      type="text"
                      placeholder="우편번호"
                      v-model="postcode"/>
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
                    <v-text-field
                      type="text"
                      v-model="address"
                      placeholder="주소"
                    />
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
                </v-row>
              </v-container>
              <small>*indicates required field</small>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="dialog = false">
                Close
              </v-btn>
              <v-btn color="blue darken-1" text @click="submitInfo">
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-row>
    </v-card>
  </div>
</template>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
import { updateStoreAddress } from '@/api/store';
export default {
  data() {
    return {
      dialog: false,
      searchWindow: {
        display: 'none',
        height: '300px',
      },
      postcode: '',
      address: '',
      extraAddress: '',
      dong: '',
    };
  },
  props: {
    storeData: Object,
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
      try {
        const response = await updateStoreAddress({
          dong: this.dong,
          lat: '',
          lng: '',
          member_usercode: '',
          store_describe: '',
          store_grade: '',
          store_grade_cnt: '',
          store_location: this.address,
          store_name: '',
          storecode: this.storeData.storecode,
        });
        this.$router.go(this.$router.currentRoute);
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style></style>
