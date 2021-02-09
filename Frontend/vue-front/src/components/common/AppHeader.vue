<template>
  <div class="fixed-top">
    <b-navbar toggleable="lg" type="light" variant="warning" sticky="true">
      <b-navbar-brand :to="logoLink">
        <b-img
          :src="require('@/assets/DAZUnewlogo.png')"
          class="d-inline-block align-top"
          width="80"
          hegith="80"
          alt="DAZU"
      /></b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item to="/class/list">클래스</b-nav-item>
          <b-nav-item to="/mealkit/list">스토어</b-nav-item>
          <b-nav-item to="/community">커뮤니티</b-nav-item>
          <b-nav-item to="/notice/list">공지사항</b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-form>
            <b-form-input
              size="sm"
              class="mr-sm-2"
              placeholder="Search"
            ></b-form-input>
            <b-button size="sm" class="my-2 my-sm-0" type="submit"
              >Search</b-button
            >
          </b-nav-form>
          <v-avatar>
            <b-avatar href="#" :src="userImgUrl"></b-avatar>
          </v-avatar>

          <b-nav-item-dropdown right>
            <!-- Using 'button-content' slot -->
            <template #button-content>
              <em>{{ $store.state.username }}</em>
            </template>
            <b-dropdown-item :to="mypageLink"> Mypage</b-dropdown-item>
            <b-dropdown-item href="javascript:;" @click="logoutUser"
              >Log Out</b-dropdown-item
            >
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
import { deleteCookie } from '@/utils/cookies';
import { logoutUser } from '@/api/auth';
export default {
  data() {
    return {
      token: '',
    };
  },
  computed: {
    isUserLogin() {
      return this.$store.getters.isLogin;
    },
    logoLink() {
      return this.$store.getters.isLogin ? '/main' : '/user';
    },
    mypageLink() {
      return this.$store.state.usertype == '1'
        ? '/mypage/1/' + this.$store.state.usercode
        : '/mypage/0/' + this.$store.state.usercode;
    },
    userImgUrl() {
      return this.$store.getters.isLogin ? this.$store.state.userimg : '/';
    },
  },
  methods: {
    async logoutUser() {
      this.token = this.$store.state.token;
      console.log(this.token);
      await logoutUser(this.token);
      this.$store.commit('clearUsername');
      this.$store.commit('clearToken');
      this.$store.commit('clearUserimg');
      this.$store.commit('clearUserCode');
      this.$store.commit('clearUserType');
      this.$store.commit('clearStoreCode');
      deleteCookie('til_auth');
      deleteCookie('til_user');
      deleteCookie('til_img');
      deleteCookie('til_usercode');
      deleteCookie('til_usertype');
      deleteCookie('til_storecode');
      this.$router.push('/user');
    },
  },
};
</script>

<style></style>
