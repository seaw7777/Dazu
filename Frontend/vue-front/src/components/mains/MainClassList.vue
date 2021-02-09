<template>
  <div></div>
</template>
<script>
import { fetchClasses } from '@/api/classes';
export default {
  data() {
    return {
      list: [],
    };
  },
  async created() {
    const { data } = fetchClasses('우이동');
    this.list = data;
  },
};
</script>
<style scope></style>
