<template>
  <div>
    <v-img
      lazy-src="require(@/assets/mealkit.jpg)"
      src="@/assets/mealkit.jpg"
    ></v-img>
    {{ classdata }}
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
  mounted() {
    const classcode = this.classdata;
    console.log('밀키트 정보' + JSON.stringify(classcode));
  },
};
</script>

<style></style>
