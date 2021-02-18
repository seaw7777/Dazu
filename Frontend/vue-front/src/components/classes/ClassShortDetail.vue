<template>
  <div class="row">
    <div class="col-lg-6">
      <div class="product__details__img">
        <div class="product__details__big__img">
          <img class="big_img" :src="imgurl" alt="" />
        </div>
      </div>
    </div>
    <div class="col-lg-6">
      <div class="product__details__text">
        <v-row>
          <div class="product__label">
            {{ classData.store_information_store_name }}
          </div>

          <div class="text-center">
            <v-rating
              v-model="classData.store_information_store_grade"
              background-color="orange lighten-3"
              color="orange"
              medium
              readonly
            ></v-rating>
          </div>
        </v-row>
        <h4>{{ classData.class_name }}</h4>
        <h5>{{ classData.class_price }}원</h5>
        <ul>
          <li>
            분류: <span>{{ classData.food_type }}</span>
          </li>
          <li>
            밀키트: <span>{{ classData.mealkit_ok }}</span>
          </li>
          <li>
            난이도: <span>{{ classData.class_difficult }}</span>
          </li>
          <li>
            최대인원: <span>{{ classData.class_max }}</span>
          </li>
          <li>
            강의시간: <span>{{ classData.class_time }}</span>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pic: '',
    };
  },

  props: {
    classData: {
      type: Object,
      required: true,
    },
    imgurl: {
      type: String,
      requried: true,
    },
  },
  computed: {
    comclass: function () {
      return this.classData.class_name;
    },
    comclasscode: function () {
      return this.classData.classcode;
    },
  },
};
</script>

<style scoped>
.flex-container {
  display: flex;
}
</style>
