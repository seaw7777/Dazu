<template>
  <div v-if="isUserLogin">
    <b-navbar toggleable="lg" type="light" variant="warning">
      <b-navbar-brand :to="logoLink">
        <b-img
          :src="require('@/assets/DAZUlogo.png')"
          class="d-inline-block align-top"
          width="80"
          hegith="80"
          alt="DAZU"
      /></b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item to="#">클래스</b-nav-item>
          <b-nav-item to="#">스토어</b-nav-item>
          <b-nav-item to="#">커뮤니티</b-nav-item>
          <b-nav-item to="#">공지사항</b-nav-item>
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
            <b-avatar href="#" src="https://placekitten.com/300/300"></b-avatar>
          </v-avatar>

          <b-nav-item-dropdown right>
            <!-- Using 'button-content' slot -->
            <template #button-content>
              <em>{{ $store.state.username }}</em>
            </template>
            <b-dropdown-item href="#">Profile</b-dropdown-item>
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
export default {
  computed: {
    isUserLogin() {
      return this.$store.getters.isLogin;
    },
    logoLink() {
      return this.$store.getters.isLogin ? '/main' : '/user';
    },
  },
  methods: {
    logoutUser() {
      this.$store.commit('clearUsername');
      this.$store.commit('clearToken');
      deleteCookie('til_auth');
      deleteCookie('til_user');
      this.$router.push('/user');
    },
  },
};
</script>

<style></style>
