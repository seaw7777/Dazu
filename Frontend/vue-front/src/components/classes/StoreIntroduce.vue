<template>
  <div>
    가게 코드 {{ storecode }}
    <v-img :src="imgsrc" />
  </div>
</template>

<script>
import { fetchClass } from '@/api/classes';

export default {
  data() {
    return {
      storecode: '',
      imgsrc: '',
    };
  },

  async mounted() {
    const id = this.$route.params.id;
    // console.log(id);
    const { data } = await fetchClass(id);
    console.log('가게 소개 mounted:  ' + data.store_information_storecode);
    this.storecode = data.store_information_storecode;
    this.imgsrc =
      'https://i4d104.p.ssafy.io/dazu/file/image/' +
      this.storecode +
      '_store_intro';
  },
};
</script>

<style></style>
