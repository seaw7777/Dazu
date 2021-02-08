<template>
  <div>
    <v-container class="grey lighten-5">
      <v-row v-for="n in 5" :key="n">
        <v-col v-for="k in 2" :key="k">
          <div v-if="k === 1">
            <p @click="titleClick(bestFamousStoreList[n - 1].board_code)">
              {{ n }} {{ bestFamousStoreList[n - 1].board_title }}
            </p>
          </div>
          <div v-else>
            <p @click="titleClick(bestFamousStoreList[n + 4].board_code)">
              {{ n + 5 }} {{ bestFamousStoreList[n + 4].board_title }}
            </p>
          </div>
        </v-col>
      </v-row>
    </v-container>
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

<style></style>
