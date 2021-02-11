<template>
  <div class="customer-mypage">
    <v-avatar size="230">
      <img :src="userImgUrl" alt="this.$store.username" />
    </v-avatar>
    <div class="customer-info">
      <div>이름 : {{ this.customerData.nickname }}</div>
      <div>주소 : {{ this.customerData.address }}</div>
      <div>상세주소 : {{ this.customerData.address_detail }}</div>
      <div>동 : {{ this.customerData.dong }}</div>

      <div>
        <v-row>
          <v-dialog v-model="dialog" persistent max-width="600px">
            <template v-slot:activator="{ on, attrs }">
              <v-btn color="primary" dark v-bind="attrs" v-on="on">
                Open Dialog
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
                      <v-text-field
                        type="text"
                        v-model="dong"
                        placeholder="동"
                      />
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
      </div>
    </div>
  </div>
</template>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
import { MypageCustomerInfo, MypageCustomerEditAddress } from '@/api/mypage';
export default {
  props: {
    customerData: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      searchWindow: {
        display: 'none',
        height: '300px',
      },
      dialog: false,
      postcode: '',
      address: '',
      extraAddress: '',
      dong: '',
      usertype: '1',
    };
  },
  computed: {
    userImgUrl() {
      return this.$store.state.userimg;
    },
    userName() {
      return this.$store.state.username;
    },
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
              this.dong = data.bname;
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
        console.log('data3' + this.dong);
        const extrainfo = {
          dong: this.dong,
          usertype: this.usertype,
        };
        const response = await MypageCustomerEditAddress({
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
        this.$store.dispatch('EXTRAINFO', extrainfo);
        this.$router.go(this.$router.currentRoute);
        console.log('고객님 주소변경 완료');
      } catch (error) {
        console.log(error);
      }
    },
  },
  async created() {
    const res = await MypageCustomerInfo(this.$store.state.usercode);
    console.log(res.data);
    this.address = res.data.address;
    this.dong = res.data.dong;
    this.extraAddress = res.data.address_detail;
  },
};
</script>

<style>
.customer-mypage {
  display: flex;
  align-items: center;
}
.customer-info {
  padding: 40px;
}
</style>
