<template>
  <div>
    <v-rating
      v-model="class_point"
      background-color="orange lighten-3"
      color="orange"
      medium
      readonly
    ></v-rating>
  </div>
</template>

<script>
export default {
  props: {
    class_point: {
      type: Number,
      required: true,
    },
  },
};
</script>

<style></style>
