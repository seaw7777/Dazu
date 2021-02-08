<template>
  <div class="flex-container">
    <h4>STEP1. 강좌유형 선택</h4>
    <v-select :items="items" label="유형 선택" dense solo></v-select>
    <h4>STEP2. 클래스 날짜 선택</h4>
    <div class="calendar-container">
      <ClassChoiceCalendar></ClassChoiceCalendar>
    </div>
    <img
      style="width: 70px; height: 50px;"
      src="@/assets/kakaopay.png"
      @click="onClickKakaoPayAPI"
    />
  </div>
</template>

<script>
import ClassChoiceCalendar from '@/components//classes/ClassChoiceCalendar.vue';
import { fetchKAKAOPAY } from '@/api/classes';
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
  methods: {
    async onClickKakaoPayAPI() {
      console.log('클릭페이버튼!!!!!!');
      const { data } = await fetchKAKAOPAY({
        class_information_classcode: '1',
        class_time_information_class_timecode: '',
        member_usercode: '2',
      });
      console.log(data);
      window.open(data);
    },
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
