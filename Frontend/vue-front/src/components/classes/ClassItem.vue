<template>
  <div class="product__item" @click="classclick">
    <div class="product__item__pic set-bg" data-setbg="pic">
      <img :src="pic" />
      <div class="product__label">
        <span>{{ classItem.food_type }}</span>
      </div>
    </div>
    <div class="product__item__text">
      <h6>
        <a href="#">{{ classItem.class_name }}</a>
      </h6>
      <div class="product__item__price">₩ {{ classItem.class_price }}</div>
      <div class="cart_add">
        <a href="#" @click="classclick">Go to Class</a>
      </div>
    </div>
  </div>
  <!-- <div>
    <v-card class="mx-auto" max-width="400" @click="classclick">
      <v-img
        class="white--text align-end"
        height="200px"
        src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
      >
        <v-card-title>{{ classItem.class_name }}</v-card-title>
      </v-img>

      <v-card-subtitle class="pb-0">
        {{ classItem.store_information_store_name }}
      </v-card-subtitle>

      <v-card-text class="text--primary">
        <div>난이도 : {{ classItem.class_difficult }}</div>
        <div>오픈 : {{ classItem.class_startdate }}</div>
        <div>마감 : {{ classItem.class_enddate }}</div>
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
  </div> -->
</template>

<script>
import Pic from '@/assets/img/shop/product-1.jpg';
export default {
  data() {
    return {
      pic: Pic,
    };
  },
  props: {
    classItem: {
      type: Object,
      required: true,
    },
  },
  methods: {
    classclick() {
      // console.log(this.classItem);
      const id = this.classItem.classcode;
      this.$router.push(`/class/detail/${id}`);
    },
  },
};
</script>

<style></style>
