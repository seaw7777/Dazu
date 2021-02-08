<template>
  <div></div>
</template>
<script>
import { fetchKAKAOPAYAccount } from '@/api/classes';
export default {
  async created() {
    const pg_token = this.$route.query.pg_token;
    const { data } = await fetchKAKAOPAYAccount(pg_token);
    console.log(data);
    window.close();
  },
};
</script>
<style scope></style>
