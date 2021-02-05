<template>
  <!-- <div id="app"> -->
  <v-app>
    <div v-if="isUserLogin">
      <AppHeader></AppHeader>
    </div>
    <router-view></router-view>
  </v-app>
</template>

<script>
import AppHeader from './components/common/AppHeader.vue';

export default {
  name: 'App',

  components: {
    AppHeader,
  },
  computed: {
    isUserLogin() {
      return this.$store.getters.isLogin;
    },
  },
};
</script>
