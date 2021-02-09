<template>
  <!-- <div id="app"> -->
  <v-app id="app">
    <div v-if="isUserLogin" class="mb-10">
      <AppHeader></AppHeader>
    </div>
    <div class="mt-16"><router-view></router-view></div>
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
