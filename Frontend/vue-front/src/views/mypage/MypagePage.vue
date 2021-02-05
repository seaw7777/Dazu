<template>
  <div>
    <div><MypageCalendar></MypageCalendar></div>
    <div><MypageComingClass></MypageComingClass></div>
    <div><MypageUserClass></MypageUserClass></div>
    <div><MypageUserInfo></MypageUserInfo></div>
  </div>
</template>

<script>
import MypageCalendar from '@/components/mypages/MypageCalendar.vue';
import MypageComingClass from '@/components/mypages/MypageComingClass.vue';
import MypageUserClass from '@/components/mypages/MypageUserClass.vue';
import MypageUserInfo from '@/components/mypages/MypageUserInfo.vue';
export default {
  components: {
    MypageCalendar,
    MypageComingClass,
    MypageUserClass,
    MypageUserInfo,
  },
};
</script>

<style></style>
