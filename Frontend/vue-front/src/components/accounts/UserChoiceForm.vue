<template>
  <div>
    <v-container fluid>
      <v-row justify="space-around">
        <v-col cols="5">
          <router-link to="/user/ownerstep">
            <v-img
              to="/user/ownerstep"
              :src="require('@/assets/logo.png')"
              max-width="60"
              width="100%"
            >
            </v-img>
            사장님
          </router-link>
        </v-col>
        <v-col cols="5">
          <router-link to="/user/customerstep">
            <v-img
              to="user/customerstep"
              :src="require('@/assets/logo.png')"
              max-width="60"
              width="100%"
            >
            </v-img>
            고객님
          </router-link>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
