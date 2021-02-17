<template>
  <div>
    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-6">
            <div class="breadcrumb__text">
              <h2>Community</h2>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="product__details__tab">
      <div class="col-lg-12">
        <ul class="nav nav-tabs" role="tablist">
          <li class="nav-item">
            <a
              @click="clickTip"
              class="nav-link active"
              data-toggle="tab"
              href="#tabs-1"
              role="tab"
              ><font size="5rem">꿀팁 공유</font></a
            >
          </li>
          <li class="nav-item">
            <a
              @click="clickFamousStore"
              class="nav-link"
              data-toggle="tab"
              href="#tabs-2"
              role="tab"
              ><font size="5rem">맛집공유</font></a
            >
          </li>
        </ul>
        <div class="tab-content">
          <div class="tab-pane active" id="tabs-1" role="tabpanel">
            <div class="row d-flex justify-content-center">
              <div class="col-lg-12">
                <div v-if="tab === true">
                  <TipBestArticle></TipBestArticle>
                </div>
              </div>
            </div>
          </div>
          <div class="tab-pane" id="tabs-2" role="tabpanel">
            <div class="row d-flex justify-content-center">
              <div class="col-lg-12">
                <div v-if="tab === false">
                  <FamousStoreBestArticle></FamousStoreBestArticle>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="tab-container">
      <div class="tab">
        <div v-if="tab === true">
          <TipList></TipList>
        </div>
        <div v-else>
          <FamousStoreList></FamousStoreList>
        </div>
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
.nav-item {
  font-size: 1.2rem;
}
</style>
