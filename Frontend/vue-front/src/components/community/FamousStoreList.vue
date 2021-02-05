<template>
  <v-data-table
    :headers="headers"
    :items="famousStoreList"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>
</template>

<script>
import { getFamousStoreList } from '@/api/community';
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
      famousStoreList: [],
    };
  },
  async created() {
    const famousStoreList = await getFamousStoreList('""');
    this.famousStoreList = famousStoreList.data;
  },
};
</script>

<style></style>
