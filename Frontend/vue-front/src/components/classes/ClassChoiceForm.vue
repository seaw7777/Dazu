<template>
  <div class="flex-container">
    <h4>STEP1. 강좌유형 선택</h4>
    <v-select
      @click="mealkitCheck"
      :items="items"
      label="유형 선택"
      dense
      solo
      v-model="mealkitchoice"
    ></v-select>

    <h4>STEP2. 클래스 날짜 선택</h4>
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
import { postKAKAOPAYReady } from '@/api/classes';
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
    async onClickKakaoPayAPI() {
      console.log('클릭페이버튼!!!!!!');
      const { data } = await postKAKAOPAYReady({
        item_name: '클래스1',
        total_amount: 21000,
        class_information_classcode: '1',
        class_time_information_class_timecode: '',
        member_usercode: '2',
      });
      console.log(data);
      window.open(data);
    },

    mealkitCheck() {
      console.log(this.classData.mealkit_ok);
      if (this.classData.mealkit_ok === 'o') {
        this.items = ['밀키트o', '밀키트X', '밀키트만'];
      } else {
        this.items = ['밀키트o', '밀키트X'];
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
