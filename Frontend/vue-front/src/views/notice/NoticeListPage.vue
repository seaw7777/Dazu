<template>
  <div>
    <v-row no-gutters>
      <NoticeListTable></NoticeListTable>
    </v-row>
  </div>
</template>
<script>
import NoticeListTable from '@/components/notice/NoticeListTable.vue';
export default {
  components: {
    NoticeListTable,
  },
};
</script>
<style scope></style>
