<template>
  <div>
    <v-container>
      <v-row>
        <v-col cols="8">
          <StoreName :storeName="storeName"></StoreName>
        </v-col>
        <v-col cols="4">
          <v-row><StoreClassList></StoreClassList></v-row>
        </v-col>
      </v-row>
      <v-row>
        <StoreAdress></StoreAdress>
      </v-row>
      <v-row>
        <StoreDetail></StoreDetail>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import StoreAdress from '@/components/stores/StoreAdress.vue';
import StoreClassList from '@/components/stores/StoreClassList.vue';
import StoreDetail from '@/components/stores/StoreDetail.vue';
import StoreName from '@/components/stores/StoreName.vue';
import { MypageOwnerInfo } from '@/api/mypage';
export default {
  components: {
    StoreAdress,
    StoreClassList,
    StoreDetail,
    StoreName,
  },
  data() {
    return {
      storeData: [],
      storeName: String,
    };
  },
  async created() {
    const usercode = this.$store.state.usercode;
    const res = await MypageOwnerInfo(usercode);
    this.storeData = res.data;
    this.storeName = res.data.store_name;
    console.log(this.storeName);
  },
};
</script>

<style></style>
