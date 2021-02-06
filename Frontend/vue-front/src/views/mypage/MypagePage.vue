<template>
  <div>
    <div class="user-container">
      <div><MypageUserInfo :customerData="customerData"></MypageUserInfo></div>
      <div>
        <MypageCalendar></MypageCalendar>
      </div>
    </div>
    <div><MypageUserClass></MypageUserClass></div>
    <div><MypageComingClass></MypageComingClass></div>
  </div>
</template>

<script>
import { MypageCustomerInfo } from '@/api/mypage';

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
  data() {
    return {
      customerData: {},
      classDataList: {},
    };
  },
  async created() {
    const userid = this.$store.state.usercode;
    console.log(userid);
    const response = await MypageCustomerInfo(1);
    console.log(response.data);
    this.customerData = response.data;
  },
};
</script>

<style scoped>
.user-container {
  display: flex;
  justify-content: center;
}
</style>
