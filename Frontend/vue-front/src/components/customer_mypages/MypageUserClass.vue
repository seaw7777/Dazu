<template>
  <div>
    <div class="blog__sidebar__item">
      <h5>MY Classes</h5>
      <v-alert
        :value="alert"
        color="pink"
        dark
        border="top"
        icon="mdi-home"
        transition="scale-transition"
      >
        수업준비중입니다.
        <v-btn color="white" outlined @click="alert = !alert">
          close
        </v-btn>
      </v-alert>
      <div
        class="blog__sidebar__recent"
        v-for="item in classDataList"
        :key="item.name"
      >
        <div class="blog__sidebar__recent__item">
          <div class="blog__sidebar__recent__item__pic">
            <img
              :src="imgsrc(item.classcode)"
              alt=""
              style="width:90px;height:90px;"
            />
          </div>
          <div class="blog__sidebar__recent__item__text">
            <router-link :to="'/class/detail/' + item.classcode" tag="p">{{
              item.class_name
            }}</router-link>
            <span
              >{{ item.class_date.slice(5, 10) }} |
              {{ item.class_starttime.slice(0, 5) }} -
              {{ item.class_endtime.slice(0, 5) }}</span
            >&nbsp;
            <span
              ><v-btn
                tile
                elevation="0"
                style="display: inline-block;font-size: 15px;font-weight: 600;text-transform: uppercase; background: black;color:white;letter-spacing: 2px;"
                @click="gotoClass(item.class_url)"
              >
                강의
                <v-icon>mdi-arrow-right-thick</v-icon>
              </v-btn></span
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { MypageCustomerClass } from '@/api/mypage';

export default {
  data() {
    return {
      classDataList: [],
      alert: false,
    };
  },
  methods: {
    imgsrc: function(code) {
      var imgsrc =
        'https://i4d104.p.ssafy.io/dazu/file/image/' +
        code +
        '_class_Thumbnail';
      console.log(' 이미지 패스 로그 : ' + imgsrc);
      return imgsrc;
    },
    gotoClass(url) {
      console.log(url);
      if (url === null) {
        this.alert = !this.alert;
      } else {
        window.open(url);
      }
    },
  },
  async created() {
    const userid = this.$store.state.usercode;
    console.log(userid);
    const res = await MypageCustomerClass(userid);
    this.classDataList = res.data;
  },
};
</script>

<style scoped>
.class-container {
  display: flex;
  flex-direction: column;
}
.ma-2 {
  background-color: orange;
  text-color: black;
}
</style>
