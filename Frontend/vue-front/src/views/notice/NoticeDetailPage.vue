<template>
  <div>
    <v-card class="mx-auto" max-width="1000" tile>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title>{{
            noticeData.main_notice_board_title
          }}</v-list-item-title>
          <v-list-item-subtitle>{{
            noticeData.main_notice_board_write_datetime
          }}</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>

      <v-list-item two-line>
        <v-list-item-content>
          <v-list-item-title>{{
            noticeData.main_notice_board_contents
          }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-card>
    <v-btn depressed color="primary" @click="gotoNoticeList">
      목록
    </v-btn>
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
<style scope></style>
