<template>
  <div class="product__item" @click="classclick">
    <div class="product__item__pic set-bg" data-setbg="pic">
      <img class="food-img" :src="pic" />
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
        <a @click="classclick">Go to Class</a>
      </div>
    </div>
  </div>
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

<style scoped>
.product__item {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.product__item__pic {
  display: flex;
  flex-shrink: 0;
}
</style>
