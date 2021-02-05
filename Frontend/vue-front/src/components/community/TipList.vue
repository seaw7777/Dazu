<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="tipList"
      :items-per-page="5"
      class="elevation-1"
    ></v-data-table>
  </div>
</template>

<script>
import { getTipList } from '@/api/community';
export default {
  data() {
    return {
      headers: [
        {
          text: 'No',
          align: 'start',
          sortable: false,
          value: 'board_code',
        },
        { text: '작성자', value: 'member_usercode', sortable: false },
        { text: '제목', value: 'board_title', sortable: false },
      ],
      tipList: [],
    };
  },
  async created() {
    const tipList = await getTipList('""');
    this.tipList = tipList.data;
  },
};
</script>

<style></style>
