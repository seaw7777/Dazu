<template>
  <div>
    <h6 class="checkout__title">Comming Up Classes</h6>
    <v-sheet class="mx-auto" elevation="0" max-width="800">
      <v-slide-group
        v-model="model"
        class="pa-4"
        active-class="success"
        show-arrows
      >
        <v-slide-item
          v-for="comingItem in comingList"
          :key="comingItem.classcode"
        >
          <v-card
            elevation="0"
            :color="active ? undefined : 'grey lighten-1'"
            class="ma-4"
            @click="classclick(comingItem.classcode)"
          >
            <MypageComingClassItem
              :comingItem="comingItem"
            ></MypageComingClassItem>
          </v-card>
        </v-slide-item>
      </v-slide-group>
    </v-sheet>
  </div>
</template>

<script>
import { MypageCustomerComingClass } from '@/api/mypage';

import MypageComingClassItem from '@/components/customer_mypages/MypageComingClassItem.vue';
export default {
  data() {
    return {
      comingList: [],
    };
  },
  components: {
    MypageComingClassItem,
  },
  methods: {
    classclick(classid) {
      this.$router.push(`/class/detail/${classid}`);
    },
  },

  async created() {
    const userid = this.$store.state.usercode;
    console.log(userid);
    const res = await MypageCustomerComingClass(userid);
    console.log('coming!!' + res.data);
    this.comingList = res.data;
  },
};
</script>

<style></style>
