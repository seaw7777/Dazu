<template>
  <div>
    <v-img
      lazy-src="require(@/assets/page.jpg)"
      src="@/assets/page.jpg"
    ></v-img>
  </div>
</template>

<script>
export default {
  props: {
    classdata: {
      type: Object,
      required: true,
    },
  },
  created() {
    const classcode = this.classdata.classcode;
    console.log('클래스 소개' + classcode);
  },
};
</script>

<style></style>
