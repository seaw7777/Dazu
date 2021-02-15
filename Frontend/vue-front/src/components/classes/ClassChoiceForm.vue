<template>
  <div class="checkout__order">
    <h6 class="order__title">STEP1. 강좌유형 선택</h6>
    <v-select
      @click="mealkitCheck"
      :items="items"
      label="유형 선택"
      dense
      solo
      v-model="mealkitchoice"
    ></v-select>
    <h6 class="order__title">STEP2. 클래스 날짜 선택</h6>
    <div class="calendar-container">
      <ClassChoiceCalendar
        :mealkitchoice="mealkitchoice"
        :classData="classData"
      ></ClassChoiceCalendar>
    </div>
  </div>
</template>

<script>
import ClassChoiceCalendar from '@/components//classes/ClassChoiceCalendar.vue';
export default {
  data() {
    return {
      mealkitchoice: '',
      items: [],
    };
  },
  props: {
    classData: {
      type: Object,
      required: true,
    },
  },
  components: {
    ClassChoiceCalendar,
  },
  methods: {
    mealkitCheck() {
      console.log(this.classData.mealkit_ok);
      if (this.classData.mealkit_ok === '제공') {
        this.items = ['밀키트 포함', '밀키트 미포함', 'Only 밀키트'];
      } else {
        this.items = ['클래스 가격'];
      }
    },
  },
};
</script>

<style scoped>
.flex-container {
  display: flex;
  flex-direction: column;
  width: 300px;
  /* height: 400px; */
}
</style>
