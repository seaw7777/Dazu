<template>
  <div>
    <div class="flex-container" color="blue">
      <v-container class="fill-height" fluid color="blue">
        <v-row>
          <v-col cols="12">
            <v-img
              src="https://picsum.photos/250/165?random"
              max-height="125"
              class="grey darken-4"
            ></v-img>
          </v-col>
        </v-row>
      </v-container>
      <div class="class-info-container">
        <h4>{{ classData.class_name }}</h4>
        <div>밀키트 여부 : {{ classData.mealkit_ok }}</div>
        <div>가격 : {{ classData.class_price }}</div>
        <div>음식종류 : {{ classData.food_type }}</div>
        <!-- <p>{{ comclass }}</p> -->
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    classData: {
      type: Object,
      required: true,
    },
  },
  computed: {
    comclass: function() {
      // console.log(this.classData.class_name);
      return this.classData.class_name;
    },
  },
};
</script>

<style scoped>
.flex-container {
  display: flex;
}
</style>
