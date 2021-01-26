<template>
  <v-container fluid>
    <v-row justify="space-around">
      <v-col cols="5">
        <router-link to="/signup/ownerstep">
          <v-img
            :src="require('@/assets/logo.png')"
            max-width="60"
            to="/afiliacion"
            width="100%"
          >
          </v-img>
        </router-link>
      </v-col>
      <v-col cols="5">
        <router-link to="/signup/customerstep">
          <v-img
            :src="require('@/assets/logo.png')"
            max-width="60"
            to="/afiliacion"
            width="100%"
          >
          </v-img>
        </router-link>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {};
</script>

<style></style>
