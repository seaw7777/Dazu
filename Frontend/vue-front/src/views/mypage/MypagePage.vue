<template>
  <div>
    <div class="breadcrumb-option">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-6">
            <div class="breadcrumb__text">
              <h2>MyPage</h2>
            </div>
          </div>
        </div>
      </div>
    </div>
    <section class="checkout spad">
      <div class="container">
        <div class="checkout__form">
          <div class="row">
            <div class="col-lg-8 col-md-6">
              <MypageUserInfo :customerData="customerData"></MypageUserInfo>
            </div>
            <div class="col-lg-4 col-md-6">
              <div class="checkout__order">
                <h6 class="order__title text-center">My Schedule</h6>
                <MypageCalendar></MypageCalendar>
                <br />
                <hr />
                <br />
                <MypageUserClass></MypageUserClass>
              </div>
            </div>
          </div>
          <br /><br />
          <MypageComingClass></MypageComingClass>
        </div>
      </div>
    </section>
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
