<template>
  <div>
    <router-link to="/">
      <v-img
        :src="require('@/assets/DAZUlogo.png')"
        max-height="150"
        max-width="250"
        to="/afiliacion"
        width="100%"
      >
      </v-img>
    </router-link>
    <h1>DAZU 설명</h1>

    <!-- <v-btn @click="onClickKakaoAPI">카카오 로그인/회원가입</v-btn> -->
    <img
      class="kakao_btn"
      src="@/assets/kakao_login_medium_narrow.png"
      @click="onClickKakaoAPI"
    />
  </div>
</template>

<script>
export default {
  created: {},
  methods: {
    async onClickKakaoAPI() {
      const params = {
        redirectUri: 'http://https://i4d104.p.ssafy.io/user',
      };
      window.Kakao.Auth.authorize(params);
    },
  },
};
</script>

<style></style>
