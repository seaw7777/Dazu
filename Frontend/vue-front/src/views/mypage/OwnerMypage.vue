<template>
  <div>
    사장님 마이페이지
    <div><MypageOwnerInfo></MypageOwnerInfo></div>
    <div><MypageCalendar></MypageCalendar></div>
    <div><MypageGraph></MypageGraph></div>
  </div>
</template>

<script>
import MypageCalendar from '@/components/owner_mypage/MypageCalendar.vue';
import MypageGraph from '@/components/owner_mypage/MypageGraph.vue';
import MypageOwnerInfo from '@/components/owner_mypage/MypageOwnerInfo.vue';

export default {
  components: {
    MypageCalendar,
    MypageGraph,
    MypageOwnerInfo,
  },
};
</script>

<style></style>
