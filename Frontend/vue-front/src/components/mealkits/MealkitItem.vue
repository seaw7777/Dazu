<template>
  <div class="product__item" @click="mealkitClick">
    <div class="product__item__pic set-bg" data-setbg="pic">
      <img :src="imgsrc()" />
      <div class="product__label">
        <span>{{ mealkitItem.class_information_classname }}</span>
      </div>
    </div>
    <div class="product__item__text">
      <h6>
        <a href="#">{{ mealkitItem.mealkit_name }}</a>
      </h6>
      <div class="product__item__price">{{ mealkitItem.mealkit_price }}원</div>
      <div class="cart_add">
        <a href="#" @click="mealkitClick">Buy Mealkit</a>
      </div>
    </div>
  </div>
</template>

<script>
import Pic from '@/assets/img/shop/product-2.jpg';
export default {
  data() {
    return { pic: Pic };
  },
  props: {
    mealkitItem: {
      type: Object,
      required: true,
    },
  },
  methods: {
    imgsrc: function() {
      var imgsrc =
        'https://i4d104.p.ssafy.io/dazu/file/image/' +
        this.mealkitItem.class_information_classcode +
        '_mealkit_Thumbnail';
      console.log('밀키트 아이템 이미지 : ' + imgsrc);
      return imgsrc;
    },
    mealkitClick() {
      const id = this.mealkitItem.class_information_classcode;
      this.$router.push(`/class/detail/${id}`);
    },
  },
};
</script>

<style></style>
