<template>
  <div>가게 소개 탭</div>
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
    const code = this.classdata.store_information_storecode;
    console.log('가게소개' + code);
  },
};
</script>

<style></style>
