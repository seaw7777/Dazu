<template>
  <div>
    <section class="checkout spad">
      <div class="container">
        <div class="checkout__form">
          <form action="#">
            <div class="row">
              <div class="col-lg-12 col-md-6">
                <h6 class="checkout__title">고객님 회원가입</h6>

                <div class="row">
                  <div class="col-lg-8">
                    <div class="checkout__input">
                      <p>Postcode<span>*</span></p>
                      <div class="row">
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
                        <div class="col-lg-9">
                          <input
                            type="text"
                            placeholder="우편번호"
                            v-model="postcode"
                          />
                        </div>
                        <div class="col-lg-3">
                          <v-btn
                            tile
                            large
                            elevation="0"
                            style="background: rgba(226, 108, 12, 0.2);color: #111111;position: absolute;"
                            value="우편번호 찾기"
                            @click="execDaumPostcode"
                            >우편번호 찾기</v-btn
                          >
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-lg-4">
                    <div class="checkout__input">
                      <p>Dong<span>*</span></p>
                      <input type="text" v-model="dong" />
                    </div>
                  </div>
                </div>

                <div class="checkout__input">
                  <p>Address<span>*</span></p>
                  <input
                    type="text"
                    placeholder="도로명주소"
                    v-model="address"
                  />
                  <input
                    type="text"
                    v-model="extraAddress"
                    placeholder="상세주소 (optinal)"
                  />
                </div>

                <v-btn
                  tile
                  elevation="0"
                  large
                  style="font-size: 14px;color: #ffffff;background: #111111;font-weight: 600;border: none;text-transform: uppercase;display: inline-block;letter-spacing: 2px;padding: 14px 30px;"
                  block
                  @click="submitInfo"
                >
                  NEXT
                </v-btn>
              </div>
            </div>
          </form>
        </div>
      </div>
    </section>
    -->
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
      dong: '',
      usertype: '1',
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
      try {
        console.log('data3' + this.dong);
        const extrainfo = {
          dong: this.dong,
          usertype: this.usertype,
        };
        const response = await customerInfoAPI({
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
        this.$router.push('/main');
        console.log(response);
        console.log('고객님 회원가입 완료');
      } catch (error) {
        console.log('error');
      }
    },
  },
};
</script>

<style></style>
