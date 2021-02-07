<template>
  <div>
    <v-card class="mx-auto" max-width="400" @click="mealkitClick">
      <v-img
        class="white--text align-end"
        height="200px"
        src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
      >
        <v-card-title>{{ mealkitItem.mealkit_name }}</v-card-title>
      </v-img>

      <v-card-subtitle class="pb-0">
        {{ mealkitItem.class_information_classname }}
      </v-card-subtitle>

      <v-card-text class="text--primary">
        <div>가격 : {{ mealkitItem.mealkit_price }}</div>
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
    mealkitItem: {
      type: Object,
      required: true,
    },
  },
  methods: {
    mealkitClick() {
      const id = this.mealkitItem.class_information_classcode;
      this.$router.push(`/class/detail/${id}`);
    },
  },
};
</script>

<style></style>
