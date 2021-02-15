<template>
  <div>
    <v-img src="@/assets/page.jpg"></v-img>
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
    const code = this.classdata.classcode;
    console.log('클래스 소개' + code);
  },
};
</script>

<style></style>
