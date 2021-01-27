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
      window.open(
        'https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=///&redirect_uri=http://localhost:8000/dazu/login&response_type=code">LOGIN',
      );
      try {
        await this.$store.dispatch('LOGIN');
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style></style>
