<template>
  <div>가게 코드 {{ storecode }}</div>
</template>

<script>
import { fetchClass } from '@/api/classes';

export default {
  data() {
    return {
      storecode: '',
    };
  },

  async mounted() {
    const id = this.$route.params.id;
    // console.log(id);
    const { data } = await fetchClass(id);
    console.log('클래스 소개 mounted:  ' + data.store_information_storecode);
    this.storecode = data.store_information_storecode;
  },
};
</script>

<style></style>
