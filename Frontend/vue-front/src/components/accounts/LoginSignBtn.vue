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
    <v-btn @click="onClickKakaoAPI()">카카오 로그인/회원가입</v-btn>
  </div>
</template>

<script>
export default {
  methods: {
    async onClickKakaoAPI() {
      try {
        window.open(
          'https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=2ce9bedc0889520f06b58f54d0724e65&redirect_uri=http://localhost:8000/dazu/login&response_type=code">LOGIN',
        );
        console.log('goto vuex');
        await this.$store.dispatch('LOGIN');
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style></style>
