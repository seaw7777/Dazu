<template>
  <div class="customer-mypage">
    <v-avatar size="230">
      <img :src="userImgUrl" alt="this.$store.username" />
    </v-avatar>
    <div class="customer-info">
      <div>이름 : {{ this.customerData.nickname }}</div>
      <div>주소 : {{ this.customerData.address }}</div>
      <div>상세주소 : {{ this.customerData.address_detail }}</div>
      <div>동 : {{ this.customerData.dong }}</div>
      <v-btn depressed color="error">
        주소변경
      </v-btn>
    </div>
  </div>
</template>

<script>
// import { MypageCustomerInfo } from '@/api/mypage';
export default {
  props: {
    customerData: {
      type: Object,
      required: true,
    },
  },

  computed: {
    userImgUrl() {
      return this.$store.state.userimg;
    },
    userName() {
      return this.$store.state.username;
    },
  },
};
</script>

<style>
.customer-mypage {
  display: flex;
  align-items: center;
}
.customer-info {
  padding: 40px;
}
</style>
