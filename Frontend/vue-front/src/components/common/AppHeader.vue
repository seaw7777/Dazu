<template>
  <div>
    <!-- Header Section Begin -->
    <header class="header">
      <div class="header__top">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              <div class="header__top__inner">
                <div class="header__logo" style="left: 45%;">
                  <router-link :to="'/main'" tag="a"
                    ><img src="img/DAZUlogo_v2.png" alt=""
                  /></router-link>
                </div>

                <div class="userlogo">
                  <div class="testimonial__author__pic">
                    <img :src="userImgUrl" alt="" />
                  </div>

                  <ul class="user-down" style="padding-left: 10px;">
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
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-lg-12">
          <ul class="menu">
            <div class="menu-item">
              <router-link
                :to="'/main'"
                tag="a"
                class="menu-link"
                style="color:white"
                >Home</router-link
              >
            </div>
            <div class="menu-item">
              <router-link
                :to="'/class/list'"
                tag="a"
                class="menu-link"
                style="color:white"
                >클래스</router-link
              >
            </div>
            <div class="menu-item">
              <router-link
                :to="'/mealkit/list'"
                tag="a"
                class="menu-link"
                style="color:white"
                >스토어</router-link
              >
            </div>
            <div class="menu-item">
              <router-link
                :to="'/community'"
                tag="a"
                class="menu-link"
                style="color:white"
                >커뮤니티</router-link
              >
            </div>
            <div class="menu-item">
              <router-link
                :to="'/notice/list'"
                tag="a"
                class="menu-link"
                style="color:white"
                >공지사항</router-link
              >
            </div>
          </ul>
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

<style scoped>
.menu {
  display: flex;
  width: 100%;
  padding-right: 24px;
}
.menu-item {
  /* flex-grow: 1; */
  width: 25%;
  background: #f08632;
  transition: 0.5s;
}
.menu-item:hover {
  /* flex-grow: 1.5; */
  color: white;
  width: 35%;
  background: black;
}
.menu-link {
  display: block;
  padding: 1em;
  font-size: 1.4rem;
  font-weight: bold;
  color: #555;
  text-decoration: none;
  text-align: center;
}
.menu-link:hover {
  color: white;
}

.header__logo {
  width: 250px;
  margin-bottom: 10px;
}
.header__logo {
  position: absolute;
  left: 45%;
  top: 25px;
  bottom: 10px;
  margin-left: -60px;
}
.userlogo {
  float: right;
}
.userlogo ul li {
  font-size: px;
  color: #111111;
  list-style: none;
  display: inline-block;
  margin-right: 30px;
  position: relative;
  padding: 2px 0;
  cursor: pointer;
}
.userlogo ul li a {
  color: #111111;
}
.userlogo ul li:hover ul {
  top: 24px;
  opacity: 1;
  visibility: visible;
}
.userlogo ul li ul {
  background: #111111;
  display: inline-block;
  padding: 2px 0;
  position: absolute;
  left: 0;
  top: 44px;
  opacity: 0;
  visibility: hidden;
  z-index: 3;
  -webkit-transition: all, 0.3s;
  -o-transition: all, 0.3s;
  transition: all, 0.3s;
}
.userlogo ul li ul li {
  list-style: none;
  font-size: 13px;
  color: #ffffff;
  padding: 2px 15px;
  cursor: pointer;
}
.userlogo ul li ul li:after {
  display: none;
}
.userlogo ul li:after {
  position: absolute;
  right: -19px;
  top: 1px;
  content: '|';
  color: #bbbbbb;
}
.userlogo ul li:last-child {
  margin-right: 0;
}
.userlogo ul li:last-child:after {
  display: none;
}
.userlogo ul li span {
  color: #888888;
}
.user-down {
  padding: 2px;
}
</style>
