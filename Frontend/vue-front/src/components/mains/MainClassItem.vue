<template>
  <div>
    <v-card class="mx-auto" max-width="400">
      <v-img
        class="white--text align-end"
        height="200px"
        src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
      >
        <v-card-title>{{ classItem.class_name }}</v-card-title>
      </v-img>

      <v-card-subtitle class="pb-0">
        {{ classItem.class_describe }}
      </v-card-subtitle>

      <v-card-text class="text--primary">
        <div>난이도 : {{ classItem.class_difficult }}</div>
        <div>오픈 : {{ classItem.class_startdate }}</div>
        <div>마감 : { classItem.class_enddate }}</div>
        <div>밀키트 : {{ classItem.mealkit_ok }}</div>
        <div>가격 : {{ classItem.class_price }}</div>
      </v-card-text>

      <v-card-actions>
        <v-btn color="orange" text>
          Share
        </v-btn>

        <v-btn color="orange" text>
          Explore
        </v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
export default {
  props: {
    classItem: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style></style>
