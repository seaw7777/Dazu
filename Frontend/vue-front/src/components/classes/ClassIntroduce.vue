<template>
  <div>
    <v-img src="@/assets/page.jpg"></v-img>
  </div>
</template>

<script>
import { fetchClass } from '@/api/classes';

export default {
  data() {
    return {
      classcode: '',
    };
  },

  async mounted() {
    const id = this.$route.params.id;
    // console.log(id);
    const { data } = await fetchClass(id);
    console.log('클래스 소개 mounted:  ' + data.classcode);
    this.classcode = data.classcode;
  },
};
</script>

<style></style>
