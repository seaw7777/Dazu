<template>
  <div>
    <v-container fluid class="choice-container">
      <v-row justify="space-around">
        <v-col cols="4">
          <div>
            <div class="owner-tag">
              <v-img
                class="owner-img"
                to="user/customerstep"
                src="@/assets/img/owner-choice.png"
              >
              </v-img>
            </div>
            <router-link to="/user/ownerstep">
              <v-img
                class="owner-img"
                to="/user/ownerstep"
                src="@/assets/img/owner.png"
              >
              </v-img>
            </router-link>
          </div>
        </v-col>
        <v-col cols="1">
          <v-img
            class="fork-img"
            to="/user/ownerstep"
            src="@/assets/img/fork.png"
          >
          </v-img>
        </v-col>

        <v-col cols="4">
          <div class="customer-tag">
            <v-img
              class="customer-img"
              to="user/customerstep"
              src="@/assets/img/customer-choice.png"
            >
            </v-img>
          </div>
          <router-link to="/user/customerstep">
            <v-img
              class="customer-img"
              to="user/customerstep"
              src="@/assets/img/customer.png"
            >
            </v-img>
          </router-link>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.fork-img {
  position: absolute;
  top: 30%;
}
.choice-container {
  margin-top: 60px;
}
.owner-img {
  width: 300px;
  margin-right: auto;
  margin-left: auto;
}
.customer-img {
  width: 300px;
  margin-right: auto;
  margin-left: auto;
}
.breadcrumb-option {
  position: absolute;
  left: 20%;
}
.owner-tag {
  text-align: center;
}
.customer-tag {
  text-align: center;
}
</style>
