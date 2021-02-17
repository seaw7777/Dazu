<template>
  <div>
    <div class="blog__sidebar__item">
      <h5>MY Classes</h5>

      <div
        class="blog__sidebar__recent"
        v-for="item in classDataList"
        :key="item.name"
      >
        <router-link
          :to="'/class/detail/' + item.classcode"
          tag="a"
          class="blog__sidebar__recent__item"
        >
          <div class="blog__sidebar__recent__item__pic">
            <img :src="imgsrc(item.classcode)" alt="" />
          </div>
          <div class="blog__sidebar__recent__item__text">
            <p>{{ item.class_name }}</p>
            <span
              >{{ item.class_date }} | {{ item.class_starttime.slice(0, 5) }} -
              {{ item.class_endtime.slice(0, 5) }}</span
            >
          </div>
        </router-link>
      </div>
    </div>
    <!-- <v-alert
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
    </v-alert> -->
    <!-- <v-row no-gutters>
      <v-col cols="12">
        <v-simple-table fixed-header height="200px">
          <template v-slot:default>
            <thead>
              <tr>
                <th class="text-center">
                  클래스 이름
                </th>
                <th class="text-center">
                  날짜
                </th>
                <th class="text-center">
                  시간
                </th>
                <th class="text-center">
                  클래스 바로가기
                </th>
                <th class="text-center">
                  수업입장
                </th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="item in classDataList" :key="item.name">
                <td class="text-center">{{ item.class_name }}</td>
                <td class="text-center">{{ item.class_date }}</td>
                <td class="text-center">
                  {{ item.class_starttime.slice(0, 5) }}
                </td>
                <td>
                  <v-btn
                    :to="'/class/detail/' + item.classcode"
                    class="ma-2"
                    color="orange"
                    style="display: flex;"
                    >클레스 상세
                  </v-btn>
                </td>

                <td>
                  <div>
                    <div class="text-center mb-4">
                      <v-btn color="primary" @click="gotoClass(item.class_url)">
                        Toggle
                      </v-btn>
                    </div>
                  </div>
                </td>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
      </v-col>
    </v-row> -->
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
      var imgsrc = 'https://i4d104.p.ssafy.io/' + code + '_class_Thumbnail';
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
.ma-2 {
  background-color: orange;
  text-color: black;
}
</style>
