<template>
  <div>
    <v-container class="grey lighten-5">
      <v-row v-for="n in 5" :key="n">
        <v-col v-for="k in 2" :key="k">
          <div v-if="k === 1">
            <p>{{ n }} {{ bestTipList[n - 1].board_title }}</p>
          </div>
          <div v-else>
            <p>{{ n + 5 }} {{ bestTipList[n + 4].board_title }}</p>
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
};
</script>

<style></style>
