<template>
  <div>
    <v-btn depressed>
      작성
    </v-btn>
    <br /><br />
    <v-card>
      <v-data-table
        :headers="headers"
        :items="notices"
        :search="search"
      ></v-data-table>
    </v-card>
  </div>
</template>

<script>
import { fetchClassNotice } from '@/api/classes';
export default {
  data() {
    return {
      headers: [
        { text: '제목', value: 'class_notice_board_title' },
        { text: '작성일', value: 'class_notice_board_datetime' },
        { text: '조회수', value: 'class_notice_board_visit' },
      ],
      notices: [],
    };
  },
  async created() {
    const id = this.$route.params.id;
    console.log(id);
    const { data } = await fetchClassNotice(id);
    this.notices = data;
    console.log(data);
  },
};
</script>

<style></style>
