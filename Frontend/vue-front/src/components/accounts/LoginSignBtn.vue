<template>
  <div class="container" onclick="onclick">
    <div class="top"></div>
    <div class="bottom"></div>
    <div class="center">
      <div class="login-container">
        <div class="dazu-logo">
          <h3 class="login">LOGIN</h3>
          <v-img
            :src="require('@/assets/img/DAZUlogo_v2.png')"
            max-height="150"
            max-width="250"
            to="/afiliacion"
            width="100%"
          >
          </v-img>
        </div>

        <img
          class="kakao_btn"
          src="@/assets/kakao_login_medium_narrow.png"
          @click="onClickKakaoAPI"
        />

        <!-- <v-btn @click="onClickKakaoAPI">카카오 로그인/회원가입</v-btn> -->
      </div>

      <h2>&nbsp;</h2>
    </div>
  </div>
</template>

<script>
export default {
  created: {},
  methods: {
    async onClickKakaoAPI() {
      const params = {
        // redirectUri: 'http://localhost:8080/user',
        redirectUri: 'https://i4d104.p.ssafy.io/user',
      };
      window.Kakao.Auth.authorize(params);
    },
  },
};
</script>

<style scoped>
.login-container {
  display: flex;
  flex-direction: column;
  position: absolute;
  top: 25%;
  left: 20%;
}
.kakao_btn {
  width: 250px;
}
.breadcrumb__text {
  width: 400px;
  /* position: absolute; */
  /* left: 10%; */
}
.login {
  color: black;
  position: absolute;
  left: 23%;
  bottom: 81%;
}
@import url('https://fonts.googleapis.com/css?family=Raleway:400,700');
*,
*:before,
*:after {
  box-sizing: border-box;
}

body {
  min-height: 100vh;
  font-family: 'Raleway', sans-serif;
}

.container {
  position: absolute;
  width: 100%;
  height: 100%;
  overflow: hidden;
}
.container:hover .top:before,
.container:hover .top:after,
.container:hover .bottom:before,
.container:hover .bottom:after,
.container:active .top:before,
.container:active .top:after,
.container:active .bottom:before,
.container:active .bottom:after {
  margin-left: 200px;
  transform-origin: -200px 50%;
  transition-delay: 0s;
}
.container:hover .center,
.container:active .center {
  opacity: 1;
  transition-delay: 0.2s;
}

.top:before,
.top:after,
.bottom:before,
.bottom:after {
  content: '';
  display: block;
  position: absolute;
  width: 200vmax;
  height: 200vmax;
  top: 50%;
  left: 50%;
  margin-top: -100vmax;
  transform-origin: 0 50%;
  transition: all 0.5s cubic-bezier(0.445, 0.05, 0, 1);
  z-index: 10;
  opacity: 0.65;
  transition-delay: 0.2s;
}

.top:before {
  transform: rotate(45deg);
  background: #f59c1e;
}
.top:after {
  transform: rotate(135deg);
  background: #f53b74;
}

.bottom:before {
  transform: rotate(-45deg);
  background: #f5a40c;
}
.bottom:after {
  transform: rotate(-135deg);
  background: #f55200;
}

.center {
  position: absolute;
  width: 400px;
  height: 400px;
  top: 50%;
  left: 50%;
  margin-left: -200px;
  margin-top: -200px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 30px;
  opacity: 0;
  transition: all 0.5s cubic-bezier(0.445, 0.05, 0, 1);
  transition-delay: 0s;
  color: #333;
}
.center input {
  width: 100%;
  padding: 15px;
  margin: 5px;
  border-radius: 1px;
  border: 1px solid #ccc;
  font-family: inherit;
}
</style>
