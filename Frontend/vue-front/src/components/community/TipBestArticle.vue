<template>
  <div>
    <section class="testimonial spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <div class="section-title">
              <span>Today</span>
              <h2>Best Tip</h2>
            </div>
          </div>
        </div>
        <hr />
        <div>
          <v-row v-for="n in 5" :key="n">
            <v-col v-for="k in 2" :key="k">
              <div v-if="k === 1">
                <p
                  font-size="1.5rem"
                  @click="titleClick(bestTipList[n - 1].board_code)"
                >
                  {{ n }} {{ bestTipList[n - 1].board_title }}
                </p>
              </div>
              <div v-else>
                <p @click="titleClick(bestTipList[n + 4].board_code)">
                  {{ n + 5 }} {{ bestTipList[n + 4].board_title }}
                </p>
              </div>
            </v-col>
          </v-row>
        </div>
      </div>
    </section>
    <!-- <v-container class="grey lighten-5">
      <v-row v-for="n in 5" :key="n">
        <v-col v-for="k in 2" :key="k">
          <div v-if="k === 1">
            <p @click="titleClick(bestTipList[n - 1].board_code)">
              {{ n }} {{ bestTipList[n - 1].board_title }}
            </p>
          </div>
          <div v-else>
            <p @click="titleClick(bestTipList[n + 4].board_code)">
              {{ n + 5 }} {{ bestTipList[n + 4].board_title }}
            </p>
          </div>
        </v-col>
      </v-row>
    </v-container> -->
  </div>
</template>

<script>
import { getBestTip } from '@/api/community';
export default {
  data() {
    return {
      bestTipList: [],
    };
  },
  async created() {
    const bestTips = await getBestTip();
    this.bestTipList = bestTips.data;
  },
  methods: {
    titleClick(id) {
      this.$router.push(`/community/tip/detail/${id}`);
    },
  },
};
</script>

<style scoped>
p {
  font-size: 1.5rem;
}
</style>
