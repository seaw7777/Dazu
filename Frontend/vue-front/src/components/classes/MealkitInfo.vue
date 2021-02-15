<template>
  <div>
    <v-img
      lazy-src="require(@/assets/mealkit.jpg)"
      src="@/assets/mealkit.jpg"
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
    const code = this.classdata.classcode;
    console.log('밀키트 소개' + code);
  },
};
</script>

<style></style>
