<template>
  <div>
    <v-card :loading="loading" class="mx-auto my-12" max-width="900">
      <template slot="progress">
        <v-progress-linear
          color="deep-purple"
          height="10"
          indeterminate
        ></v-progress-linear>
      </template>

      <v-card-title>
        <div class="card-title-container">
          <span>{{ noticeData.main_notice_board_title }}</span>
        </div>
      </v-card-title>

      <v-card-text>
        <div class="writer-info">
          <div class="my-4 subtitle-1 datetime">
            {{ noticeData.main_notice_board_write_datetime }}
          </div>
        </div>
        <v-sheet
          class="checkout__title"
          font-size="30px"
          color="grey lighten-4"
          elevation="1"
          height="300"
          width="800"
        >
          <div class="blog__details__text">
            <p>
              {{ noticeData.main_notice_board_contents }}
            </p>
          </div>
        </v-sheet>
      </v-card-text>
    </v-card>
    <v-row class="btn-container justify-content-center">
      <v-btn
        tile
        elevation="0"
        large
        style="font-size: 14px;color: #ffffff;background: #111111;font-weight: 600;border: none;text-transform: uppercase;display: inline-block;letter-spacing: 2px;padding: 14px 30px;"
        @click="gotoNoticeList"
        >목록</v-btn
      >
    </v-row>
  </div>
</template>
<script>
import { fetchNotice } from '@/api/notice';
export default {
  data() {
    return {
      noticeData: {},
    };
  },
  async created() {
    if (!this.$store.getters.isLogin) {
      console.log('goto loginBtn');
      this.$router.push('/user');
    } else {
      this.$store.state.header = '1';
    }
    const noticecode = this.$route.params.noticecode;
    console.log(noticecode);
    const { data } = await fetchNotice(noticecode);
    console.log(data);
    this.noticeData = data;
  },
  methods: {
    gotoNoticeList() {
      this.$router.push('/notice/list');
    },
  },
};
</script>
<style scoped>
/* .btn-container {
  margin-left: 1.2rem;
  display: flex;
  width: 30%;
  justify-content: space-evenly;
  align-items: flex-end;
} */
.card-title-container {
  margin-left: auto;
  margin-right: auto;
}
.checkout__title {
  font-size: 1.2rem;
  padding: 0.5rem;
  margin-left: auto;
  margin-right: auto;
}
.writer-info {
  display: flex;
  margin-right: 3rem;
  justify-content: flex-end;
}
.my-4 {
  margin-right: 0.5rem;
}
.comment-container {
  padding: 1rem;
  margin-left: 1.3rem;
}
.blog__details__text {
  padding: 1rem;
}
</style>
