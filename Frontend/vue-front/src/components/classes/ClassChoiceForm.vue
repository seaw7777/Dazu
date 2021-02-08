<template>
  <div class="flex-container">
    <h4>STEP1. 강좌유형 선택</h4>
    <v-select :items="items" label="유형 선택" dense solo></v-select>
    <h4>STEP2. 클래스 날짜 선택</h4>
    <div class="calendar-container">
      <ClassChoiceCalendar></ClassChoiceCalendar>
    </div>
    <div>가격 입력 :</div>
    <div>신청버튼</div>
  </div>
</template>

<script>
import ClassChoiceCalendar from '@/components//classes/ClassChoiceCalendar.vue';
export default {
  data() {
    return {
      items: ['밀키트o', '밀키트X', '밀키트만'],
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
};
</script>

<style scoped>
.flex-container {
  display: flex;
  flex-direction: column;
  /* height: 400px; */
}
</style>
