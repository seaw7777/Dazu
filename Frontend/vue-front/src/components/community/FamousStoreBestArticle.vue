<template>
  <div>
    <section class="testimonial spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <div class="section-title">
              <span>Today</span>
              <h2>Best Restaurant</h2>
            </div>
          </div>
        </div>
        <hr />
        <div class="best-post">
          <v-row v-for="n in 5" :key="n">
            <v-col v-for="k in 2" :key="k">
              <div v-if="k === 1">
                <p
                  class="text-center"
                  @click="titleClick(bestFamousStoreList[n - 1].board_code)"
                >
                  {{ n }}. {{ bestFamousStoreList[n - 1].board_title }}
                </p>
              </div>
              <div v-else>
                <p @click="titleClick(bestFamousStoreList[n + 4].board_code)">
                  {{ n + 5 }}. {{ bestFamousStoreList[n + 4].board_title }}
                </p>
              </div>
            </v-col>
          </v-row>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import { getBestFamousStore } from '@/api/community';
export default {
  data() {
    return {
      bestFamousStoreList: [],
    };
  },
  async created() {
    const bestFamousStores = await getBestFamousStore();
    this.bestFamousStoreList = bestFamousStores.data;
  },
  methods: {
    titleClick(id) {
      this.$router.push(`/community/famousstore/detail/${id}`);
    },
  },
};
</script>

<style scoped>
p {
  display: flex;
  font-size: 1.5rem;
}
.best-post {
  margin: 2rem;
}
.product__details__tab .tab-content p {
  color: #444444;
  line-height: 30px;
  text-align: center;
  padding-top: 0px;
  margin-bottom: 0;
  font-size: 1.2rem;
}
</style>
