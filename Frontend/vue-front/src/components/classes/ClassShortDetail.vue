<template>
  <div class="row">
    <div class="col-lg-6">
      <div class="product__details__img">
        <div class="product__details__big__img">
          <img class="big_img" :src="pic" alt="" />
        </div>
      </div>
    </div>
    <div class="col-lg-6">
      <div class="product__details__text">
        <div class="product__label">{{ classData.food_type }}</div>
        <h4>{{ classData.class_name }}</h4>
        <h5>{{ classData.class_price }}원</h5>
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod
          tempor incididunt ut labore et dolore magna aliqua. Quis ipsum
          suspendisse ultrices gravida
        </p>
        <ul>
          <li>
            Mealkit: <span>{{ classData.mealkit_ok }}</span>
          </li>
          <!-- <li>Category: <span>Biscuit cake</span></li>
          <li>Tags: <span>Gadgets, minimalisstic</span></li> -->
        </ul>
        <div class="product__details__option">
          <a href="#" class="primary-btn">Take classe</a>
          <a href="#" class="heart__btn"
            ><span class="icon_heart_alt"></span
          ></a>
        </div>
      </div>
    </div>
  </div>
  <!-- <div>
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
         <p>{{ comclass }}</p> 
      </div>
    </div>
  </div> -->
</template>

<script>
import Pic from '@/assets/img/shop/details/product-big-1.jpg';
export default {
  data() {
    return {
      pic: Pic,
    };
  },
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
