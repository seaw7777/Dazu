<template>
  <div class="flex-container">
    <div class="user-container">
      <div><MypageOwnerInfo></MypageOwnerInfo></div>
      <div><MypageCalendar></MypageCalendar></div>
    </div>
    <div><MypageGraph></MypageGraph></div>
    <div><MypageOwnerClassList></MypageOwnerClassList></div>
  </div>
</template>

<script>
import MypageCalendar from '@/components/owner_mypage/MypageCalendar.vue';
import MypageGraph from '@/components/owner_mypage/MypageGraph.vue';
import MypageOwnerInfo from '@/components/owner_mypage/MypageOwnerInfo.vue';
import MypageOwnerClassList from '@/components/owner_mypage/MypageOwnerClassList.vue';

export default {
  components: {
    MypageCalendar,
    MypageGraph,
    MypageOwnerInfo,
    MypageOwnerClassList,
  },
};
</script>

<style scoped>
.flex-container {
  margin-left: auto;
  margin-right: auto;
}
.user-container {
  display: flex;
  justify-content: center;
}
</style>
