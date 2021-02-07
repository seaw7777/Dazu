<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="notices"
      class="elevation-1"
      @click:row="gotoNoticeDetail"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>공지사항</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <v-dialog v-model="dialog" max-width="500px">
            <template v-slot:activator="{ on, attrs }">
              <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">
                새 글 등록
              </v-btn>
            </template>
          </v-dialog>
        </v-toolbar>
      </template>
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
          align: 'start',
          sortable: false,
          value: 'main_notice_board_code',
        },
        { text: '제목', value: 'main_notice_board_title', sortable: false },
        {
          text: '등록일',
          value: 'main_notice_board_write_datetime',
          sortable: false,
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
      this.$router.push('/notice/detail/' + notice.main_notice_board_code);
    },
  },
};
</script>
<style scope></style>
