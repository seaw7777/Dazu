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
              <MypageOwnerInfo></MypageOwnerInfo>
            </div>
            <div class="col-lg-4 col-md-6">
              <div class="checkout__order">
                <h6 class="order__title text-center">My Schedule</h6>
                <MypageCalendar></MypageCalendar>
                <br />
                <hr />
                <button class="site-btn" @click="gotoStoreEdit">
                  나의 가게 바로가기
                </button>
                <br />
                <hr />
                <br />
                <MypageOwnerClassList></MypageOwnerClassList>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import MypageCalendar from '@/components/owner_mypage/MypageCalendar.vue';
import MypageOwnerInfo from '@/components/owner_mypage/MypageOwnerInfo.vue';
import MypageOwnerClassList from '@/components/owner_mypage/MypageOwnerClassList.vue';

export default {
  components: {
    MypageCalendar,
    MypageOwnerInfo,
    MypageOwnerClassList,
  },
  methods: {
    gotoStoreEdit() {
      this.$router.push(`/mystore/${this.$store.state.usercode}`);
    },
  },
  created() {
    if (!this.$store.getters.isLogin) {
      console.log('goto loginBtn');
      this.$router.push('/user');
    } else {
      this.$store.state.header = '1';
    }
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
