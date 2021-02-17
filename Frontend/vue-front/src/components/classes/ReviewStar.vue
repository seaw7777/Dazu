<template>
  <div>
    <v-rating
      class="star"
      v-model="class_point"
      background-color="orange lighten-3"
      color="orange lighten-3"
      readonly
    ></v-rating>
  </div>
</template>

<script>
import '../../assets/css/review.scss';

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
