<template>
  <div>
    <td class="product__cart__item">
      <div class="product__cart__item__pic">
        <img :src="imgsrc()" alt="" />
      </div>
      <div class="product__cart__item__text">
        <h6>{{ classSimpleItem.class_name }}</h6>
      </div>
    </td>
    <td class="cart__price">₩ {{ classSimpleItem.class_price }}</td>
    <td class="cart__stock">{{ classSimpleItem.food_type }}</td>
    <td
      class="cart__btn"
      v-if="classSimpleItem.mealkit_ok === '제공'"
      style="vertical-align: middle;"
    >
      <Calendars
        :classcode="classSimpleItem.classcode"
        :class_name="classSimpleItem.class_name"
      ></Calendars>
      <Mealkits :classcode="classSimpleItem.classcode"></Mealkits>
    </td>
    <td class="cart__btn" v-if="classSimpleItem.mealkit_ok === '미제공'">
      <Calendars
        :classcode="classSimpleItem.classcode"
        :class_name="classSimpleItem.class_name"
      ></Calendars>
    </td>
    <td class="cart__btn">
      <UpdateClass :classSimpleItem="classSimpleItem"></UpdateClass>
    </td>
    <td class="cart__btn">
      <v-btn color="error" fab small dark @click="deleteClass">
        <v-icon>mdi-trash-can</v-icon>
      </v-btn>
    </td>
  </div>
</template>
<script>
import UpdateClass from '@/components/stores/UpdateClass.vue';
import Calendars from '@/components/stores/Calendars.vue';
import Mealkits from '@/components/stores/Mealkits.vue';
import { deleteClass } from '@/api/classes';
export default {
  components: {
    UpdateClass,
    Calendars,
    Mealkits,
  },
  props: {
    classSimpleItem: {
      type: Object,
      required: true,
    },
  },
  methods: {
    imgsrc: function() {
      var imgsrc =
        'https://i4d104.p.ssafy.io/file/image' +
        this.classSimpleItem.classcode +
        '_class_Thumbnail';
      console.log('클래스 심플 아이템 이미지 : ' + imgsrc);
      return imgsrc;
    },
    async deleteClass() {
      const id = this.classSimpleItem.classcode;
      await deleteClass(id);
    },
  },
};
</script>
<style scope></style>
