<template>
  <div>
    <v-container class="grey lighten-5">
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
    </v-container>
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

<style></style>
