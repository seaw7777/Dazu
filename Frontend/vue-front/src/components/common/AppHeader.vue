<template>
  <div>
    <!-- Header Section Begin -->
    <header class="header">
      <div class="header__top">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              <div class="header__top__inner">
                <div class="header__top__left">
                  <div class="testimonial__author__pic">
                    <img :src="userImgUrl" alt="" />
                  </div>
                  <ul>
                    <li>
                      {{ $store.state.username }}
                      <span class="arrow_carrot-down"></span>
                      <ul>
                        <router-link :to="mypageLink" tag="li"
                          >Mypage</router-link
                        >
                        <li @click="logoutUser">Logout</li>
                      </ul>
                    </li>
                  </ul>
                </div>
                <div class="header__logo">
                  <router-link :to="'/main'" tag="a"
                    ><img src="img/logo.png" alt=""
                  /></router-link>
                </div>
                <div class="header__top__right">
                  <div class="header__top__right__links">
                    <a href="#" class="search-switch"
                      ><img src="img/icon/search.png" alt=""
                    /></a>
                    <a href="#"><img src="img/icon/heart.png" alt=""/></a>
                  </div>
                  <div class="header__top__right__cart"></div>
                </div>
              </div>
            </div>
          </div>
          <div class="canvas__open"><i class="fa fa-bars"></i></div>
        </div>
      </div>
      <div class="header-container">
        <div class="row">
          <div class="col-lg-12">
            <nav class="header__menu mobile-menu">
              <ul>
                <li>
                  <router-link :to="'/main'" tag="a">Home</router-link>
                </li>
                <li>
                  <router-link :to="'/class/list'" tag="a">클래스</router-link>
                </li>
                <li>
                  <router-link :to="'/mealkit/list'" tag="a"
                    >스토어</router-link
                  >
                </li>
                <li>
                  <router-link :to="'/community'" tag="a">커뮤니티</router-link>
                </li>
                <li>
                  <router-link :to="'/notice/list'" tag="a"
                    >공지사항</router-link
                  >
                </li>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </header>
    <!-- Header Section End -->
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
      return this.$store.getters.isUserType
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

<style>
/* scoped src="@/assets/css/nice-select.css" */
.header-container {
  height: 73px;
}
</style>
