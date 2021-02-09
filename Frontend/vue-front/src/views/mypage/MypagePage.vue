<template>
  <div class="flex-container">
    <div class="user-container">
      <div><MypageUserInfo :customerData="customerData"></MypageUserInfo></div>
      <div>
        <MypageCalendar></MypageCalendar>
      </div>
    </div>
    <div class="user-class-container">
      <div class="user-class"><MypageUserClass></MypageUserClass></div>
      <div><MypageComingClass></MypageComingClass></div>
    </div>
  </div>
</template>

<script>
import { MypageCustomerInfo } from '@/api/mypage';

import MypageCalendar from '@/components/customer_mypages/MypageCalendar.vue';
import MypageComingClass from '@/components/customer_mypages/MypageComingClass.vue';
import MypageUserClass from '@/components/customer_mypages/MypageUserClass.vue';
import MypageUserInfo from '@/components/customer_mypages/MypageUserInfo.vue';
export default {
  components: {
    MypageCalendar,
    MypageComingClass,
    MypageUserClass,
    MypageUserInfo,
  },
  data() {
    return {
      customerData: {},
      classDataList: {},
    };
  },
  async created() {
    const userid = this.$store.state.usercode;
    console.log(userid);
    const response = await MypageCustomerInfo(userid);
    console.log(response.data);
    this.customerData = response.data;
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
.user-class-container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: column;
  align-items: stretch;
}
</style>
