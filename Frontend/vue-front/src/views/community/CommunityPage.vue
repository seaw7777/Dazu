<template>
  <div>
    <h3>BEST 게시글</h3>
    <div v-if="tab === true">
      <TipBestArticle></TipBestArticle>
    </div>
    <div v-else>
      <FamousStoreBestArticle></FamousStoreBestArticle>
    </div>
    <v-tabs>
      <v-tab class="tab1" @click="clickTip">꿀팁 공유</v-tab>
      <v-tab class="tab2" @click="clickFamousStore">맛집 정보</v-tab>
    </v-tabs>
    <div>
      <div v-if="tab === true">
        <TipList></TipList>
      </div>
      <div v-else>
        <FamousStoreList></FamousStoreList>
      </div>
    </div>
  </div>
</template>

<script>
import FamousStoreBestArticle from '@/components/community/FamousStoreBestArticle.vue';
import TipBestArticle from '@/components/community/TipBestArticle.vue';
import FamousStoreList from '@/components/community/FamousStoreList.vue';
import TipList from '@/components/community/TipList.vue';
export default {
  components: {
    FamousStoreBestArticle,
    TipBestArticle,
    FamousStoreList,
    TipList,
  },
  data() {
    return {
      tab: true,
    };
  },
  methods: {
    clickTip() {
      this.tab = true;
    },
    clickFamousStore() {
      this.tab = false;
    },
  },
};
</script>

<style scoped>
.tab1 {
  font-size: 30px;
}
.tab2 {
  font-size: 30px;
}
</style>
