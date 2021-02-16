<template>
  <div>
    <div class="breadcrumb-option">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-6">
            <div class="breadcrumb__text">
              <h2>My Store</h2>
            </div>
          </div>
        </div>
      </div>
    </div>
    <section class="shopping-cart spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-8">
            <StoreClassList></StoreClassList>
          </div>
          <div class="col-lg-4">
            <StoreName :storeData="storeData"></StoreName>
            <StoreAdress :storeData="storeData"></StoreAdress>
            <StoreDetail :storeData="storeData">></StoreDetail>
          </div>
        </div>
      </div>
    </section>

    <!-- <v-container>
      <v-row>
        <v-col cols="8">
          <StoreName :storeData="storeData"></StoreName>
        </v-col>
        <v-col cols="4">
          <v-row><StoreClassList></StoreClassList></v-row>
        </v-col>
      </v-row>
      <v-row>
        <StoreAdress :storeData="storeData"></StoreAdress>
      </v-row>
      <v-row>
        <StoreDetail :storeData="storeData">></StoreDetail>
      </v-row>
    </v-container> -->
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
