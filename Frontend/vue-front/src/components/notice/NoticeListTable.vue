<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="notices"
      :items-per-page="10"
      class="table elevation-1"
      @click:row="gotoNoticeDetail"
    >
      <template v-slot:top> </template>
    </v-data-table>
  </div>
</template>
<script>
import { fetchNotices } from '@/api/notice';
export default {
  data() {
    return {
      dialog: false,
      dialogDelete: false,
      headers: [
        {
          text: '번호',
          align: 'center',
          sortable: false,
          value: 'main_notice_board_code',
        },
        {
          text: '제목',
          value: 'main_notice_board_title',
          sortable: false,
          align: 'center',
        },
        {
          text: '등록일',
          value: 'main_notice_board_write_datetime',
          sortable: false,
          align: 'center',
        },
      ],
      notices: [],
    };
  },
  async created() {
    const { data } = await fetchNotices();
    this.notices = data;
  },

  methods: {
    gotoNoticeDetail(notice) {
      const noticecode = notice.main_notice_board_code;
      this.$router.push(`/notice/detail/${noticecode}`);
    },
  },
};
</script>
<style scope>
.table {
  width: 70%;
  margin-left: auto;
  margin-right: auto;
}
th {
  font-size: 24px;
}
.board-form {
  display: grid;
  grid-template-areas: 'textarea writebtn';
  align-content: center;
  justify-content: end;
}
</style>
