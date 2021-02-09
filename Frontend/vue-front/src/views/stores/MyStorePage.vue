<template>
  <div>
    <v-container>
      <v-row>
        <v-col cols="8">
          <StoreName></StoreName>
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
    return {};
  },
  async created() {
    const id = this.$route.params.id;
    const ownerData = await MypageOwnerInfo(id);
    console.log(ownerData);
  },
};
</script>

<style></style>
